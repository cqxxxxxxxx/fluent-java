package com.cqx.fluent.verify;

import com.cqx.fluent.verify.sure.ListSure;
import com.cqx.fluent.verify.sure.NumberSure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.cqx.fluent.verify.sure.ObjectSure.notNull;
import static com.cqx.fluent.verify.sure.StringSure.notEmpty;

/**
 * @desc:
 * @version: 1.0.0
 * @author: cqx
 * @Date: 2019/11/4
 */
public class Verifier {

    /**
     * Verifier.notNull(T t)
     * .bt(x)
     * .orThrow()
     */
    public static <T> VerifyChain<T> target(T t) {
        return new VerifyChain().target(t);
    }

}
