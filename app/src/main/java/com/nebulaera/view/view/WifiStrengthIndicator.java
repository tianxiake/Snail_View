package com.nebulaera.view.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author Barry 2017/10/31
 */

public class WifiStrengthIndicator extends View {
    private static final String LYJ_TAG = "LYJ_WifiIndicator";
    private Paint indicatorPaint = new Paint();
    private Paint circlePaint = new Paint();
    private int baseRadius = 50;
    private int interval = 30;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        Log.v(LYJ_TAG, "[index:{" + index + "}]");
        this.index = index;
        invalidate();
    }

    private int index = 0;

    private ObjectAnimator objectAnimator;

    {
        setBackgroundColor(Color.GRAY);
        indicatorPaint.setColor(Color.BLUE);
        indicatorPaint.setStyle(Paint.Style.STROKE);
        indicatorPaint.setStrokeWidth(5);
        indicatorPaint.setStrokeCap(Paint.Cap.ROUND);
        indicatorPaint.setAntiAlias(true);

        circlePaint.setColor(Color.RED);
        circlePaint.setStrokeWidth(10);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);

        objectAnimator = ObjectAnimator.ofInt(this, "index", 0, 7);
        objectAnimator.setDuration(800);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
    }

    public WifiStrengthIndicator(Context context) {
        super(context);
    }

    public WifiStrengthIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        objectAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        objectAnimator.cancel();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        canvas.drawPoint(centerX, height - 10, circlePaint);
        for (int i = 0; i < index; i++) {
            int radius = baseRadius + interval * i;
            canvas.drawArc(centerX - radius, height - radius, centerX + radius, height + radius, -135, 90, false, indicatorPaint);
        }
    }
}
