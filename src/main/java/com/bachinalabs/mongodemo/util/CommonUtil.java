package com.bachinalabs.mongodemo.util;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {

    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }
}
