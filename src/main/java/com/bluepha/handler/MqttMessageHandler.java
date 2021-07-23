package com.bluepha.handler;

import com.github.tocrhz.mqtt.annotation.MqttSubscribe;
import com.github.tocrhz.mqtt.annotation.NamedValue;
import com.github.tocrhz.mqtt.annotation.Payload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

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

    /**
     * @author  WuJi
     * @time    2021-06-22 10:09
     * @param   topic (topic名称)
     * @param   id (动态的设备id)
     * @param   payload (消息报文)
     * 方法说明：监听指定数据上报的Topic
     */
    @MqttSubscribe(value = "$oc/devices/{id}/sys/properties/report")
    public void sub(String topic, @NamedValue("id") String id, @Payload String payload) {
        log.info("当前时间： {}", LocalDate.now().toString());
        log.info("receive from    : {}", topic);
        log.info("device id : " + id);
        log.info(payload);

    }

}
