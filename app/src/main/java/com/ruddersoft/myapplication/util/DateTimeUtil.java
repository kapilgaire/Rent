package com.ruddersoft.myapplication.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateTimeUtil {

    private DateTimeUtil() {
    }
    public static String getCurrentDateTime() {
        return new SimpleDateFormat(AppConstant.DATE_TIME_FORMAT_SAVE).format(Calendar.getInstance().getTime());

    }
}
