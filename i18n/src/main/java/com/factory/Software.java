package com.factory;

import com.factory.i18n.I18N;
import com.factory.i18n.I18NFactory;

/**
 * @author: lijinhao
 * @date: 2022/02/08 18:17
 */
public class Software {
    public static void main(String[] args) {
        I18N i18n = I18NFactory.getI18NObject("Chinese");
        System.out.println(i18n.getLanguage());
    }
}
