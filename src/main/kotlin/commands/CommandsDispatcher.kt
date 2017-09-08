package commands

import filesystem.FileSystemGenerator
import util.ConsoleLogger
import util.GeneratorConfig

class CommandsDispatcher(
  private val fileSystemGenerator: FileSystemGenerator,
  private val config: GeneratorConfig,
  verboseMode: Boolean
) {
  private val executor = CommandsExecutor(config, verboseMode)

  fun dispatchCommands() {
    initializeGradleWrapper()
    initializeGit()
  }

  private fun initializeGit() {
    ConsoleLogger.log("Initializing git repository...")
    executor.exec("git", "init")

    ConsoleLogger.log("Generating template .gitignore...")
    fileSystemGenerator.generateGitIgnores()

    ConsoleLogger.log("Committing current file structure into repository...")
    executor.exec("git", "add", "-A", ".")
    executor.exec("git", "commit", "-m", "Initial commit")
  }

  private fun initializeGradleWrapper() {
    ConsoleLogger.log("Generating gradle wrapper...")
    executor.exec("gradle wrapper --distribution-type=${config.standardConfig.gradle.distribution}")
    executor.exec("chmod +x gradlew")
  }
}