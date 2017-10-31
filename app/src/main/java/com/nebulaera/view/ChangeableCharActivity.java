package com.nebulaera.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class ChangeableCharActivity extends AppCompatActivity {

    private TextView showCharTv;
    private Button startAnimBtn;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeable_char);
        showCharTv = (TextView) findViewById(R.id.tv_show_char);
        startAnimBtn = (Button) findViewById(R.id.btn_start_anim);
        startAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
        valueAnimator = ValueAnimator.ofObject(new MyCharacterEvaluator(), new Character('A'), new Character('Z'));
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char c = (char) animation.getAnimatedValue();
                showCharTv.setText(c + "");
            }
        });
    }

    private void startAnimation() {
        valueAnimator.start();
    }

    private class MyCharacterEvaluator implements TypeEvaluator<Character> {

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int start = (int) startValue;
            int end = (int) endValue;
            int current = (int) (start + (end - start) * fraction);
            char result = (char) current;
            return result;
        }
    }
}
