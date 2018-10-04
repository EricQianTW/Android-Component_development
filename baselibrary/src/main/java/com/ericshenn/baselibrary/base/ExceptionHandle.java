package com.ericshenn.baselibrary.base;

import android.content.Context;
import android.view.View;


/**
 * Created by eric_qiantw on 16/6/10.
 */
public class ExceptionHandle {
    // 当前class名
    protected final static String TAG = "ExceptionHandle";

    public static void handleError(Context mContext, String errorCode, String errorMessage) {
        try {
//            int code = -1;
//            if (errorCode != null) {
//                code = Integer.parseInt(errorCode);
//            }
//
//            if (ErrorCode.ERROR_CODE_NOTLOGIN == code) {
//
//            }
//
//            T.showShort(mContext,errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleError(Context mContext, View view, String errorCode, String errorMessage) {
        try {
//            int code = -1;
//            if (errorCode != null) {
//                code = Integer.parseInt(errorCode);
//            }
//
//            if (ErrorCode.ERROR_CODE_NOTLOGIN == code) {
//
//            } else if (ErrorCode.ERROR_CODE_NOTDEFALUTADDRESS == code) {
//                IntentUtils.startActivity(mContext, AddressListActivity.class);
//            } else if (ErrorCode.ERROR_CODE_NOTREGISTER == code) {
//
//            } else if (ErrorCode.ERROR_CODE_NOTADDRESS == code) {
//                IntentUtils.startActivity(mContext, AddressNewActivity.class);
//            } else if (ErrorCode.ERROR_CODE_ONLYONEDEVICE == code
//                    || ErrorCode.ERROR_CODE_NEEDLOGIN == code) {
////                SPUtils.put(mContext, SPUtils.SP_BOOLEAN_LOGIN, false);
////                SPUtils.remove(mContext, SPUtils.SP_STRING_USER);
////                IntentUtils.startActivity(mContext,MainActivity.class);
////                MainActivity.setIndex(3);
//            } else if (ErrorCode.ERROR_CODE_SETPAYPASSWORD == code) {
////                Intent intent = new Intent(mContext,PasswordFristActivity.class);
////                intent.putExtra(PasswordFristActivity.INTENTNAME_LOSTTYPE, Constants.LOSTTYPE_PAY);
////                intent.setFlags(intent.FLAG_ACTIVITY_NO_HISTORY);
////                mContext.startActivity(intent);
//
//            } else if (ErrorCode.ERROR_CODE_PERFECTUSERRESOURCE == code) {
////                IntentUtils.startActivity(mContext, PersonalActivity.class);
//            } else if (ErrorCode.ERROR_CODE_CERTIFICATION == code) {
//
//            } else if (ErrorCode.ERROR_CODE_NOID == code) {
//
//            }
////            else if (ErrorCode.ERROR_CODE_NOTDEFALUTADDRESS == code) {
////                IntentUtils.startActivity(mContext, AddressListActivity.class);
////            } else if (ErrorCode.ERROR_CODE_NOTREGISTER == code) {
////
////            } else if (ErrorCode.ERROR_CODE_NOTADDRESS == code) {
////                IntentUtils.startActivity(mContext, AddressNewActivity.class);
////            } else if (ErrorCode.ERROR_CODE_ONLYONEDEVICE == code
////                    || ErrorCode.ERROR_CODE_NEEDLOGIN == code) {
////                SPUtils.put(mContext, SPUtils.SP_BOOLEAN_LOGIN, false);
////                SPUtils.remove(mContext, SPUtils.SP_STRING_USER);
////                IntentUtils.startActivity(mContext,MainActivity.class);
////                MainActivity.setIndex(3);
////            } else if (ErrorCode.ERROR_CODE_SETPAYPASSWORD == code) {
////                Intent intent = new Intent(mContext,PasswordFristActivity.class);
////                intent.putExtra(PasswordFristActivity.INTENTNAME_LOSTTYPE, Constants.LOSTTYPE_PAY);
////                intent.setFlags(intent.FLAG_ACTIVITY_NO_HISTORY);
////                mContext.startActivity(intent);
////
////            } else if (ErrorCode.ERROR_CODE_PERFECTUSERRESOURCE == code) {
////                IntentUtils.startActivity(mContext, PersonalActivity.class);
////            } else if (ErrorCode.ERROR_CODE_CERTIFICATION == code) {
////
////            } else if (ErrorCode.ERROR_CODE_NOID == code) {
////
////            }
//
//            S.showShort(view, errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
