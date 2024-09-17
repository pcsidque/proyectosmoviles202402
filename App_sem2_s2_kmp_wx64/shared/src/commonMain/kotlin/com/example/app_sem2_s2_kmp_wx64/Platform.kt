package com.example.app_sem2_s2_kmp_wx64

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform