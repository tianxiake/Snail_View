package com.nebulaera.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Barry 2017/10/19
 */

public class CustomViewOne extends View {

    public CustomViewOne(Context context) {
        super(context);
    }

    public CustomViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        int measuredHeight = this.getMeasuredHeight();
        int measuredWidth = this.getMeasuredWidth();
//        canvas.drawRect(measuredWidth/2-100,measuredHeight/2-200,measuredWidth/2+100,measuredHeight/2+200,paint);
//        paint.setColor(Color.BLUE);
        canvas.drawArc();
//        canvas.drawCircle(measuredWidth / 2, measuredHeight / 2, 50, paint);
//        canvas.drawColor(Color.parseColor("#88880000"));
    }
}
