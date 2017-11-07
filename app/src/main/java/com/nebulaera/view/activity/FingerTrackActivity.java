package com.nebulaera.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nebulaera.view.R;
import com.nebulaera.view.view.LineView;

public class FingerTrackActivity extends AppCompatActivity {

    private Button clearBtn;
    private LineView fingerTrackLv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_track);
        fingerTrackLv = (LineView) findViewById(R.id.lineView);
        clearBtn = (Button) findViewById(R.id.btn_clear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fingerTrackLv.reset();
            }
        });
    }
}
