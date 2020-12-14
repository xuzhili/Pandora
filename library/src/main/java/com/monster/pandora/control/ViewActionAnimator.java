package com.monster.pandora.control;

import android.support.annotation.NonNull;

import com.monster.pandora.define.AnimatorPath;
import com.monster.pandora.define.OnPandoraUpdateListener;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public interface ViewActionAnimator {

    void onActionOccur(boolean forward);

    void onActionOccur();

    void startAnimator();

    void endAnimator();

    void setAnimatorPath(@NonNull AnimatorPath animatorPath);
}
