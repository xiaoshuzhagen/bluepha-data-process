package com.bluepha.common.global;

import lombok.Getter;

@Getter
public enum EnableStatusEnum {

    /** 启用 */
    ENABLE(0,"启用"),

    /** 未启用 */
    DISABLE(1,"未启用");

    private final int code;

    private final String desc;

    EnableStatusEnum(int code, String desc){
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
