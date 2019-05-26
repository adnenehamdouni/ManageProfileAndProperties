package com.qugenx.propertiesmanagement.service.impl;


import com.qugenx.propertiesmanagement.service.ProfileService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class ProfileDevService implements ProfileService {
    @Override
    public String getProfileName() {
        return "DEV PROFILE";
    }
}
