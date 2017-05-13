import com.xenomachina.argparser.ArgParser
import commands.CommandsDispatcher
import filesystem.FileSystemGenerator
import parser.parseLibraries
import parser.parseStandard
import util.GeneratorConfig
import java.nio.file.Paths

fun main(args: Array<String>) {
    val argsParser = ArgumentsParser(ArgParser(args))

    val config = GeneratorConfig(
            librariesConfig = parseLibraries(Paths.get(argsParser.librariesConfigFile)),
            standardConfig = parseStandard(Paths.get(argsParser.standardConfigFile)),
            applicationId = argsParser.applicationId,
            rootProjectDirPath = argsParser.projectRootDir
    )

    val fileSystemGenerator = FileSystemGenerator(config)
    fileSystemGenerator.generate()

    val commandsDispatcher = CommandsDispatcher(fileSystemGenerator, config)
    commandsDispatcher.dispatchCommands()
}