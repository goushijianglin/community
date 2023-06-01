package com.cc.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


/**
 * @author jiawei
 * @create 2023/05/30
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTests {
    Logger logger=LoggerFactory.getLogger(LoggerTests.class);
    @Test
    public void loggerTest(){

        logger.debug("debug  *******");
        logger.info("info   *****");
}}
