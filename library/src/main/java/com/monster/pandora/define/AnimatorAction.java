package com.monster.pandora.define;

import android.view.View;

/**
 * Created by $xuzhili on 2019/1/8.
 */

public abstract class AnimatorAction {

    public float value1;

    public float value2;

    /**
     *
     * @param view
     * @param valueLevel 走过的值，累加为1
     * @param animatorAction
     * @param singleTrack 是否有返回的轨迹，是的话在某个范围内徘徊。否则只有一个终点方向
     */
    public abstract void setAnimatorValue(View view, float valueLevel, AnimatorAction animatorAction, boolean singleTrack);

    public abstract void onActionStart(View view, AnimatorAction animatorAction);

    @Override
    public String toString() {
        return "AnimatorAction{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
