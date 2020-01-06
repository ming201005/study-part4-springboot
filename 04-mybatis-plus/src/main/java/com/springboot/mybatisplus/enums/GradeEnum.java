package com.springboot.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 描述：年级枚举
 * 以下示例是根据MP官网提供的代码进行改编
 */
public enum GradeEnum {

    GRADE_ONE(1, "大一"),
    GRADE_TWO(2, "大二"),
    GRADE_THREE(3, "大三"),
    GRADE_FOUR (4, "大四");

    GradeEnum(Integer code, String des) {
        this.code = code;
        this.des = des;
    }

    //存储值
    @EnumValue
    private final Integer code;

    //显示值
    @JsonValue
    private final String des;

    //get set

    public Integer getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    @Override
    public String toString() {
        return "GradeEnum{" +
                "code=" + code +
                ", des='" + des + '\'' +
                '}';
    }
}
