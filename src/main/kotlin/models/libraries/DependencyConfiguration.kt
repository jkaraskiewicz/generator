package models.libraries

import models.DependencyConfigurationType

data class DependencyConfiguration(
  val type: DependencyConfigurationType,
  val values: List<String>
)
