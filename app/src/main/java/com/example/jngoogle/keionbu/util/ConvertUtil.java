package com.example.jngoogle.keionbu.util;

import android.content.Context;

/**
 * Created by jngoogle on 2017/3/23.
 * Email: jammicnicoole@gmail.com
 */

public class ConvertUtil {

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
