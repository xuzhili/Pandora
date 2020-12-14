package com.monster.pandora.impl;

import android.support.annotation.NonNull;

import com.monster.pandora.define.AnimatorPath;
import com.monster.pandora.define.AnimatorType;
import com.monster.pandora.impl.action.SizeAction;
import com.monster.pandora.impl.action.TranslationAction;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public class SizeActionHandler extends BaseActionHandler {

    public SizeActionHandler() {
        super();
        setDuration(180);
        setValue(50, 100);
    }

    @NonNull
    @Override
    public AnimatorPath initAnimatorPath() {
        AnimatorPath path = new AnimatorPath();
        path.animatorType = AnimatorType.TYPE_SIZE;
        path.animatorAction = new SizeAction();
        return path;
    }

    public BaseActionHandler setValue(float width, float height) {
        animatorPath.animatorAction.value1 = width;
        animatorPath.animatorAction.value2 = height;
        return this;
    }
    @Override
    public BaseActionHandler setValue(float value) {
        throw new RuntimeException("please use setTranslationX & setTranslationY");
    }
}
