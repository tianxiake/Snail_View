package com.nebulaera.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.nebulaera.view.R;

/**
 * @author Barry 2017/10/19
 */

public class CustomViewOne extends View {
    private static final String LYJ_TAG = "LYJ_CustomViewOne";
    private int height;
    private int width;

    public CustomViewOne(Context context) {
        this(context, null);
    }

    public CustomViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        height = getMeasuredHeight();
        width = getMeasuredWidth();
        Log.v(LYJ_TAG, "[height:" + height + ",width" + width + "]");
//        draw7(canvas);
        canvas.drawColor(Color.RED);
        canvas.rotate(90);
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);
        canvas.drawLine(500, 500, 2000, 500, paint);
        canvas.rotate(-90);
        canvas.drawLine(500, 500, 2000, 500, paint);
    }

    private void draw7(Canvas canvas) {
        Path path = new Path();
        path.moveTo(300, 300);
        path.rLineTo(300, 0);
        path.lineTo(360, 560);
        Paint paint = new Paint();
        paint.setStrokeWidth(50);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.save();
        canvas.rotate(180, 450, 430);
//        canvas.scale(2,3,450,430);
        canvas.skew(0, 0.7f);
//        canvas.rotate(30);
//        canvas.translate(500, 0);
        canvas.drawPath(path, paint);
        canvas.restore();

//        canvas.save();
//        canvas.rotate(30);
////        canvas.rotate(30);
//        canvas.translate(500, 0);
//        canvas.drawPath(path, paint);
//        canvas.restore();

    }

    private void drawCircleWithBitmapShader(Canvas canvas) {
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(500, 500, 300, paint);
    }

    private void drawText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(200);
        canvas.drawText("Hello World!", 200, 100, paint);
    }


    /**
     * 绘制有交叉的两个圆
     */
    private void drawIntersectCircle(Canvas canvas) {
        Path path = new Path();
        path.addCircle(500, 500, 100, Path.Direction.CW);
        path.addCircle(650, 500, 100, Path.Direction.CW);
        path.setFillType(Path.FillType.EVEN_ODD);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
    }

    private void usePathDrawArc(Canvas canvas) {
        Path path = new Path();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        path.lineTo(100, 100);
        path.arcTo(100, 100, 300, 300, -90, 90, false); // 直接连线连到弧形起点（有痕迹）
        canvas.drawPath(path, paint);
    }

    /**
     * 使用 drawPath来画圆
     */
    private void usePathDrawCircle(Canvas canvas) {
        Path path = new Path();
        path.addCircle(300, 300, 200, Path.Direction.CW);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawPath(path, paint);
    }

    /**
     * 使用 drawPath来画圆和矩形的组合图形
     */
    private void usePathDrawCircleAndRect(Canvas canvas) {
        Path path = new Path();
        path.addCircle(300, 300, 200, Path.Direction.CW);
        path.addRect(300, 100, 700, 500, Path.Direction.CW);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawPath(path, paint);
    }

    /**
     * 使用 drawPath来画线
     */
    private void usePathDrawLine(Canvas canvas) {
        Path path = new Path();
        path.lineTo(300, 300);
        path.lineTo(getMeasuredWidth(), 0);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path, paint);
    }

    /**
     * 使用 drawPath来画线.同时移动当前位置
     */
    private void usePathMoveCurrentPointDrawLine(Canvas canvas) {
        Path path = new Path();
        int halfHeight = height / 2;
        path.moveTo(0, halfHeight);
        path.lineTo(300, halfHeight + 500);
        Paint paint = new Paint();
        path.moveTo(800, halfHeight + 500);
        path.lineTo(800, halfHeight);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path, paint);
    }

}
