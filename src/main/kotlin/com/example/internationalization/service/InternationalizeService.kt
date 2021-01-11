package com.example.internationalization.service

import com.example.internationalization.constant.Languages.ALLOWED_LANGUAGES
import com.example.internationalization.constant.MessageCodes
import com.example.internationalization.exception.ErrorCode
import com.example.internationalization.utils.Util
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class InternationalizeService(
    val messageSource: MessageSource
) {

    fun resolveHeaderBasedRequest(language: String): String {
        val languageLowercase = language.toLowerCase()
        val titleDescription = MessageCodes.TEXT_MAP["TITLE"]
        if (titleDescription.isNullOrBlank()) {
//            throw RuntimeException(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_HEADER_VALUE, "Unable to get resource", null)
            throw Exception()
        } else if (language.isNullOrBlank() || !ALLOWED_LANGUAGES.contains(languageLowercase)) {
//            throw RuntimeException(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_HEADER_VALUE, "invalid header value", null)
            throw Exception()
        }
        val localeLanguage = Util.getLanguage(languageLowercase)
        return messageSource.getMessage(titleDescription, null, localeLanguage)
    }

//    fun resolveHeaderBasedWithoutLanguageSafety(language: String): String {
//        val languageLowercase = language.toLowerCase()
//        val titleDescription = MessageCodes.TEXT_MAP["TITLE"]
//        if (titleDescription.isNullOrBlank()) {
////            throw RuntimeException(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_HEADER_VALUE, "Unable to get resource", null)
//            throw Exception()
//        }
//        val localeLanguage = Util.getLanguageWithoutDefaultValue(languageLowercase)
//        return messageSource.getMessage(titleDescription, null, localeLanguage)
//    }

    fun resolveRequest(): String {
        val titleDescription = MessageCodes.TEXT_MAP["TITLE"]
        if (titleDescription.isNullOrBlank()) {
//            throw Exception(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_HEADER_VALUE, "Unable to get resource", null)
            throw Exception()
        }
        return messageSource.getMessage(titleDescription, null, LocaleContextHolder.getLocale())
    }


}
