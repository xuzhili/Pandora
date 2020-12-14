package com.monster.pandora.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.monster.pandora.define.OnPandoraListener;
import com.monster.pandora.impl.ScaleActionHandler;
import com.monster.pandora.impl.SizeActionHandler;
import com.monster.pandora.impl.TranslationActionHandler;

import java.util.Random;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public class MainSizeActivity extends Activity implements View.OnClickListener {

    private ScaleActionHandler scaleActionHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_size);
        initView();
    }

    private void initView() {
        View btn1 = findViewById(R.id.activity_main_to_basic_btn_1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int value = new Random().nextInt(300);
        new SizeActionHandler()
                .setValue(100, value)
                .setDuration(0)
                .setOnListener(new OnPandoraListener() {
                    @Override
                    public void onAnimationStart(View view) {
                        Log.d("MainActivity", "onAnimationStart:" + view);
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        Log.d("MainActivity", "onAnimationEnd:" + view);
                    }
                })
                .onViewActionOccur(v);
    }
}
