package com.cqx.fluent.verify.sure;

import com.cqx.fluent.verify.ISure;

/**
 * @desc:
 * @version: 1.0.0
 * @author: cqx
 * @Date: 2019/11/4
 */
public class ObjectSure {

    public static <T extends Object> ISure<T> notNull() {
        return x -> x != null;
    }
}
