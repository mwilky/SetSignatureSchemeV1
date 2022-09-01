package com.android.mwilky.sigscheme1;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main implements IXposedHookLoadPackage {

    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        //Framework hooks
        if (lpparam.packageName.equals("android")) {
            //Force signature scheme 1 so we can modify system apks
            _ApkSignatureVerifier.init(lpparam.classLoader);
        }
    }
}
