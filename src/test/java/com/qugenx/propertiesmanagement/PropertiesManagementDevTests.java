package com.qugenx.propertiesmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Profile("dev")
public class PropertiesManagementDevTests {

    private Logger logger = LoggerFactory.getLogger(PropertiesManagementDevTests.class);

    @Autowired
    private Environment environment;


    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Test
    public void testActiveProfiles() {
        assertEquals("dev", activeProfile);
        assertEquals("jdbc:mysql://localhost:8889/test?useSSL=false", dataSourceUrl);
        assertArrayEquals(new String[]{"dev"}, environment.getActiveProfiles());
    }


    @Test
    public void contextLoads() {
        logger.info("An INFO Message from DEV profile");
    }

}
