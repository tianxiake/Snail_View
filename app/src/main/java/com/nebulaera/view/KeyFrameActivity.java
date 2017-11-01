package com.nebulaera.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class KeyFrameActivity extends AppCompatActivity {

    private ImageView testIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_frame);
        testIv = (ImageView) findViewById(R.id.iv_test);
        configAnim();
    }

    private void configAnim() {
        Keyframe rotate1 = Keyframe.ofFloat(0, 0);
        Keyframe rotate2 = Keyframe.ofFloat(0.1f, -30);
        Keyframe rotate3 = Keyframe.ofFloat(0.2f, 30);
        Keyframe rotate4 = Keyframe.ofFloat(0.3f, -30);
        Keyframe rotate5 = Keyframe.ofFloat(0.4f, 30);
        Keyframe rotate6 = Keyframe.ofFloat(0.5f, -30);
        Keyframe rotate7 = Keyframe.ofFloat(0.6f, 30);
        Keyframe rotate8 = Keyframe.ofFloat(0.7f, -30);
        Keyframe rotate9 = Keyframe.ofFloat(0.8f, 30);
        Keyframe rotate10 = Keyframe.ofFloat(0.9f, -30);
        Keyframe rotate11 = Keyframe.ofFloat(1, 0);

        Keyframe scale0 = Keyframe.ofFloat(0f, 1f);
        Keyframe scale2 = Keyframe.ofFloat(0.4f, 1f);
        Keyframe scale3 = Keyframe.ofFloat(0.6f, 2f);
        Keyframe scale4 = Keyframe.ofFloat(0.8f, 1f);
        Keyframe scale5 = Keyframe.ofFloat(1f, 1f);

        PropertyValuesHolder rotation = PropertyValuesHolder.ofKeyframe("Rotation", rotate1, rotate2, rotate3,
                rotate4, rotate5, rotate6, rotate7, rotate8, rotate9, rotate10, rotate11);

        PropertyValuesHolder scale = PropertyValuesHolder.ofKeyframe("ScaleX", scale0, scale2, scale3, scale4, scale5);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(testIv, rotation, scale);
        objectAnimator.setDuration(5000);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.start();

    }
}
