package com.nebulaera.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * @author Barry 2017/10/19
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LYJ_TAG = "LYJ_MainActivity";
    private Button changeableCharBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeableCharBtn = (Button) findViewById(R.id.btn_changeable_char);
        changeableCharBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_changeable_char:
                startInsideActivity(ChangeableCharActivity.class);
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
