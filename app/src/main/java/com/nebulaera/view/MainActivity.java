package com.nebulaera.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Barry 2017/10/19
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LYJ_TAG = "LYJ_MainActivity";
    private Button changeableCharBtn;
    private Button bounceCircleBtn;
    private Button rotateAndColorChangeBtn;
    private Button keyFrameBtn;
    private Button menuBtn;
    private Button wifiStrengthIndicatorBtn;
    private ImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeableCharBtn = (Button) findViewById(R.id.btn_changeable_char);
        changeableCharBtn.setOnClickListener(this);

        bounceCircleBtn = (Button) findViewById(R.id.btn_bounce_circle);
        bounceCircleBtn.setOnClickListener(this);

        rotateAndColorChangeBtn = (Button) findViewById(R.id.btn_rotate_and_color_change);
        rotateAndColorChangeBtn.setOnClickListener(this);

        keyFrameBtn = (Button) findViewById(R.id.btn_key_frame);
        keyFrameBtn.setOnClickListener(this);

        menuBtn = (Button) findViewById(R.id.btn_menu);
        menuBtn.setOnClickListener(this);

        wifiStrengthIndicatorBtn = (Button) findViewById(R.id.btn_wifi_strength_indicator);
        wifiStrengthIndicatorBtn.setOnClickListener(this);

        circleImageView = (ImageView) findViewById(R.id.circleImageView);
        circleImageView.setOnClickListener(this);
        int a = 0x3;
        int b = a << 30;
        Log.v(LYJ_TAG, "[b:{" + b + "}]");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_changeable_char:
                startInsideActivity(ChangeableCharActivity.class);
                break;
            case R.id.btn_bounce_circle:
                startInsideActivity(BounceCircleActivity.class);
                break;
            case R.id.btn_rotate_and_color_change:
                startInsideActivity(RotateAndColorChangeActivity.class);
                break;
            case R.id.btn_key_frame:
                startInsideActivity(KeyFrameActivity.class);
                break;
            case R.id.btn_menu:
                startInsideActivity(MenuActivity.class);
                break;
            case R.id.btn_wifi_strength_indicator:
                startInsideActivity(WifiStrengthActivity.class);
                break;
            case R.id.circleImageView:
                Animatable drawable = (Animatable) circleImageView.getDrawable();
                drawable.start();
                break;
            default:
                break;
        }
    }

    private void startInsideActivity(Class<? extends Activity> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
