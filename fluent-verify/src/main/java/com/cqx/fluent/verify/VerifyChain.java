package com.cqx.fluent.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 参数校验链
 * @desc:
 * @version: 1.0.0
 * @author: cqx
 * @Date: 2019/11/4
 */
public class VerifyChain<T> {

    private List<ISure<T>> verifiers;

    private T target;

    public VerifyChain() {
        verifiers = new ArrayList<>(4);
    }

    public VerifyChain<T> target(T t) {
        this.target = t;
        return this;
    }

//  Intermediate操作
    public VerifyChain<T> sure(ISure<T> sure) {
        verifiers.add(sure);
        return this;
    }

//  Terminal操作，Terminal 操作的执行，才会真正开始校验流程
    public boolean end() {
        return runVerify();
    }

    public void orElse(Consumer<T> consumer) {
        if (!runVerify()) {
            consumer.accept(target);
        }
    }

    public <R> R orElseReturn(Function<T, R> function) {
        if (!runVerify()) {
            return function.apply(target);
        }
        return null;
    }

    public void orElseThrow(RuntimeException runtimeEx) {
        if (!runVerify()) {
            throw runtimeEx;
        }
    }

    public <X extends Throwable> void orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (!runVerify()) {
            throw exceptionSupplier.get();
        }
    }

    private boolean runVerify() {
        for (ISure s : verifiers) {
            if (!s.sure(target)) {
                return false;
            }
        }
        return true;
    }
}
