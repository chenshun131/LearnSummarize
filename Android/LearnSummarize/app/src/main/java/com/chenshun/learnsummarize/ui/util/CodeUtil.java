package com.chenshun.learnsummarize.ui.util;

import com.chenshun.learnsummarize.util.Logs;

/**
 * User: chenshun <p />
 * Time: 16/10/15 22:43 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class CodeUtil
{
    private final static String TAG = CodeUtil.class.getSimpleName();

    /**
     * Command Code
     */
    public static class CmdCode
    {
        public static final int MSG_COMMON_HANDLE = 0xF0000001;

        public static class Mask
        {
            public static final int MSG_TYPE_MASK = 0x0FFFFFFF;
            public static final int MSG_TYPE_FILTER = ~MSG_TYPE_MASK;

            public static boolean verify(int mask, int code)
            {
                Logs.d(TAG, "verify mask = " + Integer.toHexString(mask) + " code = " + Integer.toHexString(code) + " (mask & code) = " + (mask & code));
                return (mask & code) == 0;
            }
        }

        public static class MsgTypeCode
        {
            public static final int UI_MSG = 0x10000000;
            public static final int NOTIFY_MSG = 0x20000000;

            public static int setUp(int orgCode, int orgMsgTypeCode)
            {
                int msgTypeCode = orgMsgTypeCode;
                if (!Mask.verify(Mask.MSG_TYPE_MASK, orgMsgTypeCode))
                {
                    msgTypeCode = orgMsgTypeCode & Mask.MSG_TYPE_FILTER;
                }
                return (orgCode & Mask.MSG_TYPE_MASK) | msgTypeCode;
            }
        }

        /**
         * whether code is MsgTypeCode.UI_MSG and code should be start with 0x1_ _ _ _ _ _ _
         *
         * @param code
         * @return
         */
        public static boolean isUICode(int code)
        {
            return (Mask.MSG_TYPE_FILTER & code) == MsgTypeCode.UI_MSG;
        }

        /**
         * whether code is MsgTypeCode.NOTIFY_MSG and code should be start with 0x2_ _ _ _ _ _ _
         *
         * @param code
         * @return
         */
        public static boolean isNotifyCode(int code)
        {
            return (Mask.MSG_TYPE_FILTER & code) == MsgTypeCode.NOTIFY_MSG;
        }

        public static class UIMsgCode
        {
            public static final int UI_TEST = 0x10000001;
        }

        public static class NotifyMsgCode
        {
            public static final int NOTIFY_TEST = 0x20000001;
        }
    }
}

