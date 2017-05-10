package models

class AndroidConfig(
        val compileSdk: Int,
        val minSdk: Int,
        val targetSdk: Int,
        val gradlePlugin: Version,
        val buildTools: Version,
        val kotlin: Version
)