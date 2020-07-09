package com.example.util;

import org.apache.commons.beanutils.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter {
    @Override
    public Object convert(Class aClass, Object value) {
        String strVal = (String) value;
        // 将String转换为Date --- 需要使用日期格式化
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(strVal);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}