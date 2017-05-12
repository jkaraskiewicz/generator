package models.standard

data class AndroidConfig(
        val sdk: AndroidSdkConfig,
        val buildTools: String,
        val plugin: String
)