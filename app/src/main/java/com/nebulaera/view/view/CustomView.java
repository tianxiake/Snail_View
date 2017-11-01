package com.nebulaera.view.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.nebulaera.view.R;

/**
 * @author Barry 2017/11/1
 */

public class CustomView extends View {
    private static final String LYJ_TAG = "LYJ_CustomView";
    private String content;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        int index = typedArray.getIndex(R.styleable.MyCustomView_text_name);
        content = typedArray.getString(index);
        typedArray.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        Log.v(LYJ_TAG, "[widthSize:{" + widthSize + "}] [measuredWidth:{" + measuredWidth + "}]");
        int measuredHeight = getMeasuredHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
