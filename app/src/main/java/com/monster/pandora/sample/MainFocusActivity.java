package com.monster.pandora.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.monster.pandora.define.OnPandoraListener;
import com.monster.pandora.impl.ScaleActionHandler;
import com.monster.pandora.impl.action.ScaleAction;
import com.monster.pandora.sample.view.ShadowLayout;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public class MainFocusActivity extends Activity implements View.OnFocusChangeListener, OnPandoraListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_focus);
        initView();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return super.dispatchKeyEvent(event);
    }

    private void initView() {
        LinearLayout leftLL = (LinearLayout) findViewById(R.id.activity_main_to_basic_left_ll);

        for (int i = 0; i < 10; i++) {
            View textView = newLeftTextView(leftLL, i);
            leftLL.addView(textView);
            textView.setOnFocusChangeListener(this);
        }

        LinearLayout leftRL = (LinearLayout) findViewById(R.id.activity_main_to_basic_left_rl);

        for (int i = 0; i < 10; i++) {
            View textView = newLeftTextView(leftRL, i);
            leftRL.addView(textView);
            textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
//                    PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", hasFocus ? 1 : 2, hasFocus ? 2 : 1);
//                    PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", hasFocus ? 1 : 2, hasFocus ? 2 : 1);
//                    ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(v, pvhY, pvhZ);
//                    objectAnimator.setInterpolator(new AccelerateInterpolator());
//                    objectAnimator.setDuration(200).start();


                    ViewPropertyAnimator animator = v.animate().scaleX(hasFocus ? 2 : 1).scaleY(hasFocus ? 2 : 1).setDuration(200);
                    onStartBeforeConfig(animator, v);
                    animator.start();
                    sleepTime();
                }
            });
        }


    }

    private View newLeftTextView(LinearLayout rootView, int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_focused, rootView, false);
        TextView viewById = (TextView) view.findViewById(R.id.activity_main_to_basic_btn_2);
        String txt = "texfdsfgsdgfdsgsdfgsfdgdfhfghfghfgjfjdfhjhdgdsfsdagfsdafdgfdgsdfgsfdghsfdhsfhdhgght";
        viewById.setText(txt.substring(0, new Random().nextInt(txt.length())));
        try {
            ShadowLayout view1 = (ShadowLayout) view;
            view1.setRect(true);
        }catch (Exception e){

        }
        return view;

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new ScaleActionHandler()
                .setScaleType(ScaleAction.ScaleType.TYPE_CENTER_TO_CENTER)
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(200)
                .setValue(2)
                .setOnListener(this)
                .onViewActionOccur(v, hasFocus);

        sleepTime();

//        new AlphaActionHandler()
//                .setValue(1, 0.5f)
//                .setDuration(200)
//                .setDelay(1000)
//                .onViewActionOccur(v, hasFocus);


    }

    private void sleepTime() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onAnimationStart(View view) {
    }

    @Override
    public void onAnimationEnd(View view) {

    }

    private static void setViewPropertyAnimatorRT(ViewPropertyAnimator animator, Object rt) {
        try {
            Class<?> animClazz = Class.forName("android.view.ViewPropertyAnimator");
            Field animRtField = animClazz.getDeclaredField("mRTBackend");
            animRtField.setAccessible(true);
            animRtField.set(animator, rt);
        } catch (Exception e) {
            Log.d(TAG, "设置ViewPropertyAnimatorRT出错,错误信息:" + e.toString());
        }
    }

    /**
     * 创建对应的View的ViewPropertyAnimatorRT
     */
    private static Object createViewPropertyAnimatorRT(View view) {
        try {
            Class<?> animRtClazz = Class.forName("android.view.ViewPropertyAnimatorRT");
            Constructor<?> animRtConstructor = animRtClazz.getDeclaredConstructor(View.class);
            animRtConstructor.setAccessible(true);
            Object animRt = animRtConstructor.newInstance(view);
            return animRt;
        } catch (Exception e) {
            Log.d(TAG, "创建ViewPropertyAnimatorRT出错,错误信息:" + e.toString());
            return null;
        }
    }

    /**
     * 在执行动画开始前配置
     */
    public static void onStartBeforeConfig(ViewPropertyAnimator animator, View view) {
        Object rt = createViewPropertyAnimatorRT(view);
        setViewPropertyAnimatorRT(animator, rt);
    }
}
