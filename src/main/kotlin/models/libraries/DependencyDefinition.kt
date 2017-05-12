package models.libraries

data class DependencyDefinition(
        val classpath: List<String>?,
        val plugin: List<String>?,
        val compile: List<String>?,
        val annotationProcessor: List<String>?,
        val provided: List<String>?
)