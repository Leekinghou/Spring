package com.spring.ioc.utils;

import org.springframework.stereotype.Component;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:40
 */

// 对这种不知道用于控制层还是服务层的类，直接用一个较为宽泛的@Component就行
@Component("stringUtils")
public class StringUtils {
}
