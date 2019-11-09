### fluent-verify

一个参数校验的`Fluent`风格的小工具

#### 使用
```

        //验证不通过则返回false
        Verifier.target(100)
                .sure(NumberSure.ge(100))
                .sure(NumberSure.lt(200))
                .end();
                
        //验证不通过则返回指定值        
        Verifier.target(strings)
                .sure(notNull())
                .sure(ListSure.notEmpty())
                .orElseReturn(x -> Collections.EMPTY_LIST);
                
        //验证不通过则抛出异常        
        Verifier.target(" ")
                .sure(notBlank())
                .orElseThrow(new RuntimeException("required not blank"));
                
```