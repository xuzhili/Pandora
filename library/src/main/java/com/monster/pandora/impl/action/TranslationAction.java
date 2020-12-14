package com.monster.pandora.impl.action;

import android.view.View;

import com.monster.pandora.define.AnimatorAction;

/**
 * Created by $xuzhili on 2019/1/8.
 */

public class TranslationAction extends AnimatorAction {

    private float value1Start;
    private float value2Start;

    @Override
    public void setAnimatorValue(View view, float valueLevel, AnimatorAction animatorAction, boolean singleTrack) {
//        Log.d("TranslationAction", "animatorAction.value1:"
//                + animatorAction.value1 + ":" + value1 + ":"
//                + this.value1 + ":" + (animatorAction.value1 == value1));
        if (!singleTrack) {
            view.setTranslationX(animatorAction.value1 * valueLevel);
            view.setTranslationY(animatorAction.value2 * valueLevel);
        } else {
            view.setTranslationX(value1Start + (animatorAction.value1 - value1Start) * valueLevel);
            view.setTranslationY(value2Start + (animatorAction.value2 - value2Start) * valueLevel);
        }
    }

    @Override
    public void onActionStart(View view, AnimatorAction animatorAction) {
        value1Start = view.getTranslationX();
        value2Start = view.getTranslationY();
    }
}
