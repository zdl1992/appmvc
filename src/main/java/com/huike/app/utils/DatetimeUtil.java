package com.huike.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by Zero on 2017/8/1.
 */
public class DatetimeUtil {
    /**
     * 获取当前时间 格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getnewDate(){
        try {
            String datestr=new Date().toString();
            Date dates=new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(datestr);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
            String datestrs =sdf.format(dates);
            Date datesf=sdf.parse(datestrs);
            return datesf;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取唯一UUID  32位
     * @return
     */
    public static String getUUid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
