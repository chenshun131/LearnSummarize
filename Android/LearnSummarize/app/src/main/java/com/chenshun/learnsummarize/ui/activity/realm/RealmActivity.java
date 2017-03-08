package com.chenshun.learnsummarize.ui.activity.realm;

import android.content.res.Configuration;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.activity.realm.bean.CountryBean;
import com.chenshun.learnsummarize.util.Logs;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * User: chenshun <p />
 * Time: 17/1/14 21:00 <p />
 * Version V1.0  <p />
 * Description: this is used to Database Operation,the official website is https://realm.io<p />
 */
public class RealmActivity extends BaseActivity implements View.OnClickListener
{
    private final String TAG = this.getClass().getSimpleName();

    private TextView mContentInfoTv;
    private EditText mIdEt;
    private EditText mNameEt;
    private EditText mPopulationEt;
    private Button mAddB;
    private Button mDeleteB;
    private Button mUpdateB;
    private Button mSearchB;

    @Override
    public boolean handleNotifyMessage(Message msg)
    {
        return false;
    }

    @Override
    public boolean handleUIMessage(Message msg)
    {
        return false;
    }

    @Override
    public boolean handleMessage(Message msg)
    {
        return false;
    }

    @Override
    protected void initData()
    {
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.activity_realm);
        setTitle("Realm for Android");

        mContentInfoTv = (TextView) findViewById(R.id.realm_content_info_tv);
        mIdEt = (EditText) findViewById(R.id.realm_id_et);
        mNameEt = (EditText) findViewById(R.id.realm_name_et);
        mPopulationEt = (EditText) findViewById(R.id.realm_population_et);
        mAddB = (Button) findViewById(R.id.realm_add_b);
        mDeleteB = (Button) findViewById(R.id.realm_delete_b);
        mUpdateB = (Button) findViewById(R.id.realm_update_b);
        mSearchB = (Button) findViewById(R.id.realm_search_b);

//        create();
//        transactionCopy();
//        update();
//        find();
//        delete();

