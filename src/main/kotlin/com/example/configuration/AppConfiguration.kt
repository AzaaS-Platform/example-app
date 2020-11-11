package com.example.configuration

import com.example.services.PermissionsEnforcer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AppConfiguration {

    @Bean
    open fun permissionsEnforcer(): PermissionsEnforcer {
        return PermissionsEnforcer()
    }
}