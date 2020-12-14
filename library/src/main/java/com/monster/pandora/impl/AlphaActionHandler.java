package com.monster.pandora.impl;

import android.support.annotation.NonNull;

import com.monster.pandora.define.AnimatorPath;
import com.monster.pandora.define.AnimatorType;
import com.monster.pandora.impl.action.AlphaAction;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public class AlphaActionHandler extends BaseActionHandler {

    public AlphaActionHandler() {
        super();
        setDuration(500);
        setValue(1f, 0.5f);
    }

    @NonNull
    @Override
    public AnimatorPath initAnimatorPath() {
        AnimatorPath animatorPathScale = new AnimatorPath();
        animatorPathScale.animatorType = AnimatorType.TYPE_ALPHA;
        animatorPathScale.animatorAction = new AlphaAction();
        return animatorPathScale;
    }

    public BaseActionHandler setValue(float originValue, float endValue) {
        animatorPath.animatorAction.value1 = originValue;
        animatorPath.animatorAction.value2 = endValue;
        return this;
    }
    @Override
    public BaseActionHandler setValue(float value) {
        throw new RuntimeException("please use setOriginValue & setEndValue");
    }
}
