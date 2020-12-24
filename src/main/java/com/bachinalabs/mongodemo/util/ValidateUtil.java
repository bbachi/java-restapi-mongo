package com.bachinalabs.mongodemo.util;

import com.bachinalabs.mongodemo.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;

public class ValidateUtil {

    public static boolean validateName(String name) {
        return CommonUtil.isNotBlank(name) && StringUtils.length(name) < 100;
    }

    public static boolean validateDescription(String description) {
        return CommonUtil.isNotBlank(description) && StringUtils.length(description) < 200;
    }

    public static boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return CommonUtil.isNotBlank(email) && email.matches(regex);
    }

    public static boolean validateNameAndThrowException(String name) throws ValidationException {
        if (CommonUtil.isBlank(name)) {
            throw new ValidationException("Name Shoule Not be Empty");
        }
        if (StringUtils.length(name) > 100) {
            throw new ValidationException("The Length of the Name Shoule Not greater than 100");
        }
        return CommonUtil.isNotBlank(name) && StringUtils.length(name) < 100;
    }
}