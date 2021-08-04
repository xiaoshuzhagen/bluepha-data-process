package com.bluepha.business.deviceOnlineDataInfo.bean.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Services {

    /** 采集值 */
    private Object properties;

}
