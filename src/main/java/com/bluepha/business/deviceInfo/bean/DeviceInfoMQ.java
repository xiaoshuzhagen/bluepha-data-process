package com.bluepha.business.deviceInfo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * *****************************************************************************
 *
 *               Copyright(c) 2021 by 北京蓝晶微生物科技有限公司.
 *
 *                       All rights reserved.
 *
 *******************************************************************************
 *     File Name         :   DeviceInfoMQ.java
 *
 *     Description       :   发酵设备息接收层实体类
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-08-04             WuJi	               Created
 ********************************************************************************
 */

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceInfoMQ {

    /** 设备ID */
    private String Device_Id;

    /** 设备名称 */
    private String Device_Name;

    /** 设备规格 */
    private String Device_Specs;

}
