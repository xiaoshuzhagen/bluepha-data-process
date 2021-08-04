package com.bluepha.common.global;

import lombok.Getter;

@Getter
public enum DeviceTypeEnum {

    FERMENTATION_CYLINDER(1,"发酵罐");

    private final int code;

    private final String desc;

    DeviceTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }

}
