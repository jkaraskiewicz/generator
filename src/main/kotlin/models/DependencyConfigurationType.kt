package models

import com.fasterxml.jackson.annotation.JsonProperty

enum class DependencyConfigurationType {
  @JsonProperty("compile")
  COMPILE,
  @JsonProperty("provided")
  PROVIDED,
  @JsonProperty("apk")
  APK,
  @JsonProperty("annotationProcessor")
  ANNOTATION_PROCESSOR,
  @JsonProperty("api")
  API,
  @JsonProperty("implementation")
  IMPLEMENTATION,
  @JsonProperty("compileOnly")
  COMPILE_ONLY,
  @JsonProperty("runtimeOnly")
  RUNTIME_ONLY,
  @JsonProperty("kapt")
  KAPT
}

val DependencyConfigurationType.label: String
  get() = this::class.java.getField(name).getAnnotation(JsonProperty::class.java).value
