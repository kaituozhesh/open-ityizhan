package com.open.ityizhan.general.eventBus.handler;

import com.open.ityizhan.general.eventBus.event.Event;

/**
 * 事件处理器
 *
 * @param <E>
 */
public interface EventHandler<E extends Event> {

    /**
     * 处理事件
     *
     * @param event
     * @throws Exception
     */
    void handleEvent(E event) throws Exception;

    /**
     * HandlerName
     *
     * @return
     */
    default String handlerName() {
        return this.getClass().getName();
    }
}
