package com.chenshun.learnsummarize.util;

import android.util.Log;

import com.chenshun.learnsummarize.BuildConfig;

/**
 * User: chenshun <p />
 * Time: 16/10/13 16:32  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public final class Logs
{
    public static final String LOGTAG = Logs.class.getSimpleName();
    public static final boolean IS_DEBUG = BuildConfig.LOG_DEBUG;

    /** 'System.out' switch.When it is true, you can see the 'System.out' log. Otherwise, you cannot. */
    public static final boolean DEBUG_SYSOUT = false;

    /**
     * Don't let anyone instantiate this class.
     */
    private Logs()
    {
        throw new Error("Do not need instantiate!");
    }

    public static void v(Object msg)
    {
        if (IS_DEBUG)
        {
            Log.v(LOGTAG, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void v(String tag, Object msg)
    {
        if (IS_DEBUG)
        {
            Log.v(tag, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void v(String tag, Object msg, Throwable t)
    {
        if (IS_DEBUG)
        {
            Log.v(tag, msg != null ? msg.toString() : "msg == null", t);
        }
    }

    public static void d(Object msg)
    {
        if (IS_DEBUG)
        {
            Log.d(LOGTAG, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void d(String tag, Object msg)
    {
        if (IS_DEBUG)
        {
            Log.d(tag, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void d(String tag, Object msg, Throwable t)
    {
        if (IS_DEBUG)
        {
            Log.d(tag, msg != null ? msg.toString() : "msg == null", t);
        }
    }

    public static void i(Object msg)
    {
        if (IS_DEBUG)
        {
            Log.i(LOGTAG, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void i(String tag, Object msg)
    {
        if (IS_DEBUG)
        {
            Log.i(tag, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void i(String tag, Object msg, Throwable t)
    {
        if (IS_DEBUG)
        {
            Log.i(tag, msg != null ? msg.toString() : "msg == null", t);
        }
    }

    public static void w(Object msg)
    {
        if (IS_DEBUG)
        {
            Log.w(LOGTAG, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void w(String tag, Object msg)
    {
        if (IS_DEBUG)
        {
            Log.w(tag, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void w(String tag, Object msg, Throwable t)
    {
        if (IS_DEBUG)
        {
            Log.w(tag, msg != null ? msg.toString() : "msg == null", t);
        }
    }

    public static void e(Object msg)
    {
        if (IS_DEBUG)
        {
            Log.e(LOGTAG, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void e(String tag, Object msg)
    {
        if (IS_DEBUG)
        {
            Log.e(tag, msg != null ? msg.toString() : "msg == null");
        }
    }

    public static void e(String tag, Object msg, Throwable t)
    {
        if (IS_DEBUG)
        {
            Log.e(tag, msg != null ? msg.toString() : "msg == null", t);
        }
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen. The
     * error will always be logged at level ASSERT with the call stack.
     * Depending on system configuration, a report may be added to the
     * {@link android.os.DropBoxManager} and/or the process may be terminated
     * immediately with an error dialog.
     *
     * @param tag
     *         Used to identify the source of a log message.
     * @param msg
     *         The message you would like logged.
     */
    public static void wtf(String tag, String msg)
    {
        if (IS_DEBUG)
        {
            Log.wtf(tag, msg);
        }
    }

    /**
     * Send a {@link android.util.Log#VERBOSE} log message. And just print method name and
     * position in black.
     */
    public static void print()
    {
        if (IS_DEBUG)
        {
            String tag = getClassName();
            String method = callMethodAndLine();
            Log.v(tag, method);
            if (DEBUG_SYSOUT)
            {
                System.out.println(tag + "  " + method);
            }
        }
    }

    /**
     * Send a {@link #IS_DEBUG} log message.
     *
     * @param object
     *         The object to print.
     */
    public static void print(Object object)
    {
        if (IS_DEBUG)
        {
            String tag = getClassName();
            String method = callMethodAndLine();
            String content = "";
            if (object != null)
            {
                content = object.toString() + "                    ----    " + method;
            }
            else
            {
                content = " ## " + "                ----    " + method;
            }
            Log.d(tag, content);
            if (DEBUG_SYSOUT)
            {
                System.out.println(tag + "  " + content + "  " + method);
            }
        }
    }

    /**
     * Send an {@link android.util.Log#ERROR} log message.
     *
     * @param object
     *         The object to print.
     */
    public static void printError(Object object)
    {
        if (IS_DEBUG)
        {
            String tag = getClassName();
            String method = callMethodAndLine();
            String content = "";
            if (object != null)
            {
                content = object.toString() + "                    ----    " + method;
            }
            else
            {
                content = " ## " + "                    ----    " + method;
            }
            Log.e(tag, content);
            if (DEBUG_SYSOUT)
            {
                System.err.println(tag + "  " + method + "  " + content);
            }
        }
    }

    /**
     * Print the array of stack trace elements of this method in black.
     *
     * @return
     */
    public static void printCallHierarchy()
    {
        if (IS_DEBUG)
        {
            String tag = getClassName();
            String method = callMethodAndLine();
            String hierarchy = getCallHierarchy();
            Log.v(tag, method + hierarchy);
            if (DEBUG_SYSOUT)
            {
                System.out.println(tag + "  " + method + hierarchy);
            }
        }
    }

    /**
     * Print debug log in blue.
     *
     * @param object
     *         The object to print.
     */
    public static void printMyLog(Object object)
    {
        if (IS_DEBUG)
        {
            String tag = "MYLOG";
            String method = callMethodAndLine();
            String content = "";
            if (object != null)
            {
                content = object.toString() + "                    ----    " + method;
            }
            else
            {
                content = " ## " + "                ----    " + method;
            }
            Log.d(tag, content);
            if (DEBUG_SYSOUT)
            {
                System.out.println(tag + "  " + content + "  " + method);
            }
        }
    }

    private static String getCallHierarchy()
    {
        String result = "";
        StackTraceElement[] trace = (new Exception()).getStackTrace();
        for (int i = 2; i < trace.length; i++)
        {
            result += "\r\t" + trace[i].getClassName() + "" + trace[i].getMethodName() + "():" + trace[i].getLineNumber();
        }
        return result;
    }

    private static String getClassName()
    {
        String result = "";
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        result = thisMethodStack.getClassName();
        return result;
    }

    /**
     * Realization of double click jump events.
     *
     * @return
     */
    private static String callMethodAndLine()
    {
        String result = "at ";
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        result += thisMethodStack.getClassName() + "";
        result += thisMethodStack.getMethodName();
        result += "(" + thisMethodStack.getFileName();
        result += ":" + thisMethodStack.getLineNumber() + ")  ";
        return result;
    }
}
