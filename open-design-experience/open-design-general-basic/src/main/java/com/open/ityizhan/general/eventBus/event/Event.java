package com.open.ityizhan.general.eventBus.event;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * @Description: 事件源
 * @ClassName: Event
 * @Auther: lin
 * @Date: 2024/9/11 14:55
 * @Version: 1.0
 */
@Getter
public class Event implements Serializable {

    /**
     * 事件id
     */
    private String eventId;

    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 发布时间
     */
    @Setter
    private long publishTime;

    public Event() {
        this.eventId = generateId();
        this.createTime = System.currentTimeMillis();
    }

    public void initPublishTime() {
        if (publishTime == 0) {
            publishTime = System.currentTimeMillis();
        }
    }

    public String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
