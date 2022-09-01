# SetSignatureSchemeV1
## Xposed module to set the Signature Scheme for Android 30+ to 1. This allows system apps to be modified.



This module makes the method **_getMinimumSignatureSchemeVersionForTargetSdk_** in **_android.util.apk.ApkSignatureVerifier_** return 1 always, no matter the Android version.

```
public static int getMinimumSignatureSchemeVersionForTargetSdk(int targetSdk) {
        if (targetSdk >= 30) {
            return 2;
        }
        return 1;
    }
```

###### Only been tested with the zygisk version of LSPosed. Needs to be enabled for "System framework"
