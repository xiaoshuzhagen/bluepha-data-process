package com.bluepha.business.deviceInfo.mapper;

import com.bluepha.business.deviceInfo.bean.DeviceInfo;
import com.bluepha.business.deviceInfo.bean.DeviceInfoVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * *****************************************************************************
 *
 *               Copyright(c) 2021 by 北京蓝晶微生物科技有限公司.
 *
 *                       All rights reserved.
 *
 *******************************************************************************
 *     File Name         :   DeviceInfoMapper.java
 *
 *     Description       :   发酵云系统发酵设备信息Mapper类
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-06-18             WuJi	               Created
 ********************************************************************************
 */

@Mapper
public interface DeviceInfoMapper extends tk.mybatis.mapper.common.Mapper<DeviceInfo>{

    /**
     * @author  WuJi
     * @time    2021-07-13
     * @param   id
     * @return  DeviceInfoVO
     * 方法说明： 根据设备Id查询设备信息
     */
    DeviceInfoVO findById(String id);

}
