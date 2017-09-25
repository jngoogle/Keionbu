package com.example.jngoogle.keionbu.widgetController;

/**
 * Created by jngoogle on 2017/3/23.
 * Email: jammicnicoole@gmail.com
 */

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * 控制热词控件（TextView）的位置
 */
public class WidgetController {

    /**
     * 获取控件的宽
     * 一般自定义控件的时候会使用 MeasureSpec.UNSPECIFIED 这个属性
     * @return
     */
    public static int getWidth(View view) {
        // the return of makeMeasureSpec is size + mode
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        return view.getMeasuredWidth();
    }

    /**
     * 获取控件的高
     *
     * @return
     */
    public static int getHeight(View view) {
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        return view.getMeasuredHeight();
    }

    /**
     * 确定 View 在父布局中的位置
     */
    public static void setViewLocation(View view, int x, int y) {
        ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(view.getLayoutParams());
        marginParams.setMargins(x, y, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginParams);
        view.setLayoutParams(layoutParams);
    }
}
