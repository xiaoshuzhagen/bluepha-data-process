package com.bluepha.business.deviceOnlineDataInfo.bean;

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
 *     File Name         :   DeviceOfficeDataInfo.java
 *
 *     Description       :   发酵云系统设备在线数据实体类
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-08-04             WuJi	               Created
 ********************************************************************************
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceOnlineDataInfo implements Serializable {

    @Id
    /** 主键ID */
    private String id;

    /** 设备ID */
    private String deviceId;

    /** 在线参数值 */
    private Object data;

    /** 数据采集时间 */
    private String eventTime;

}
