package com.hbn.study.mongodblearning.locale;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @ClassNmae LocaleTest
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 7:29
 * @Version 1.0
 * 国际化测试
 */
public class LocaleTest {
    public static void main(String[] args) {
//        Locale locale = new Locale("en", "US");
        Locale locale = Locale.CHINA;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Message",locale);
        String info = resourceBundle.getString("info");
        System.out.println(MessageFormat.format(info, "hbn"));
        System.out.println(info);
    }
}
