package com.example.internationalization.utils

import com.example.internationalization.constant.Languages
import java.util.Locale

class Util {

    companion object {
        fun getLanguage(language: String?): Locale {
            val localeLanguage = if(language != null){
                if (language.contains(Languages.ES)) {
                    Languages.ES
                } else if (language.contains(Languages.EN)) {
                    Languages.EN
                } else {
                    Languages.ES
                }
            }else{
                Languages.ES
            }
            return Locale(localeLanguage)
        }

        fun getLanguageWithoutDefaultValue(language: String?): Locale {
            var localeLanguage: String = ""
            if(language != null){
                localeLanguage = if (language.contains(Languages.ES)) {
                    Languages.ES
                } else if (language.contains(Languages.EN)) {
                    Languages.EN
                } else {
                    Languages.PT
                }
            }
            return Locale(localeLanguage)
        }
    }
}