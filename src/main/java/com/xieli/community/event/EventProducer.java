package com.xieli.community.event;

import com.alibaba.fastjson.JSONObject;
import com.xieli.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by xieli on 2021/1/23.
 */

@Component
public class EventProducer {

    @Autowired
    public KafkaTemplate kafkaTemplate;

    // 处理事件
    public void fireEvent(Event event) {
        // 将事件发布到指定的主题
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }

}
