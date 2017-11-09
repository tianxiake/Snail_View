package com.nebulaera.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author Barry 2017/11/8
 */

public class LayerView extends View {
    private static final String LYJ_TAG = "LYJ_LayerView";

    public LayerView(Context context) {
        super(context);
    }

    public LayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        int id1 = canvas.saveLayer(0, 0, 900, 900, null, Canvas.ALL_SAVE_FLAG);
        Log.v(LYJ_TAG, "[id:{" + id1 + "}] [count:{" + canvas.getSaveCount() + "}]");
        canvas.drawColor(Color.BLUE);

        int id2 = canvas.saveLayer(0, 0, 800, 800, null, Canvas.ALL_SAVE_FLAG);
        Log.v(LYJ_TAG, "[id:{" + id2 + "}] [count:{" + canvas.getSaveCount() + "}]");
        canvas.drawColor(Color.YELLOW);

        canvas.restoreToCount(id2);
        int saveCount = canvas.getSaveCount();
        Log.v(LYJ_TAG, "[count:{" + saveCount + "}]");
        canvas.drawColor(Color.GRAY);
    }
}
