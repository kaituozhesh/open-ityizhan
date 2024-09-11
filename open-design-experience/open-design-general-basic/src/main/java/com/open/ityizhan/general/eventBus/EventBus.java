package com.open.ityizhan.general.eventBus;

import com.open.ityizhan.general.eventBus.event.Event;
import com.open.ityizhan.general.eventBus.handler.EventHandler;

import java.lang.reflect.Type;

public interface EventBus {

    /**
     * 发送消息
     *
     * @param event
     */
    void publish(Event event);

    /**
     * 注册EventHandler
     *
     * @param handler
     * @param eventType
     * @param <T>
     */
    <T extends Event> void register(EventHandler<T> handler, Type eventType);

    /**
     * shutdown
     */
    void shutdown();

    /**
     * 顺序
     *
     * @return
     */
    default int order() {
        return Integer.MAX_VALUE;

    }

}
