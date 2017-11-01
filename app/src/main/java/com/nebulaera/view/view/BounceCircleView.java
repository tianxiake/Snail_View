package com.nebulaera.view.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * @author Barry 2017/10/31
 */

public class BounceCircleView extends View {
    private Paint fillPaint = new Paint();
    private ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyRadiusEvaluator(), new Radius(0), new Radius(300));
    private float radius;

    public BounceCircleView(Context context) {
        this(context, null);
    }

    public BounceCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        valueAnimator.setDuration(3000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Radius animatedValue = (Radius) animation.getAnimatedValue();
                radius = animatedValue.getRadius();
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        fillPaint.setColor(Color.RED);
        canvas.drawCircle(this.getWidth() / 2, this.getHeight() / 2, radius, fillPaint);
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

    private class Radius {
        private float radius;

        public Radius(float radius) {
            this.radius = radius;
        }

        public float getRadius() {
            return radius;
        }

        public void setRadius(float radius) {
            this.radius = radius;
        }
    }

    private class MyRadiusEvaluator implements TypeEvaluator<Radius> {

        @Override
        public Radius evaluate(float fraction, Radius startValue, Radius endValue) {
            float result = startValue.getRadius() + (endValue.getRadius() - startValue.getRadius()) * fraction;
            Radius radius = new Radius(result);
            return radius;
        }
    }
}
