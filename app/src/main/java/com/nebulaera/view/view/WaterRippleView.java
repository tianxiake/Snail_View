package com.nebulaera.view.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * @author Barry 2017/11/7
 */

public class WaterRippleView extends View {
    private static final String LYJ_TAG = "LYJ_WaterRippleView";
    private Paint paint;
    private Path path;
    /**
     * 定义一个波长的长度
     */
    private int waterRipperLength = 600;
    private int originY = 300;
    /**
     * 偏移量
     */
    private int dx;
    private int dy;
    private ValueAnimator valueAnimator;

    public WaterRippleView(Context context) {
        this(context, null);
    }

    public WaterRippleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        path = new Path();

        PropertyValuesHolder offsetX = PropertyValuesHolder.ofInt("dx", 0, waterRipperLength);
        PropertyValuesHolder offsetY = PropertyValuesHolder.ofInt("dy", 0, 1000);
        valueAnimator = ValueAnimator.ofPropertyValuesHolder(offsetX, offsetY);
//        valueAnimator = ValueAnimator.ofInt(0, waterRipperLength);
        valueAnimator.setDuration(1500);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValueX = (int) animation.getAnimatedValue("dx");
                dx = currentValueX;
                int currentValueY = (int) animation.getAnimatedValue("dy");
                dy = currentValueY;
                Log.v(LYJ_TAG, "[currentValueX:{" + currentValueX + "}]");
                invalidate();
            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        valueAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        valueAnimator.cancel();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        path.moveTo(-waterRipperLength + dx, originY + dy);
        int halfWaterRipperLength = waterRipperLength / 2;
        for (int i = -waterRipperLength; i < getWidth() + waterRipperLength; i += waterRipperLength) {
            path.rQuadTo(halfWaterRipperLength / 2, -50, halfWaterRipperLength, 0);
            path.rQuadTo(halfWaterRipperLength / 2, 50, halfWaterRipperLength, 0);
        }
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        canvas.drawPath(path, paint);
    }


}
