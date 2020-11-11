package com.example.configuration

import com.example.services.PermissionsHelper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AppConfiguration {

    @Bean
    open fun permissionsEnforcer(): PermissionsHelper {
        return PermissionsHelper()
    }
}