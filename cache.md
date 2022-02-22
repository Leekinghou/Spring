```xml
<aop:pointcut id="pointcut" expression="execution(public * com.spring..*.*(..))"></aop:pointcut>
```

![](https://gitee.com/leekinghou/image/raw/master/img/20220222164721.png)

- `*` 表示通配符
- `..` 表示包通配符（两个点表示无论多少个子包，都可以匹配）
- `(..)` 参数通配符

#### examples
```xml
expression="execution(public * com.spring..*Service.*(..))"
```

```xml
expression="execution(public * com.spring..create*.*(..))"
```

```xml
expression="execution(void com.spring..*.*(..))"
```

```xml
expression="execution(String com.spring..*.*(..))"
```

```xml
expression="execution(String com.spring..*.*(*,*))"
```

```xml
expression="execution(String com.spring..*.*(String, *))"
```

