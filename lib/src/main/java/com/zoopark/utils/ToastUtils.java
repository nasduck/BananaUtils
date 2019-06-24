package com.zoopark.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private static Toast sToast = null;

    public static void show(Context context, String content) {
        show(context, content, Toast.LENGTH_SHORT);
    }

    public static void show(Context context, String content, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(context, content, duration);
        } else {
            sToast.setText(content);
        }
        sToast.show();
    }
}
