package com.archforce.arc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String formatDate(Date currentDate, String pattern) {
        if (currentDate != null && !"".equals(pattern) && pattern != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(currentDate);
        } else {
            return null;
        }
    }
}
