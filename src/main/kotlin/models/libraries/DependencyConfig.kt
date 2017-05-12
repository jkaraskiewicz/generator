package models.libraries

data class DependencyConfig(
        val compile: List<String>?,
        val annotationProcessor: List<String>?,
        val provided: List<String>?
)