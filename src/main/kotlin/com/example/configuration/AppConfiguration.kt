package com.example.configuration

import com.example.helpers.APIConnector
import com.example.helpers.PermissionsHelper
import com.example.helpers.SessionHelper
import com.example.services.AuthenticationService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.session.MapSessionRepository
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession
import java.util.concurrent.ConcurrentHashMap

@Configuration
@EnableSpringHttpSession
open class AppConfiguration {

    @Bean
    open fun permissionsEnforcer() = PermissionsHelper()

    @Bean
    open fun sessionHelper() = SessionHelper()

    @Bean
    open fun apiConnector() = APIConnector()

    @Bean
    open fun authenticationService(
        sessionHelper: SessionHelper,
        apiConnector: APIConnector,
        sessionRepository: MapSessionRepository
    ) = AuthenticationService(sessionHelper, apiConnector, sessionRepository)

    @Bean
    open fun mapSessionRepository() = MapSessionRepository(ConcurrentHashMap())
}