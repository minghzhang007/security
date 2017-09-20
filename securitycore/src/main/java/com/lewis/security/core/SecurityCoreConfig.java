package com.lewis.security.core;

import com.lewis.security.core.properties.LewisSecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/9/19.
 */
@Configuration
@EnableConfigurationProperties(LewisSecurityProperties.class)
public class SecurityCoreConfig {
}
