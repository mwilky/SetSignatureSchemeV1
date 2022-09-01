package com.android.mwilky.sigscheme1;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class _ApkSignatureVerifier {

    private static final String HOOK_CLASS= "android.util.apk.ApkSignatureVerifier";

    private static int count = 0;

    static void init(final ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod(HOOK_CLASS, classLoader, "getMinimumSignatureSchemeVersionForTargetSdk",
                int.class,
                handlegetMinimumSignatureSchemeVersionForTargetSdk);
    }

    //Android 13 Forces Schema 2 signatures for System apps which stops us modifying them, force the method to return 1 (old jar signatures)
    private static XC_MethodHook handlegetMinimumSignatureSchemeVersionForTargetSdk = new XC_MethodHook() {
        @Override
        protected void afterHookedMethod(final XC_MethodHook.MethodHookParam param) {
            //force return as 1 so we use jar signatures
            param.setResult(1);
            //Only log once
            if (count == 0) {
                XposedBridge.log("mwilky: getMinimumSignatureSchemeVersionForTargetSdk spoofed to return " + (int) param.getResult());
                count++;
            }
        }
    };
}
