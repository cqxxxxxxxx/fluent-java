package com.cqx.fluent.verify;

/**
 * @desc:
 * @version: 1.0.0
 * @author: cqx
 * @Date: 2019/11/4
 */
@FunctionalInterface
public interface ISure<T> {

    Boolean sure(T t);

}
