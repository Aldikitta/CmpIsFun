package com.kotlintoolchain.aldikitta

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
