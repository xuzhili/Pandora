package com.monster.pandora.impl.action;

import android.view.View;
import android.view.ViewGroup;

import com.monster.pandora.define.AnimatorAction;

/**
 * Created by $xuzhili on 2019/1/8.
 */

public class SizeAction extends AnimatorAction {

    private float value1Start;
    private float value2Start;

    @Override
    public void setAnimatorValue(View view, float valueLevel, AnimatorAction animatorAction, boolean singleTrack) {
//        Log.d("TranslationAction", "animatorAction.value1:"
//                + animatorAction.value1 + ":" + value1 + ":"
//                + this.value1 + ":" + (animatorAction.value1 == value1));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (!singleTrack) {
            layoutParams.width = (int) (animatorAction.value1 * valueLevel);
            layoutParams.height = (int) (animatorAction.value2 * valueLevel);
        } else {
            layoutParams.width = (int) (value1Start + (animatorAction.value1 - value1Start) * valueLevel);
            layoutParams.height = (int) (value2Start + (animatorAction.value2 - value2Start) * valueLevel);
        }
        view.setLayoutParams(layoutParams);
    }

    @Override
    public void onActionStart(View view, AnimatorAction animatorAction) {
        value1Start = view.getWidth();
        value2Start = view.getHeight();
    }
}
