package com.monster.pandora.impl;

import android.support.annotation.NonNull;

import com.monster.pandora.define.AnimatorPath;
import com.monster.pandora.define.AnimatorType;
import com.monster.pandora.impl.action.TranslationAction;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public class TranslationActionHandler extends BaseActionHandler {

    public TranslationActionHandler() {
        super();
        setDuration(180);
        setValue(50, 100);
    }

    @NonNull
    @Override
    public AnimatorPath initAnimatorPath() {
        AnimatorPath animatorPathScale = new AnimatorPath();
        animatorPathScale.animatorType = AnimatorType.TYPE_TRANSLATION;
        animatorPathScale.animatorAction = new TranslationAction();
        return animatorPathScale;
    }

    public BaseActionHandler setValue(float translationX, float translationY) {
        animatorPath.animatorAction.value1 = translationX;
        animatorPath.animatorAction.value2 = translationY;
        return this;
    }
    @Override
    public BaseActionHandler setValue(float value) {
        throw new RuntimeException("please use setValue(float translationX, float translationY)");
    }
}
