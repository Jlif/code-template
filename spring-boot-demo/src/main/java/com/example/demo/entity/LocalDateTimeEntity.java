package com.example.demo.entity;

import com.example.demo.util.CustomLocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author jiangchen
 * @date 2020/08/04
 */
@Data
public class LocalDateTimeEntity {
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime start;
}
