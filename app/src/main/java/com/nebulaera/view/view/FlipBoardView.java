package com.nebulaera.view.view;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.nebulaera.view.R;

/**
 * @author Barry 2017/10/29
 */

public class FlipBoardView extends View {

    private final Bitmap bitmap;

    public FlipBoardView(Context context) {
        super(context);
    }

    public FlipBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.flipboard);
        AnimatorSet animatorSet = new AnimatorSet();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, centerX - bitmapWidth / 2, centerY - bitmapHeight / 2, paint);


    }
}
