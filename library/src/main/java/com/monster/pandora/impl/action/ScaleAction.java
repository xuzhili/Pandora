package com.monster.pandora.impl.action;

import android.support.annotation.IntDef;
import android.util.Log;
import android.view.View;

import com.monster.pandora.define.AnimatorAction;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by $xuzhili on 2019/1/8.
 */

public class ScaleAction extends AnimatorAction {

    @IntDef({ScaleType.TYPE_NORMAL
            , ScaleType.TYPE_CENTER_TO_CENTER
            , ScaleType.TYPE_LEFT_TO_RIGHT
            , ScaleType.TYPE_UNKNOW})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScaleType {
        int TYPE_NORMAL = 0;
        int TYPE_CENTER_TO_CENTER = 1;
        int TYPE_LEFT_TO_RIGHT = 2;
        int TYPE_UNKNOW = 3;
    }

    @Override
    public void setAnimatorValue(View view, float valueLevel, AnimatorAction animatorAction, boolean singleTrack) {
        //必须指定类的value，不能使用父类的value，父类的value会被其他对象更改
        float scaleX = 1 + (animatorAction.value1 - 1) * valueLevel;
        float scaleY = 1 + (animatorAction.value2 - 1) * valueLevel;
        view.setScaleX(scaleX);
        view.setScaleY(scaleY);
//        Log.d("ScaleAction",
//                "animatorAction.value1:" + animatorAction.value1 + ":" + value1 + ":"
//                        + "animatorAction.value2:" + animatorAction.value2 + ":" + value2 + ":"
//                        + "animatorAction.valueLevel:" + valueLevel + ":"
//                        + "animatorAction.scaleX:" + scaleX + ":"
//                        + "animatorAction.scaleY:" + scaleY + ":"
//        );
    }

    @Override
    public void onActionStart(View view, AnimatorAction animatorAction) {

    }
}
