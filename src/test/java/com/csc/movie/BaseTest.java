package com.csc.movie;

/**
 * Created by Administrator on 2017/6/11 0011.
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */

// 告诉junit spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:configs/spring/dao.xml","classpath:configs/spring/service.xml" })
public class BaseTest {
}
