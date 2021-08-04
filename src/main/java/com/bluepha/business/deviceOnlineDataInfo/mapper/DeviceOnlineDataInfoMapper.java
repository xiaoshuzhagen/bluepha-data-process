package com.bluepha.business.deviceOnlineDataInfo.mapper;

import com.bluepha.business.deviceOnlineDataInfo.bean.DeviceOnlineDataInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * *****************************************************************************
 *
 *               Copyright(c) 2021 by 北京蓝晶微生物科技有限公司.
 *
 *                       All rights reserved.
 *
 *******************************************************************************
 *     File Name         :   DeviceOnlineDataInfoMapper.java
 *
 *     Description       :   发酵云系统批次设备在线参数数据信息Mapper类
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-07-27             WuJi	               Created
 ********************************************************************************
 */

@Mapper
public interface DeviceOnlineDataInfoMapper extends tk.mybatis.mapper.common.Mapper<DeviceOnlineDataInfo> {

    /**
     * @author  WuJi
     * @time    2021-08-04
     * @param   deviceOnlineDataInfo
     * 方法说明： 保存设备在线参数数据
     */
    void save(DeviceOnlineDataInfo deviceOnlineDataInfo);

}
