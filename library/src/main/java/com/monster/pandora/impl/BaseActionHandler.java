package com.monster.pandora.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.Interpolator;

import com.monster.pandora.define.OnPandoraUpdateListener;
import com.monster.pandora.control.ViewActionAnimator;
import com.monster.pandora.control.ViewActionHandler;
import com.monster.pandora.define.AnimatorPath;
import com.monster.pandora.define.OnPandoraListener;
import com.monster.pandora.executor.ViewAnimatorExecutor;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public abstract class BaseActionHandler implements ViewActionHandler {
    protected AnimatorPath animatorPath;


    public BaseActionHandler() {
        animatorPath = initAnimatorPath();
    }

    @NonNull
    public abstract AnimatorPath initAnimatorPath();

    protected void onActionStartOccur(View view) {

    }

    @Override
    public void onViewActionOccur(View view, boolean forward) {
        if (view == null) {
            return;
        }
        ViewActionAnimator actionAnimator = getActionAnimator(view);
        actionAnimator.onActionOccur(forward);
    }

    @Override
    public void onViewActionOccur(View view) {
        if (view == null) {
            return;
        }
        getNewPathActionAnimator(view).onActionOccur();
    }

    @NonNull
    private ViewActionAnimator getActionAnimator(View view) {
        ViewActionAnimator actionAnimator = (ViewActionAnimator) view.getTag(animatorPath.animatorType);
        if (actionAnimator == null) {
            actionAnimator = new ViewAnimatorExecutor(view);
            view.setTag(animatorPath.animatorType, actionAnimator);

        }
        AnimatorPath animatorPath = AnimatorPath.buildNewAnimationPath(this.animatorPath);
        actionAnimator.setAnimatorPath(animatorPath);
        onActionStartOccur(view);
        return actionAnimator;
    }

    @NonNull
    private ViewActionAnimator getNewPathActionAnimator(View view) {
        ViewActionAnimator actionAnimator = (ViewActionAnimator) view.getTag(animatorPath.animatorType);
        if (actionAnimator == null) {
            actionAnimator = new ViewAnimatorExecutor(view);
            view.setTag(animatorPath.animatorType, actionAnimator);
        }
        //未指定forward的时，重新构建AnimatorPath，因为value很可能不一样
        AnimatorPath animatorPath = AnimatorPath.buildNewAnimationPath(this.animatorPath);
        actionAnimator.setAnimatorPath(animatorPath);
        onActionStartOccur(view);
        return actionAnimator;
    }

//    @Override
//    public void setAnimatorPath(@NonNull AnimatorPath animatorPath) {
//        this.animatorPath = animatorPath;
//    }

    public BaseActionHandler setDuration(int duration) {
        animatorPath.duration = duration;
        return this;
    }

    public BaseActionHandler setInterpolator(Interpolator interpolator) {
        animatorPath.interpolator = interpolator;
        return this;
    }

    public BaseActionHandler setOnListener(OnPandoraListener listener) {
        animatorPath.onListener = listener;
        return this;
    }

    public BaseActionHandler setDelay(int delay) {
        animatorPath.delay = delay;
        return this;
    }

    public BaseActionHandler setValue(float value) {
        animatorPath.animatorAction.value1 = value;
        animatorPath.animatorAction.value2 = value;
        return this;
    }

    public BaseActionHandler setUpdateListener(OnPandoraUpdateListener listener) {
        animatorPath.onPandoraUpdateListener = listener;
        return this;
    }

    protected AnimatorPath getAnimatorPath() {
        return animatorPath;
    }
}
