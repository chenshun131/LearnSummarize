package com.chenshun.learnsummarize.service;

import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

import com.chenshun.learnsummarize.constant.Constants;
import com.chenshun.learnsummarize.constant.SPConst;
import com.chenshun.learnsummarize.ui.util.Cache;
import com.chenshun.learnsummarize.util.Logs;
import com.chenshun.learnsummarize.util.PreferensesUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseBodyRequest;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static com.chenshun.learnsummarize.service.CoreService.Transaction.EVENT_REQUEST_CAPTCHA;

/**
 * User: chenshun <p />
 * Time: 16/10/14 08:44  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class CoreService extends Service
{
    private static final String TAG = "CoreService";
    private HandlerThread mTransactionThread;
    private TransactionHandler mTransactionHandler;
    private static CoreService sCoreService = null;
    private static List<Transaction> sPendingTransactions = new ArrayList<Transaction>();
    private LoginStatus mLoginStatus = LoginStatus.NO_LOGIN;// save login status
    private PreferensesUtil mPreferensesUtil;

    public static enum LoginStatus
    {
        /** on login */
        ONLOGIN,
        /** login ok */
        LOGIN_OK,
        /** not login or login failed */
        NO_LOGIN;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        sCoreService = this;
        mTransactionThread = new HandlerThread("sender thread", Process.THREAD_PRIORITY_BACKGROUND);
        mTransactionThread.start();
        mTransactionHandler = new TransactionHandler(mTransactionThread.getLooper());
        mPreferensesUtil = new PreferensesUtil(CoreService.this, SPConst.SP_USER);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Logs.i(TAG, "coreservice onStartCommand ... ");
        continuePendingTransaction();
        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        synchronized (sPendingTransactions)
        {
            // for (Transaction transaction : sPendingTransactions) {
            // }
            sPendingTransactions.clear();
        }
        mTransactionThread.getLooper().quit();
        sCoreService = null;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    /**
     * The method is exposed to XXManager,and all the request should call this method. if the service isn't running,we'll start service before doing the transaction.
     *
     * @param context
     * @param transaction
     */
    public static void requestTransaction(Context context, Transaction transaction)
    {
        if (sCoreService == null)
        {
            synchronized (CoreService.class)
            {
                Intent intent = new Intent(context, CoreService.class);
                intent.putExtra("StartService", true);
                context.startService(intent);
                addPendingTransaction(transaction);
                return;
            }
        }
        Message msg = Message.obtain();
        msg.obj = transaction;
        sCoreService.mTransactionHandler.sendMessage(msg);
    }

    /**
     * This Inner class used to handle the request transaction Before calling SDK method,we should be sure that the connection has built success.
     */
    private class TransactionHandler extends Handler
    {
        public TransactionHandler(Looper looper)
        {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            Transaction transaction = (Transaction) msg.obj;
            if (transaction == null)
            {
                Logs.i(TAG, "There is no transaction we need run...");
                return;
            }
            // filter Transaction
            switch (transaction.what)
            {
                case Transaction.EVENT_REQUEST_CAPTCHA:
                case Transaction.EVENT_REQUEST_LOGIN:
                    break;
                default:
                    if (mLoginStatus == LoginStatus.ONLOGIN)
                    {
                        addPendingTransaction(transaction);
                        return;
                    }
                    else if (mLoginStatus == LoginStatus.NO_LOGIN)
                    {
                        // TODO
                    }
                    break;
            }
            // if no has network
            if (!Cache.getInstance().isNetWorkIsOk())
            {
//                if (transaction.callback instanceof StringCallback)
//                {
//
//                    ((StringCallback) transaction.callback).showErrorDialog("no has network");
//                }
                return;
            }
            // filter some end
            doTransaction(transaction);
        }
    }

    public static class Transaction
    {
        public static final int EVENT_REQUEST_CAPTCHA = 1;// 验证码
        public static final int EVENT_REQUEST_LOGIN = 2;// 登录

        public int what;
        public Object object;
        public ContentValues values;
        public StringCallback callback;
        public String content;

        public Transaction()
        {
        }

        public Transaction(int what)
        {
            this.what = what;
        }

        public Transaction(int what, Object obj, StringCallback callback)
        {
            this.what = what;
            this.object = obj;
            this.callback = callback;
        }
    }

    /**
     * calling the sdk method
     *
     * @param transaction
     */
    private void doTransaction(final Transaction transaction)
    {
        ContentValues values = transaction.values;
        BaseBodyRequest baseBodyRequest = null;
        switch (transaction.what)
        {
            case Transaction.EVENT_REQUEST_CAPTCHA:// 获取验证码
                break;
            case Transaction.EVENT_REQUEST_LOGIN:// 登录
                baseBodyRequest = OkGo.post(Constants.LOGIN).params(Constants.ACCOUNT, values.getAsString(Constants.ACCOUNT)).params(Constants.PASSWORD, values.getAsString(Constants.PASSWORD)).params(Constants.IMGCODE, values.getAsString(Constants.IMGCODE));
                break;
            default:
        }
        if (baseBodyRequest != null)
        {
            baseBodyRequest.execute(new StringCallback()
            {
                @Override
                public void onSuccess(String s, Call call, Response response)
                {
                }
            });
        }
    }

    /**
     * Add the transaction to the pending list before the sdk initial success.
     *
     * @param transaction
     */
    private static void addPendingTransaction(Transaction transaction)
    {
        Logs.i(TAG, "addPendingTransaction..." + transaction.what);
        synchronized (sPendingTransactions)
        {
            // not include login operation
            if (transaction.what == Transaction.EVENT_REQUEST_LOGIN)
            {
                for (Transaction trans : sPendingTransactions)
                {
                    if (trans.what == Transaction.EVENT_REQUEST_LOGIN)
                    {
                        return;
                    }
                }
            }
            sPendingTransactions.add(transaction);
        }
    }

    /**
     * continue the pending transaction after login ok
     */
    private void continuePendingTransaction()
    {
        Logs.i(TAG, "continuePendingTransaction...");
        synchronized (sPendingTransactions)
        {
            int size = sPendingTransactions.size();
            for (int i = 0; i < size; i++)
            {
                if (sPendingTransactions.get(0).what == Transaction.EVENT_REQUEST_LOGIN)
                {
                    Logs.i(TAG, "continuePending -> LOGIN");
                    mLoginStatus = LoginStatus.ONLOGIN;
                }
                requestTransaction(this, sPendingTransactions.remove(0));
            }
        }
    }

    private void reLogin()
    {
//        LoginManager.getEncryptKey(this, "rsa", new BaseStringCallback(null)
//        {
//            @Override
//            public void onResponseResult(String response, String statusCode, JSONObject jo, Object tag)
//            {
//                if (Constants.STATUS_CODE_OK.equals(statusCode))
//                {
//                    JSONObject valueJO = jo.optJSONObject("value");
//                    String publicExponent = valueJO.optString("publicExponent");
//                    String modulus = valueJO.optString("modulus");
//                    LoginManager.doLogin(CoreService.this, modulus, publicExponent, Cache.getInstance().getPhoneNumber(), mPreferensesUtil.getString(SPConst.SP_USER_PASSWORD), "1",
//                            new BaseStringCallback(null)
//                            {
//                                @Override
//                                public void onResponseResult(String response, String statusCode, JSONObject jo, Object tag)
//                                {
//                                    if (Constants.STATUS_CODE_OK.equals(statusCode))
//                                    {
//                                        mLoginStatus = LoginStatus.LOGIN_OK;
//                                        continuePendingTransaction();
//                                    }
//                                    else
//                                    {
//                                        mLoginStatus = LoginStatus.NO_LOGIN;
//                                    }
//                                }
//
//                                @Override
//                                public void onError(Call call, Exception e)
//                                {
//                                    mLoginStatus = LoginStatus.NO_LOGIN;
//                                }
//                            });
//                }
//                else
//                {
//                    mLoginStatus = LoginStatus.NO_LOGIN;
//                }
//            }
//
//            @Override
//            public void onError(Call call, Exception e)
//            {
//                mLoginStatus = LoginStatus.NO_LOGIN;
//            }
//        });
    }
}
