package com.jyannis.sexeducommon.enums;

/**
 * @author yannis
 * @version 2020/11/9 10:39
 */
public enum CommodityObjectTypeEnum {

    BOOK("BOOK","图书"),
    CLASS_OFFLINE("CLASS_OFFLINE","线下课"),
    CLASS_ONLINE("CLASS_ONLINE","线上课"),
    ALL("ALL","通用类型")
    ;

    private String name;

    private String description;

    CommodityObjectTypeEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
