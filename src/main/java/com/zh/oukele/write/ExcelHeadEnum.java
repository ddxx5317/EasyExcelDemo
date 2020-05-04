package com.zh.oukele.write;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/5/4
 */
public enum ExcelHeadEnum {
    NO(1001,"序号"),
    NAME(1002,"名称"),
    ADDR(1003,"地址")
    ;
    private Integer code;
    private String msg;

    ExcelHeadEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ExcelHeadEnum getEnumByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        for (ExcelHeadEnum e : ExcelHeadEnum.values()) {
            if (name.equals(e.name())) {
                return e;
            }
        }
        return null;
    }

    public static ExcelHeadEnum getEnumByCode(Integer code) {
        if (null == code) {
            return null;
        }
        for (ExcelHeadEnum e : ExcelHeadEnum.values()) {
            if (code.equals(e.getCode())) {
                return e;
            }
        }
        return null;
    }

    public static Map<String, ExcelHeadEnum> toMap() {
        ExcelHeadEnum[] ary = ExcelHeadEnum.values();
        Map<String, ExcelHeadEnum> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            String key = ary[num].name();
            enumMap.put(key, ary[num]);
        }
        return enumMap;
    }
}
