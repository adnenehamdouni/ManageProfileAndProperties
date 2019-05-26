package com.qugenx.propertiesmanagement.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDatasourceConfig {
}
