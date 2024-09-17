package com.example.app_sem2_s2_kmp_wx64

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Mi 1er prg. en KMP. Estoy usando ${platform.name}!"
    }
}