package com.bluepha.common.global;

import lombok.Getter;

@Getter
public enum DeviceStatusEnum {

    NO_USE(1,"空闲中"),

    USED(2,"使用中");

    private final int code;

    private final String desc;

    DeviceStatusEnum(int code, String desc){
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
