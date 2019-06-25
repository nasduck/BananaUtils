package com.zoopark.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/**
 * 状态栏工具类
 */
public class StatusBarUtils {

    /**
     * 获得 Status Bar 高度
     *
     * @param context 上下文
     * @return int Status Bar 高度
     */
    public static int getStatusBarHeight(Context context) {
        int height = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = context.getResources().getDimensionPixelSize(resourceId);
        }
        return height;
    }

    /**
     * Hide Status Bar
     *
     * @param activity
     * @param isVisible
     */
    public static void setStatusBarVisibility(Activity activity, boolean isVisible) {
        if (isVisible) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    /**
     * Return whether the status bar is visible.
     *
     * @param activity
     * @return
     */
    public static boolean isStatusBarVisible(Activity activity) {
        int flags = activity.getWindow().getAttributes().flags;
        return (flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) == 0;
    }


    /**
     * 设置状态栏透明
     *
     * @return ture 设置成功
     */
    public static boolean setTranslucent(Activity activity) {
        // 在4.4版本以上置StatusBar为透明
        if (Build.VERSION.SDK_INT > 18) {
            Window window = activity.getWindow();
            // 设置 StatusBar 为透明显示
            // 需要在 setContentView 之前完成操作
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 更改状态栏颜色
     *
     * @param color
     */
    public static void setStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(color));
        }
    }

}
