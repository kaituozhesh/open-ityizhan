package com.open.ityizhan.general.buffer;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description:
 * @ClassName: ExportContext
 * @Auther: lin
 * @Date: 2024/6/28 14:21
 * @Version: 1.0
 */
public class ExportContext {
    Map<String, Object>[] buffer;
    AtomicBoolean done;
    int readPointer;
    int writePointer;
    int remMask;
    @Setter
    Exception e;

    public ExportContext(int size) {
        // noinspection unchecked
        this.buffer = (Map<String, Object>[]) new HashMap[size];
        /*
         * size 得是 2的倍数 - 1
         * size    = 8 -> 1000
         * remMask = 7 -> 0111
         * 假设读取到了 readPointer = 4  -> 0100 & 0111 = 4  等同于取余 4  % 8 = 4  如果是取余就得用数据长度
         * 假设读取到了 readPointer = 10 -> 1010 & 0111 = 2  等同于取余 10 % 8 = 2
         */
        this.remMask = size - 1;
        this.done = new AtomicBoolean(false);
    }

    public void done() {
        done.compareAndSet(false, true);
    }

    public boolean isDone() {
        return done.get();
    }

    public void addResults(Map<String, Object>[] results) {
        if (results == null) {
            return;
        }
        for (Map<String, Object> result : results) {
            if (result != null) {
                buffer[getBufferPos(writePointer++)] = result;
            }
        }
    }

    public Map<String, Object>[] getAll() throws Exception {
        if (e != null) {
            throw e;
        }

        int start = readPointer;
        int end = writePointer;
        int count = end - start;
        if (count == 0) {
            return null;
        }
        // noinspection unchecked
        Map<String, Object>[] results = (Map<String, Object>[]) new HashMap[count];
        for (int i = start; i < end; i++) {
            int bufferPos = getBufferPos(i);
            Map<String, Object> element = buffer[bufferPos];
            if (element != null) {
                results[i - start] = element;
                buffer[bufferPos] = null;
            }
        }
        readPointer = end;
        return results;
    }

    public boolean isEmpty() {
        long start = readPointer;
        long write = writePointer;
        return start >= write;
    }

    private int getBufferPos(long pointer) {
        return (int) pointer & remMask;
    }
}
