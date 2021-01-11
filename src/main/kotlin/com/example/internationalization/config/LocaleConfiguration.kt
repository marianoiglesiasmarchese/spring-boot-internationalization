package com.example.internationalization.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor

@Configuration
class LocaleConfiguration {

    companion object {
        private const val ENCODE_FORMAT = "UTF-8"
        private const val MESSAGES_PATH = "i18n/messages"
    }

    @Bean
    fun messageSource(): ResourceBundleMessageSource {
        return ResourceBundleMessageSource().apply {
            setBasenames(MESSAGES_PATH)
            setUseCodeAsDefaultMessage(true)
            setDefaultEncoding(ENCODE_FORMAT)
        }
    }

    @Bean
    fun localeChangeInterceptor(): LocaleChangeInterceptor {
        return LocaleChangeInterceptor()
    }

    @Override
    fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(localeChangeInterceptor())
    }
}