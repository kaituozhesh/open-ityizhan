package com.open.ityizhan.general.eventBus;

import cn.hutool.core.collection.CollectionUtil;
import com.open.ityizhan.general.eventBus.event.Event;
import com.open.ityizhan.general.eventBus.handler.EventHandler;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 默认的事件总线
 * @ClassName: DefaultEventBus
 * @Auther: lin
 * @Date: 2024/9/11 15:00
 * @Version: 1.0
 */
public class DefaultEventBus implements EventBus {
    private Map<String, List<EventHandler>> handlersMap = new ConcurrentHashMap<>();

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    /**
     * 发送消息
     *
     * @param event
     */
    @Override
    public void publish(Event event) {
        // 如果没有事件名称按类型匹配
        List<EventHandler> handlers = getHandler(event);
        if (CollectionUtil.isEmpty(handlers)) {
            return;
        }
        // 执行handler
        for (EventHandler handler : handlers) {
            try {
                handler.handleEvent(event);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 注册EventHandler
     *
     * @param handler
     * @param eventType
     */
    @Override
    public <T extends Event> void register(EventHandler<T> handler, Type eventType) {
        try {
            writeLock.lock();
            // 通过方法注册event handler
            if (Objects.isNull(eventType)) {
                throw new IllegalStateException("cdc handler 必须定义泛型!");
            }
            String eventName = eventType.getTypeName();

            List<EventHandler> eventHandlers = handlersMap.get(eventName);
            if (Objects.isNull(eventHandlers)) {
                eventHandlers = Collections.emptyList();
            }
            eventHandlers.add(handler);
            handlersMap.put(eventName, eventHandlers);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 通过事件根据类型自动匹配事件bus
     *
     * @param event
     * @return
     */
    private List<EventHandler> getHandler(Event event) {
        try {
            readLock.lock();
            return handlersMap.get(event.getClass().getTypeName());
        } finally {
            readLock.unlock();
        }
    }


    /**
     * shutdown
     */
    @Override
    public void shutdown() {

    }
}
