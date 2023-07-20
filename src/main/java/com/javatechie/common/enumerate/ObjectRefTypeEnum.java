package com.javatechie.common.enumerate;

import java.util.HashMap;
import java.util.Map;

public enum ObjectRefTypeEnum {
    AVATAR_STORE("Ảnh đại diện cửa hàng"),
    IMAGE_STORE_DESCRIPTION("Ảnh mô tả");

    String value;

    private static Map<String, ObjectRefTypeEnum> map = new HashMap<>();
    static {
        for (ObjectRefTypeEnum r : ObjectRefTypeEnum.values()) {
            map.put(r.name(), r);
        }
    }

    ObjectRefTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ObjectRefTypeEnum getEnum(String value) {
        return map.get(value.toUpperCase());
    }
}
