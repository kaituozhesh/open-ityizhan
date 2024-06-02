package com.open.ityizhan.general.exceptions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 异常设计方案，避免了StringBuilder拼接
 * @ClassName: MissingRequiredExceptionExample
 * @Auther: lin
 * @Date: 2024/6/2 11:15
 * @Version: 1.0
 */
public class MissingRequiredExceptionExample {

    public static void main(String[] args) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("userName", "zs");
        properties.put("password", "123456");

        List<String> requiredProperties = Stream.of("userName", "password", "address").collect(Collectors.toList());

        MissingRequiredPropertiesException ex = new MissingRequiredPropertiesException();
        for (String key : requiredProperties) {
            if (properties.get(key) == null) {
                ex.addMissingRequiredProperty(key);
            }
        }
        if (!ex.getMissingRequiredProperties().isEmpty()) {
            throw ex;
        }
    }
}

class MissingRequiredPropertiesException extends IllegalStateException {

    private final Set<String> missingRequiredProperties = new LinkedHashSet<>();

    void addMissingRequiredProperty(String key) {
        this.missingRequiredProperties.add(key);
    }

    @Override
    public String getMessage() {
        return "必要字段不存在:" + getMissingRequiredProperties();
    }

    public Set<String> getMissingRequiredProperties() {
        return this.missingRequiredProperties;
    }
}
