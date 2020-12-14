package com.monster.pandora.executor;

import android.animation.TimeAnimator;
import android.support.annotation.NonNull;
import android.view.View;

import com.monster.pandora.control.ViewActionAnimator;
import com.monster.pandora.define.AnimatorPath;
import com.monster.pandora.define.OnPandoraUpdateListener;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public class ViewAnimatorExecutor extends TimeAnimator implements ViewActionAnimator,
        TimeAnimator.TimeListener {

    private final View view;
    private AnimatorPath animatorPath;
    private float currentLevel = -1;
    private float levelStart;
    private float levelDelta;
    private boolean singleTrack;

    public ViewAnimatorExecutor(View view) {
        setTimeListener(this);
        //自带监听回调不准确
//        addListener(this);
        this.view = view;
    }

    @Override
    public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
        float fraction;
        //动画执行结束
        if (totalTime >= animatorPath.duration) {
            fraction = 1;
        } else {
            fraction = (float) (totalTime / (double) animatorPath.duration);
        }
        //差值器处理后的值
        if (animatorPath.interpolator != null) {
            fraction = animatorPath.interpolator.getInterpolation(fraction);
        }
        float level = levelStart + fraction * levelDelta;
        updateValue(level);

        animateValue(currentLevel);
        //动画结束
        if (fraction == 1) {
            endAnimator();
            onExecutorAnimationEnd();
//            Log.d("ViewAnimatorExecutor", "endAnimator" + ":" + this);
        }

    }

    private void updateValue(float level) {
        animatorPath.animatorAction.setAnimatorValue(view, level, animatorPath.animatorAction, singleTrack);
        currentLevel = level;
    }

    private void animateValue(float currentLevel) {
        if (animatorPath.onPandoraUpdateListener != null) {
            animatorPath.onPandoraUpdateListener.onAnimationUpdate(currentLevel);
        }
    }


    @Override
    public void onActionOccur(boolean forward) {
        singleTrack = false;
        if (isRunning()) {
            endAnimator();
            onExecutorAnimationEnd();
        }
        float end;
        if (forward) {
            end = 1;
            if (currentLevel == -1) {
                currentLevel = 0;
            }
        } else {
            end = 0;
            if (currentLevel == -1) {
                currentLevel = 1;
            }
        }
        setStartDelay(animatorPath.delay);

        if (currentLevel != end) {
            levelStart = currentLevel;
            levelDelta = end - levelStart;
            onExecutorAnimationStart();
            startAnimator();
        }
    }

    @Override
    public void onActionOccur() {
        singleTrack = true;
        animatorPath.animatorAction.onActionStart(view, animatorPath.animatorAction);
        if (isRunning()) {
            endAnimator();
            onExecutorAnimationEnd();
        }
        setStartDelay(animatorPath.delay);
        currentLevel = 0;
        levelStart = currentLevel;
        levelDelta = 1 - levelStart;
//        Log.d("ViewAnimatorExecutor", "startAnimator" + ":" + this);
        onExecutorAnimationStart();
        startAnimator();
    }

    @Override
    public void startAnimator() {
        start();
    }

    @Override
    public void endAnimator() {
        if (isRunning()) {
            end();
        } else {
            cancel();
        }
    }

    @Override
    public void setAnimatorPath(@NonNull AnimatorPath animatorPath) {
        this.animatorPath = animatorPath;
    }

    public void onExecutorAnimationStart() {
//        Log.d("ViewAnimatorExecutor", "onAnimationStart" + ":" + this);
        if (animatorPath.onListener != null) {
            animatorPath.onListener.onAnimationStart(view);
        }
    }

    public void onExecutorAnimationEnd() {
//        Log.d("ViewAnimatorExecutor", "onAnimationEnd" + ":" + this);
        if (animatorPath.onListener != null) {
            animatorPath.onListener.onAnimationEnd(view);
        }
    }


}
