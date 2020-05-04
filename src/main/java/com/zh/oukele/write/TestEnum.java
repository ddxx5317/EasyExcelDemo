package com.zh.oukele.write;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/5/4
 */
public enum TestEnum {
    NO(1001,"序号"),
    NAME(1002,"名称"),
    ADDR(1003,"地址")
    ;
    private Integer code;
    private String name;

    TestEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static TestEnum getEnumByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        for (TestEnum enableStatus : TestEnum.values()) {
            if (name.equals(enableStatus.name())) {
                return enableStatus;
            }
        }
        return null;
    }

    public static TestEnum getEnumByCode(Integer code) {
        if (null == code) {
            return null;
        }
        for (TestEnum enableStatus : TestEnum.values()) {
            if (code.equals(enableStatus.getCode())) {
                return enableStatus;
            }
        }
        return null;
    }

    public static Map<String, TestEnum> toMap() {
        TestEnum[] ary = TestEnum.values();
        Map<String, TestEnum> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            String key = ary[num].name();
            enumMap.put(key, ary[num]);
        }
        return enumMap;
    }
}
