package com.nebulaera.view;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class RotateAndColorChangeActivity extends AppCompatActivity {
    private static final String LYJ_TAG = "LYJ_ChangeActivity";
    private Button startBtn;
    private TextView testTv;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_and_color_change);
        testTv = (TextView) findViewById(R.id.tv_test);
        testTv.setBackgroundColor(Color.parseColor("#66ccff"));
        startBtn = (Button) findViewById(R.id.btn_start_anim);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnim();
            }
        });
        animConfig();
    }

    private void animConfig() {
        PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat("Rotation", 0, 60f, -60f, 60f, -60f, 60f, -60f, 60f, -60f, 0);
        PropertyValuesHolder color = PropertyValuesHolder.ofInt("color", 0xffffffff, 0xffff0000, 0xff00ff00, 0xffff0000, 0xffffffff);
        color.setEvaluator(new ArgbEvaluator());
        valueAnimator = ValueAnimator.ofPropertyValuesHolder(rotation, color);
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float rotate = (float) animation.getAnimatedValue("Rotation");
                int color = (int) animation.getAnimatedValue("color");
                Log.v(LYJ_TAG, "[rotate:{" + rotate + "}] [color:{" + color + "}]");
                testTv.setTextColor(color);
                testTv.setRotation(rotate);
            }
        });
    }

    private void startAnim() {
        valueAnimator.start();
    }
}
