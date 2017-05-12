package models.libraries

data class Entity(
        val name: String,
        val version: String,
        val dependencies: DependencyConfig
)