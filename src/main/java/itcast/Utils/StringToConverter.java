package itcast.Utils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 把字符串转换成日期
 * */
public class StringToConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        if (source==null){
            throw new RuntimeException("error");
        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        //将字符串转换为日期
        try{
            return df.parse(source);
        }catch (ParseException e){
            throw new RuntimeException("error");
        }
    }
}
