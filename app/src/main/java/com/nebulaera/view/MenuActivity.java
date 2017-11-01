package com.nebulaera.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LYJ_TAG = "LYJ_MenuActivity";
    private Button shareBtn;
    private Button copyBtn;
    private Button cutBtn;
    private Button menuBtn;
    private boolean openState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        shareBtn = (Button) findViewById(R.id.btn_share);
        copyBtn = (Button) findViewById(R.id.btn_copy);
        cutBtn = (Button) findViewById(R.id.btn_cut);
        menuBtn = (Button) findViewById(R.id.btn_menu);

        shareBtn.setOnClickListener(this);
        copyBtn.setOnClickListener(this);
        cutBtn.setOnClickListener(this);
        menuBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_share:
                Toast.makeText(this, shareBtn.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_copy:
                Toast.makeText(this, copyBtn.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cut:
                Toast.makeText(this, cutBtn.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_menu:
                Log.v(LYJ_TAG, "[btn_menu]");
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(menuBtn, "scaleX", 1, 1.2f, 1);
                objectAnimator1.setDuration(200);
                objectAnimator1.setInterpolator(new BounceInterpolator());
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(menuBtn, "scaleY", 1, 1.2f, 1);
                objectAnimator2.setDuration(200);
                objectAnimator2.setInterpolator(new BounceInterpolator());
                set.playTogether(objectAnimator1, objectAnimator2);
                set.start();
                openOrCloseMenu();
                break;
            default:
                break;
        }
    }

    private void openOrCloseMenu() {
        if (!openState) {
            //展开
            openState = true;
            doAnimationOpen(shareBtn, 0, 3, 300);
            doAnimationOpen(cutBtn, 1, 3, 300);
            doAnimationOpen(copyBtn, 2, 3, 300);
        } else {
            //关闭
            openState = false;
            doAnimationClose(shareBtn, 0, 3, 300);
            doAnimationClose(cutBtn, 1, 3, 300);
            doAnimationClose(copyBtn, 2, 3, 300);
        }
    }

    private void doAnimationOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / (total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));

        Log.v(LYJ_TAG, "[index:{" + index + "}] [x:{" + translationX + "}] [y:{" + translationY + "}]");
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(view, "alpha", 0, 1),
                ObjectAnimator.ofFloat(view, "scaleX", 0, 1),
                ObjectAnimator.ofFloat(view, "scaleY", 0, 1),
                ObjectAnimator.ofFloat(view, "TranslationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "TranslationY", 0, translationY)
        );
        set.setInterpolator(new BounceInterpolator());
        set.setDuration(500).start();
    }

    private void doAnimationClose(View view, int index, int total, int radius) {
        double degree = Math.toRadians(90) / (total - 1) * index;
        int translationX = (int) (radius * Math.sin(degree));
        int translationY = (int) (radius * Math.cos(degree));

        Log.v(LYJ_TAG, "[index:{" + index + "}] [x:{" + translationX + "}] [y:{" + translationY + "}]");
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(view, "alpha", 1, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1, 0),
                ObjectAnimator.ofFloat(view, "scaleY", 1, 0),
                ObjectAnimator.ofFloat(view, "TranslationX", -translationX, 0),
                ObjectAnimator.ofFloat(view, "TranslationY", -translationY, 0)
        );
        set.setDuration(500).start();
    }
}
