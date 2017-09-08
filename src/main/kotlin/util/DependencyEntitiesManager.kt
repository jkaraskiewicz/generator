package util

import models.DependencyConfigurationType
import models.libraries.DependencyConfiguration
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

      val dependencyConfiguration = DependencyConfiguration(DependencyConfigurationType.IMPLEMENTATION, listOf(dependency))
      librariesConfig.entities.add(Entity(name, version, listOf(dependencyConfiguration)))
    }
  }
}