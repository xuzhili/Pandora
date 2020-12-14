package com.monster.pandora.impl;

import android.support.annotation.NonNull;
import android.view.View;

import com.monster.pandora.define.AnimatorPath;
import com.monster.pandora.define.AnimatorType;
import com.monster.pandora.impl.action.ScaleAction;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public class ScaleActionHandler extends BaseActionHandler {

    private int scaleType;
    private Integer pivotX;
    private Integer pivotY;

    public ScaleActionHandler() {
        super();
        setDuration(180);
        setValue(1.2f);
    }

    @NonNull
    @Override
    public AnimatorPath initAnimatorPath() {
        AnimatorPath animatorPathScale = new AnimatorPath();
        animatorPathScale.animatorType = AnimatorType.TYPE_SCALE;
        animatorPathScale.animatorAction = new ScaleAction();
        return animatorPathScale;
    }

    @Override
    protected void onActionStartOccur(View view) {
        super.onActionStartOccur(view);
        switch (scaleType) {
            case ScaleAction.ScaleType.TYPE_NORMAL:
                view.setPivotX(0);
                view.setPivotY(0);
                break;
            case ScaleAction.ScaleType.TYPE_CENTER_TO_CENTER:
                view.setPivotX(view.getWidth() / 2);
                view.setPivotY(view.getHeight() / 2);
                break;
            case ScaleAction.ScaleType.TYPE_LEFT_TO_RIGHT:
                view.setPivotX(0);
                view.setPivotY(view.getHeight() / 2);
                break;
            case ScaleAction.ScaleType.TYPE_UNKNOW:
                if (pivotX != null) {
                    view.setPivotX(pivotX);
                }
                if (pivotY != null) {
                    view.setPivotY(pivotY);
                }
                break;
            default:
                break;
        }
    }

//    @Override
//    public ScaleActionHandler setDelay(int delay) {
//        return (ScaleActionHandler) super.setDelay(delay);
//    }
//
//    @Override
//    public ScaleActionHandler setDuration(int duration) {
//        return (ScaleActionHandler) super.setDuration(duration);
//    }
//
//    @Override
//    public ScaleActionHandler setInterpolator(Interpolator interpolator) {
//        return (ScaleActionHandler) super.setInterpolator(interpolator);
//    }
//

    public BaseActionHandler setValue(float scaleX, float scaleY) {
        animatorPath.animatorAction.value1 = scaleX;
        animatorPath.animatorAction.value2 = scaleY;
        return this;
    }

    public ScaleActionHandler setScaleType(@ScaleAction.ScaleType int scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    public ScaleActionHandler setScalePivot(Integer pivotX, Integer pivotY) {
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        return this;
    }
}
