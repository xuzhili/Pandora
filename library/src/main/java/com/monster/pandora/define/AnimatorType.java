package com.monster.pandora.define;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by $xuzhili on 2018/12/28.
 */

@IntDef({AnimatorType.TYPE_ALPHA
        , AnimatorType.TYPE_SCALE
        , AnimatorType.TYPE_TRANSLATION
        , AnimatorType.TYPE_SIZE})
@Retention(RetentionPolicy.SOURCE)
public @interface AnimatorType {

    int TYPE_ALPHA = 0x2019009;
    int TYPE_SCALE = 0x2019010;
    int TYPE_TRANSLATION = 0x2019011;
    int TYPE_SIZE = 0x2019012;

}