        bindOnClickLister(this, mAddB, mDeleteB, mUpdateB, mSearchB);
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "RealmActivity";
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.realm_add_b:
                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction()
                {
                    @Override
                    public void execute(Realm realm)
                    {
                        CountryBean bean = realm.createObject(CountryBean.class);
                        bean.setId(mIdEt.getText().toString());
                        bean.setName(mNameEt.getText().toString());
                        bean.setPopulation(Integer.valueOf(mPopulationEt.getText().toString()));
                        showInTextView("添加数据成功！");
                    }
                });
                break;
            case R.id.realm_delete_b:
                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction()
                {
                    @Override
                    public void execute(Realm realm)
                    {
                        RealmQuery query = realm.where(CountryBean.class);
                        String id = mIdEt.getText().toString();
                        String name = mNameEt.getText().toString();
                        String population = mPopulationEt.getText().toString();
                        if (!TextUtils.isEmpty(id))
                        {
                            query.equalTo("id", id);
                        }
                        if (!TextUtils.isEmpty(name))
                        {
                            query.equalTo("name", name);
                        }
                        if (!TextUtils.isEmpty(population))
                        {
                            query.equalTo("population", population);
                        }
                        boolean isSuccess = query.findAll().deleteAllFromRealm();
                        if (isSuccess)
                        {
                            showInTextView("数据删除成功！");
                        }
                    }
                });
                break;
            case R.id.realm_update_b:
                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction()
                {
                    @Override
                    public void execute(Realm realm)
                    {
                        RealmQuery query = realm.where(CountryBean.class);
                        String id = mIdEt.getText().toString();
                        String name = mNameEt.getText().toString();
                        String population = mPopulationEt.getText().toString();
                        if (!TextUtils.isEmpty(id))
                        {
                            query.equalTo("id", id);
                        }
                        if (!TextUtils.isEmpty(name))
                        {
                            query.equalTo("name", name);
                        }
                        if (!TextUtils.isEmpty(population))
                        {
                            query.equalTo("population", population);
                        }
                        RealmResults<CountryBean> allResults = query.findAll();
                        for (CountryBean c : allResults)
                        {
                            c.setName(name);
                            c.setPopulation(Integer.valueOf(population));
                            showInTextView("\n Id : " + c.getId() + "    Name : " + c.getName() + "    Population : " + c.getPopulation());
                        }
                    }
                });
                break;
            case R.id.realm_search_b:
                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction()
                {
                    @Override
                    public void execute(Realm realm)
                    {
                        RealmQuery query = realm.where(CountryBean.class);
                        String id = mIdEt.getText().toString();
                        String name = mNameEt.getText().toString();
                        String population = mPopulationEt.getText().toString();
                        if (!TextUtils.isEmpty(id))
                        {
                            query.equalTo("id", id);
                        }
                        if (!TextUtils.isEmpty(name))
                        {
                            query.equalTo("name", name);
                        }
                        if (!TextUtils.isEmpty(population))
                        {
                            query.equalTo("population", population);
                        }
                        RealmResults<CountryBean> allResults = query.findAll();
                        for (CountryBean c : allResults)
                        {
                            showInTextView("\n Id : " + c.getId() + "    Name : " + c.getName() + "    Population : " + c.getPopulation());
                        }
                    }
                });
                break;
        }
    }

    private void showInTextView(String content)
    {
        mContentInfoTv.setText(content);
    }

    private void create()
    {
        Realm realm = Realm.getDefaultInstance();
        if (realm.where(CountryBean.class).count() != 0)
        {
            return;
        }
        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                // user Realm to create object instance,so you can use setter to save data
                CountryBean bean = realm.createObject(CountryBean.class, "NO");

                // Set its fields
                bean.setName("Norway");
                bean.setPopulation(5165800);
            }
        });

        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                for (int i = 0; i < 10; i++)
                {
                    CountryBean bean = realm.createObject(CountryBean.class, UUID.randomUUID().toString());
                    bean.setName("user" + i);
                    bean.setPopulation(10 + i);
                }
                showInTextView("10条数据添加成功");
            }
        });

        realm.beginTransaction();
        CountryBean bean = realm.createObject(CountryBean.class, "NO");// if have primary key,must use this method
        bean.setName("Norway");
        bean.setPopulation(5165800);

        CountryBean bean0 = realm.createObject(CountryBean.class, "NO");
        bean0.setName("bean0");
        bean0.setPopulation(1111000);

        CountryBean countryBean;
        for (int i = 1; i <= 100; i++)
        {
            countryBean = realm.createObject(CountryBean.class);
            countryBean.setId("New NO : " + i);
            countryBean.setName("New Country : " + i);
            countryBean.setPopulation(5165800);
        }
        realm.commitTransaction();
    }

    private void transactionCopy()
    {
        // Create the object
        CountryBean bean = new CountryBean();
        bean.setId("RU");
        bean.setName("Russia");
        bean.setPopulation(146430430);

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        CountryBean countryBean = realm.copyToRealm(bean);// copy data in Realm
        realm.commitTransaction();
    }

    private void update()
    {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CountryBean> countres = realm.where(CountryBean.class).beginsWith("name", "New Country").findAll();
        realm.beginTransaction();

        int i = 1;
        for (CountryBean bean : countres)
        {
            bean.setName("beginTransaction => <= commitTransaction" + (++i));
        }

        realm.commitTransaction();
    }

    private void find()
    {
        Realm realm = Realm.getDefaultInstance();
        CountryBean bean = realm.where(CountryBean.class).equalTo("name", "user0").findFirst();
        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                CountryBean c = realm.where(CountryBean.class).equalTo("name", "user0").findFirst();
                c.setName("Name find");
                c.setArea(2000);
            }
        });
        Logs.d(TAG, "Id : " + bean.getId() + "    Name : " + bean.getName() + "    Population : " + bean.getPopulation());

        // find all data
        Logs.d(TAG, "findAll ======================");
        RealmResults<CountryBean> allResults = realm.where(CountryBean.class).findAll();
        for (CountryBean c : allResults)
        {
            Logs.d(TAG, "Id : " + c.getId() + "    Name : " + c.getName() + "    Population : " + c.getPopulation());
        }
        // List<CountryBean> users = allResults;  RealmResults can convert List

        // find begin prefix data
        Logs.d(TAG, "beginsWith ======================");
        RealmResults<CountryBean> beginResults = realm.where(CountryBean.class).beginsWith("name", "R").findAll();
        for (CountryBean c : beginResults)
        {
            Logs.d(TAG, "Id : " + c.getId() + "    Name : " + c.getName() + "    Population : " + c.getPopulation());
        }

        // sort data
        Logs.d(TAG, "findAllSorted ======================");
        RealmResults<CountryBean> sortResults = realm.where(CountryBean.class).findAllSorted("name", Sort.DESCENDING);
        for (CountryBean c : sortResults)
        {
            Logs.d(TAG, "Id : " + c.getId() + "    Name : " + c.getName() + "    Population : " + c.getPopulation());
        }

        // average
        double age = realm.where(CountryBean.class).findAll().average("population");
        showInTextView("average population : " + age);
    }

    private void delete()
    {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                CountryBean c = realm.where(CountryBean.class).equalTo("name", "user0").findFirst();
                c.deleteFromRealm();
            }
        });

        RealmResults<CountryBean> results = realm.where(CountryBean.class).findAll();
        realm.beginTransaction();

        // remove single match
        results.deleteFirstFromRealm();
        results.deleteLastFromRealm();

        // remove a single object
        CountryBean countryBean = results.get(5);
        countryBean.deleteFromRealm();

        // Delete all matches
        results.deleteAllFromRealm();

        realm.commitTransaction();
    }
}
