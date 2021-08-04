package com.bluepha.common.handler;

import com.bluepha.business.deviceInfo.bean.DeviceInfo;
import com.bluepha.business.deviceInfo.bean.DeviceInfoMQ;
import com.bluepha.business.deviceInfo.bean.DeviceInfoVO;
import com.bluepha.business.deviceInfo.mapper.DeviceInfoMapper;
import com.bluepha.business.deviceOnlineDataInfo.bean.DeviceOnlineDataInfo;
import com.bluepha.business.deviceOnlineDataInfo.bean.json.JsonRootBean;
import com.bluepha.business.deviceOnlineDataInfo.bean.json.Services;
import com.bluepha.business.deviceOnlineDataInfo.mapper.DeviceOnlineDataInfoMapper;
import com.bluepha.common.global.DeviceStatusEnum;
import com.bluepha.common.global.DeviceTypeEnum;
import com.bluepha.common.global.EnableStatusEnum;
import com.bluepha.common.utils.DateUtils;
import com.bluepha.common.utils.JsonUtils;
import com.bluepha.common.utils.UUIDUtils;
import com.github.tocrhz.mqtt.annotation.MqttSubscribe;
import com.github.tocrhz.mqtt.annotation.NamedValue;
import com.github.tocrhz.mqtt.annotation.Payload;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


/**
 * *****************************************************************************
 *
 *               Copyright(c) 2021 by 北京蓝晶微生物科技有限公司.
 *
 *                       All rights reserved.
 *
 *******************************************************************************
 *     File Name         :   MqttMessageHandler.java
 *
 *     Description       :   发酵云系统数据采集处理服务数据监听类
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-06-22             WuJi	               Created
 ********************************************************************************
 */

@Slf4j
@Component
public class MqttMessageHandler {

    private int count = 0;

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Autowired
    private DeviceOnlineDataInfoMapper deviceOnlineDataInfoMapper;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @author  WuJi
     * @time    2021-06-30
     * @param   topic (topic名称)
     * @param   id (动态的设备id)
     * @param   payload (消息报文)
     * 方法说明： 监听指定数据上报的Topic
     */
    @MqttSubscribe(value = "$oc/devices/{id}/sys/properties/report")
    public void deviceData(String topic, @NamedValue("id") String id, @Payload String payload) {
        if ((count == 0 || count == 60 ) && StringUtils.isNotBlank(payload)){
            log.info(payload);
            // 解析终端传过来的数据值
            JsonRootBean jsonRootBean = JsonUtils.fromJson(payload, JsonRootBean.class);
            if ( null != jsonRootBean && jsonRootBean.getServices().size() > 0 ){
                for (Services services : jsonRootBean.getServices() ){
                    // 保存设备在线数据
                    if ( null != services.getProperties() ){
                        DeviceOnlineDataInfo deviceOnlineDataInfo = DeviceOnlineDataInfo.builder()
                                .id(UUIDUtils.uuid())
                                .deviceId(id)
                                .data(services.getProperties())
                                .eventTime(df.format(new Date()))
                                .build();
                        deviceOnlineDataInfoMapper.save(deviceOnlineDataInfo);
                    }
                }
            }
        }
        if (count == 60){
            count = 0;
        }else{
            count++;
        }
    }

    /**
     * @author  WuJi
     * @time    2021-08-04
     * @param   topic (topic名称)
     * @param   payload (消息报文)
     * 方法说明： 监听注册设备的Topic
     */
    @MqttSubscribe(value = "$oc/device")
    public void devices(String topic, @Payload String payload) {
        log.info(payload);
        if (StringUtils.isNotBlank(payload)){
            List<DeviceInfoMQ> list = JsonUtils.fromJson(payload,new TypeToken<List<DeviceInfoMQ>>() {}.getType());
            if (!list.isEmpty()) {
                for (DeviceInfoMQ deviceInfoMQ: list) {
                    // 根据设备ID查询设备是否已经存在
                    DeviceInfoVO deviceInfoVO = deviceInfoMapper.findById(deviceInfoMQ.getDevice_Id());
                    if ( null == deviceInfoVO ){
                        DeviceInfo deviceInfo = DeviceInfo.builder()
                                .id(deviceInfoMQ.getDevice_Id())
                                .deviceName(deviceInfoMQ.getDevice_Name())
                                .deviceSpecs(deviceInfoMQ.getDevice_Specs())
                                .deviceStatus(DeviceStatusEnum.NO_USE.getCode())
                                .deviceType(DeviceTypeEnum.FERMENTATION_CYLINDER.getCode())
                                .enable(EnableStatusEnum.ENABLE.getCode())
                                .laboratoryId("76ECDBE5-284D-472C-85AB-542585F7FD9A")
                                .build();
                        deviceInfoMapper.insert(deviceInfo);
                    }
                }
            }
        }
    }

}


