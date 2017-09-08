import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import commands.CommandsDispatcher
import filesystem.FileSystemGenerator
import parser.parseLibraries
import parser.parseStandard
import util.ConsoleLogger
import util.Constants
import util.DependencyEntitiesManager
import util.GeneratorConfig
import java.nio.file.Paths

fun main(args: Array<String>) = mainBody(Constants.APPLICATION_NAME) {
  val argsParser = ArgumentsParser(ArgParser(args))

  ConsoleLogger.log("Parsing project config...")

  val config = GeneratorConfig(
    librariesConfig = parseLibraries(Paths.get(argsParser.librariesConfigFile)),
    standardConfig = parseStandard(Paths.get(argsParser.standardConfigFile)),
    applicationId = argsParser.applicationId,
    rootProjectDirPath = argsParser.projectRootDir
  )

  val extraGradleDependencies = argsParser.extraGradleDependency
  DependencyEntitiesManager(config.librariesConfig).insertExternalDependencies(extraGradleDependencies)

  ConsoleLogger.log("Generating file structure...")

  val fileSystemGenerator = FileSystemGenerator(config)
  fileSystemGenerator.generate()

  val commandsDispatcher = CommandsDispatcher(fileSystemGenerator, config, argsParser.verbose)
  commandsDispatcher.dispatchCommands()

  ConsoleLogger.log("Done!")
}