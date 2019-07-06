package com.yy.entity;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Package: com.yy.entity
 * @ClassName: Account
 * @Author: Created By Yy
 * @Date: 2019-07-03 16:16
 */
@Data
@ConfigurationProperties(prefix = "ai")
@Component
public class Account {

    private Integer appId;

    private String appKey;
}
