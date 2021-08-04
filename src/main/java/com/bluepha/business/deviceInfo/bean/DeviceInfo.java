package com.bluepha.business.deviceInfo.bean;

import com.bluepha.common.global.DeviceStatusEnum;
import com.bluepha.common.global.EnableStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

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
 *     Description       :   发酵设备息实体类
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-06-18             WuJi	               Created
 ********************************************************************************
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo implements Serializable {

    @Id
    /** 主键ID */
    private String id;

    /** 实验室id */
    private String laboratoryId;

    /** 设备名称 */
    private String deviceName;

    /** 设备规格 */
    private String deviceSpecs;

    /** 设备类型 */
    private Integer deviceType;

    /** 设备状态 */
    private Integer deviceStatus = DeviceStatusEnum.NO_USE.getCode();

    /** 是否启用 */
    private Integer enable = EnableStatusEnum.ENABLE.getCode();

    /** 创建时间 */
    private String createTime;

    /** 创建人 */
    private String createUser;

    /** 变更时间 */
    private String updateTime;

    /** 变更人 */
    private String updateUser;

}
