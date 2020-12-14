package com.monster.pandora.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.monster.pandora.define.OnPandoraUpdateListener;
import com.monster.pandora.impl.AlphaActionHandler;
import com.monster.pandora.impl.ScaleActionHandler;
import com.monster.pandora.impl.TranslationActionHandler;
import com.monster.pandora.impl.action.ScaleAction;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public class MainActivity extends Activity implements View.OnFocusChangeListener {

    private ScaleActionHandler scaleActionHandler;

    private boolean hasCome;
    private View view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "MainActivity:onCreate:" + hasCome);
        hasCome = true;
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        View btn1 = findViewById(R.id.activity_main_to_basic_btn_1);
        btn1.setOnFocusChangeListener(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(MainActivity.this, MainFocusActivity.class));
            }
        });

        btn1 = findViewById(R.id.activity_main_to_basic_btn_2);
        btn1.setOnFocusChangeListener(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(MainActivity.this, MainTraslationActivity.class));
            }
        });

        btn1 = findViewById(R.id.activity_main_to_basic_btn_3);
        btn1.setOnFocusChangeListener(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(MainActivity.this, MainSizeActivity.class));
            }
        });
        view = findViewById(R.id.activity_main_to_basic_btn_4);

    }

    @Override
    public void onFocusChange(final View v, final boolean hasFocus) {
        new ScaleActionHandler()
                .setScaleType(ScaleAction.ScaleType.TYPE_LEFT_TO_RIGHT)
                .setDuration(200)
                .setValue(2)
                .setUpdateListener(new OnPandoraUpdateListener() {
                    @Override
                    public void onAnimationUpdate(float animatedValue) {

//                        if (R.id.activity_main_to_basic_btn_2==v.getId()) {
//                            Log.i("xqy", "------>" + animatedValue);
//
//
//                            float mTempWidth;
//                            float mTempHeight;
//
//                            mTempWidth = animatedValue * 100;
//                            mTempHeight = animatedValue * 100;
//                            view.setTranslationX(mTempWidth);
//                            view.setTranslationY(mTempHeight);
//                        }
                    }
                })
                .onViewActionOccur(v, hasFocus);

        new AlphaActionHandler()
                .setValue(1, 0.5f)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setDuration(200)
                .setDelay(1000)
                .onViewActionOccur(view, hasFocus);

        new ScaleActionHandler()
                .setScaleType(ScaleAction.ScaleType.TYPE_CENTER_TO_CENTER)
                .setValue(1.5f)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setDuration(200)
                .setDelay(1000)
                .onViewActionOccur(view, hasFocus);

        new TranslationActionHandler()
                .setValue(200, 0)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setDuration(200)
                .setDelay(1000)
                .onViewActionOccur(view, hasFocus);
    }
}
