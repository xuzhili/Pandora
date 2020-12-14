package com.monster.pandora.impl.action;

import android.view.View;

import com.monster.pandora.define.AnimatorAction;

/**
 * Created by $xuzhili on 2019/1/8.
 */

public class AlphaAction extends AnimatorAction {

    @Override
    public void setAnimatorValue(View view, float valueLevel, AnimatorAction animatorAction, boolean singleTrack) {
        view.setAlpha(value1 + (animatorAction.value2 - animatorAction.value1) * valueLevel);
    }

    @Override
    public void onActionStart(View view, AnimatorAction animatorAction) {

    }
}
