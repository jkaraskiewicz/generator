package util

import models.libraries.DependencyConfig
import models.libraries.Entity
import models.libraries.LibrariesConfig

class DependencyEntitiesManager(private val librariesConfig: LibrariesConfig) {

    fun insertExternalDependencies(dependencies: List<String>) {
        dependencies.forEach {
            ConsoleLogger.log("Adding extra dependency: $it")

            val dependency = it.substringBeforeLast(':')
            val split = it.split(':')

            val name = split[1]
            val version = split[2]

            val dependencyConfig = DependencyConfig(listOf(dependency), null, null)
            librariesConfig.entities.add(Entity(name, version, dependencyConfig))
        }
    }
}