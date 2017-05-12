package models.libraries

data class DependenciesConfig(
        val root: DependencyDefinition?,
        val module: DependencyDefinition?
)