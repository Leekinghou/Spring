package com.factory.i18n;

/**
 * @author: lijinhao
 * @date: 2022/02/08 18:18
 */
public class I18NFactory {
    public static I18N getI18NObject(String language){
        if(language.equals("Chinese")){
            return new Chinese();
        }else if(language.equals("Spainish")){
            return new Spainish();
        }else if(language.equals("Italian")){
            return new Italian();
        }else{
            return null;
        }
    }
}
