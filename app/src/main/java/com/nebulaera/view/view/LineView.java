package com.nebulaera.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Barry 2017/11/4
 */

public class LineView extends View {
    private static final String LYJ_TAG = "LYJ_LineView";
    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private Paint paint;
    private Path path;

    public LineView(Context context) {
        this(context, null);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v(LYJ_TAG, "[draw]");
        canvas.drawPath(path, paint);
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        path = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v(LYJ_TAG, "[onTouchEvent]");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.v(LYJ_TAG, "[down]");
                startX = event.getX();
                startY = event.getY();
                path.moveTo(startX, startY);
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.v(LYJ_TAG, "[move]");
                endX = event.getX();
                endY = event.getY();
                path.lineTo(endX, endY);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                Log.v(LYJ_TAG, "[up]");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    public void reset(){
        path.reset();
        invalidate();
    }

}
