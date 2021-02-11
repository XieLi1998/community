package com.xieli.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by xieli on 2021/2/11.
 */

@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig {
}
