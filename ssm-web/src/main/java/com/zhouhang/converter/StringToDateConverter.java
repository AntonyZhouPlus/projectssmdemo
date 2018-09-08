package com.zhouhang.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.converter
 * @date 2018/9/2
 */
public class StringToDateConverter implements Converter<String, Date> {



    @Override
    public Date convert(String source) {

        SimpleDateFormat simpleDateFormat= null;

        try {
            if (StringUtils.isEmpty(source)) {
                throw new NullPointerException("日期为空");
            }
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date parse = simpleDateFormat.parse(source);
            return parse;
        } catch (ParseException e) {
            throw new RuntimeException("转换出错");
        }
    }
}
