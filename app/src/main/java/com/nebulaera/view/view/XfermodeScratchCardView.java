package com.nebulaera.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.nebulaera.view.R;

/**
 * @author Barry 2017/11/8
 */

public class XfermodeScratchCardView extends View {
    private Paint paint;
    private Path path;
    private Bitmap src;
    private Bitmap dst;
    private float preX;
    private float preY;
    private Bitmap BmpText;

    public XfermodeScratchCardView(Context context) {
        this(context, null);
    }

    public XfermodeScratchCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //关闭硬件加速
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        paint = new Paint();
        paint.setStrokeWidth(40);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

        BmpText = BitmapFactory.decodeResource(getResources(), R.drawable.one,null);
        //src图像
        src = BitmapFactory.decodeResource(getResources(), R.drawable.two);
        //
        dst = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
        path = new Path();
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
        canvas.drawBitmap(BmpText, 0, 0, paint);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //将手指轨迹画到bitmap上
        Canvas fingerCanvas = new Canvas(dst);
        fingerCanvas.drawPath(path, paint);

        canvas.drawBitmap(dst, 0, 0, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(src, 0, 0, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                preX = event.getX();
                preY = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float currentX = event.getX();
                float currentY = event.getY();
                float controlX = (preX + currentX) / 2;
                float controlY = (preY + currentY) / 2;
                path.quadTo(controlX, controlY, currentX, currentY);
                preX = currentX;
                preY = currentY;
                break;
            default:
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }
}
