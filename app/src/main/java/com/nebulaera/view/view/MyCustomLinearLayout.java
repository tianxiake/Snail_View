package com.nebulaera.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Barry 2017/11/1
 */

public class MyCustomLinearLayout extends ViewGroup {
    private static final String LYJ_TAG = "LYJ_MyLinearLayout";

    public MyCustomLinearLayout(Context context) {
        this(context, null);
        Log.i(LYJ_TAG, "[MyCustomLinearLayout1]");
    }

    public MyCustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(LYJ_TAG, "[MyCustomLinearLayout2]");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.v(LYJ_TAG, "[onMeasure]");
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = getChildCount();
        int height = 0;
        int width = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            int childHeight = childAt.getMeasuredHeight();
            int childWidth = childAt.getMeasuredWidth();
            Log.i(LYJ_TAG, "[childHeight:{" + childHeight + "}] [childWidth:{" + childWidth + "}]");
            width += childWidth;
            height += childHeight;
        }
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int top = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int w = childAt.getMeasuredWidth();
            int h = childAt.getMeasuredHeight();
            Log.i(LYJ_TAG, "[index:{" + i + "}] [w:{" + w + "}] [h:{" + h + "}] [l:{" + 0 + "}] [t:{" + top + "}] [r:{" + w + "}] [b:{" + (top + h) + "}]");
            childAt.layout(0, top, w, top + h);
            top += h;
        }
    }
}
