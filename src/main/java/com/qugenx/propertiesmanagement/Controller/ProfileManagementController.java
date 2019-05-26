package com.qugenx.propertiesmanagement.Controller;

import com.qugenx.propertiesmanagement.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileManagementController {

    @Autowired
    private Environment environment;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Autowired
    private ProfileService profileService;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @GetMapping("/profileByProperty")
    public String getActiveProfileByProp() {
        return activeProfile + " with dataSourceUrl = "+dataSourceUrl;
    }

    @GetMapping("/profileByEnv")
    public String[] getActiveProfileByEnv() {
        return environment.getActiveProfiles();
    }

    @GetMapping("/serviceByProfile")
    public String getServiceByProfile() {
        return profileService.getProfileName();
    }



}
