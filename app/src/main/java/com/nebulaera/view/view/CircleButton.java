package com.nebulaera.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;

/**
 * @author Barry 2017/10/25
 */

public class CircleButton extends AppCompatButton {

    private static final String LYJ_TAG = "LYJ_CircleButton";
    private float centerX;
    private float centerY;
    private float radius;

    public CircleButton(Context context) {
        this(context, null);
    }

    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(LYJ_TAG, "onMeasure");
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(LYJ_TAG, "onDraw");
        setBackground(null);
        centerX = getMeasuredWidth() / 2;
        centerY = getMeasuredHeight() / 2;
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        if (centerX > centerY) {
            radius = centerX;
        } else {
            radius = centerY;
        }
        Log.i(LYJ_TAG, "centerX=" + centerX + ",centerY=" + centerY + ",radius=" + radius);
        canvas.drawCircle(centerX, centerY, radius, paint);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i(LYJ_TAG, "onSizeChanged" + ",newW=" + w + ",newH=" + h);
    }
}
