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
 *     File Name         :   DeviceInfo.java
 *
 *     Description       :   发酵设备息展示层实体类
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-06-18             WuJi	               Created
 ********************************************************************************
 */

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceInfoVO {

    /** 主键ID */
    private String id;

    /** 实验室id */
    private String laboratoryId;

    /** 实验室名称 */
    private String laboratoryName;

    /** 设备名称 */
    private String deviceName;

    /** 设备规格 */
    private String deviceSpecs;

    /** 设备类型 */
    private Integer deviceType;

    /** 设备状态 */
    private Integer deviceStatus;

    /** 是否启用 */
    private Integer enable;

}
