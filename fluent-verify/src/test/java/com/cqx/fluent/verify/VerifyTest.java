package com.cqx.fluent.verify;

import com.cqx.fluent.verify.sure.ListSure;
import com.cqx.fluent.verify.sure.NumberSure;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.cqx.fluent.verify.sure.ObjectSure.notNull;
import static com.cqx.fluent.verify.sure.StringSure.notBlank;
import static com.cqx.fluent.verify.sure.StringSure.notEmpty;

/**
 * @desc:
 * @version: 1.0.0
 * @author: cqx
 * @Date: 2019/11/5
 */
public class VerifyTest {


    @Test
    public void test0() {
        Verifier.target("cqx")
                .sure(notEmpty())
                .orElse(System.out::print);

        List<String> strings = new ArrayList<>();
        Verifier.target(strings)
                .sure(notNull())
                .sure(ListSure.notEmpty())
                .orElseReturn(x -> Collections.EMPTY_LIST);

        Verifier.target(100)
                .sure(NumberSure.ge(100))
                .sure(NumberSure.lt(200))
                .orElse(System.out::println);

        Verifier.target(100L)
                .sure(NumberSure.gt(100L))
                .sure(NumberSure.lt(200L))
                .orElse(System.out::println);

        System.out.println(
                Verifier.target(100L)
                .sure(NumberSure.gt(100L))
                .sure(NumberSure.lt(200L))
                        .end()
        );
    }

    @Test(expected = Throwable.class)
    public void test1() {
        Verifier.target(" ")
                .sure(notBlank())
                .orElseThrow(new RuntimeException("required not blank"));

    }


}
