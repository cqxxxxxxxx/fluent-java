package com.cqx.fluent.verify.sure;

import com.cqx.fluent.verify.ISure;

import java.util.List;

/**
 * @desc:
 * @version: 1.0.0
 * @author: cqx
 * @Date: 2019/11/4
 */
public class ListSure {

    public static <E> ISure<List<E>> notEmpty() {
        return x -> x != null && !x.isEmpty();
    }

}
