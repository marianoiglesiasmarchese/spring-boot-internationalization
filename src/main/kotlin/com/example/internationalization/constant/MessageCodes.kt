package com.example.internationalization.constant

object MessageCodes {
    private const val PREFIX = "some.custom.path.api"

    val TEXT_MAP: HashMap<String, String> = hashMapOf(
        "TITLE" to "$PREFIX.title",
        "CONTENT" to "$PREFIX.content"
    )
}