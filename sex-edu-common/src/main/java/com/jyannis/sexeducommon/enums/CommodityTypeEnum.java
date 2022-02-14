package com.jyannis.sexeducommon.enums;

public enum CommodityTypeEnum {

    CHILDREN("CHILDREN","孩子课"),
    PARENTS("PARENTS","家长课"),
    TEACHER("TEACHER","讲师课"),
            ;

    private String name;

    private String description;

    CommodityTypeEnum(String name, String description) {
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
