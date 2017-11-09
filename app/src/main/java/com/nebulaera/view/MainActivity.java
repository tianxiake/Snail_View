package com.nebulaera.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nebulaera.view.activity.BounceCircleActivity;
import com.nebulaera.view.activity.ChangeableCharActivity;
import com.nebulaera.view.activity.FingerTrackActivity;
import com.nebulaera.view.activity.KeyFrameActivity;
import com.nebulaera.view.activity.LayerActivity;
import com.nebulaera.view.activity.MenuActivity;
import com.nebulaera.view.activity.RandomDrawActivity;
import com.nebulaera.view.activity.RotateAndColorChangeActivity;
import com.nebulaera.view.activity.WaterRippleActivity;
import com.nebulaera.view.activity.WifiStrengthActivity;
import com.nebulaera.view.activity.XfermodeScratchCardActivity;
import com.nebulaera.view.activity.ZoneWaveActivity;

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
    private Button fingerTrackBtn;
    private Button waterRippleBtn;
    private Button randomDrawBtn;
    private Button scratchCardBtn;
    private Button zoneWaveBtn;
    private Button layerBtn;

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

        fingerTrackBtn = (Button) findViewById(R.id.btn_finger_track);
        fingerTrackBtn.setOnClickListener(this);

        waterRippleBtn = (Button) findViewById(R.id.btn_water_ripple);
        waterRippleBtn.setOnClickListener(this);

        randomDrawBtn = (Button) findViewById(R.id.btn_random_draw);
        randomDrawBtn.setOnClickListener(this);

        scratchCardBtn = (Button) findViewById(R.id.btn_xfermode_scratch_card);
        scratchCardBtn.setOnClickListener(this);

        zoneWaveBtn = (Button) findViewById(R.id.btn_zone_wave);
        zoneWaveBtn.setOnClickListener(this);

        layerBtn = (Button) findViewById(R.id.btn_layer);
        layerBtn.setOnClickListener(this);
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
            case R.id.btn_finger_track:
                startInsideActivity(FingerTrackActivity.class);
                break;
            case R.id.btn_water_ripple:
                startInsideActivity(WaterRippleActivity.class);
                break;
            case R.id.btn_random_draw:
                startInsideActivity(RandomDrawActivity.class);
                break;
            case R.id.btn_xfermode_scratch_card:
                startInsideActivity(XfermodeScratchCardActivity.class);
                break;
            case R.id.btn_zone_wave:
                startInsideActivity(ZoneWaveActivity.class);
                break;
            case R.id.btn_layer:
                startInsideActivity(LayerActivity.class);
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
