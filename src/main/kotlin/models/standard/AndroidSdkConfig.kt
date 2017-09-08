package models.standard

data class AndroidSdkConfig(
  val compileSdk: Int,
  val targetSdk: Int,
  val minSdk: Int
)