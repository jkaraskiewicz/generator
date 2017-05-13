import com.xenomachina.argparser.ArgParser

class ArgumentsParser(parser: ArgParser) {

    val librariesConfigFile by parser.storing("-l", "--libconfig", help = "Path to libraries config file")

    val standardConfigFile by parser.storing("-s", "--stdconfig", help = "Path to standard config file")

    val projectRootDir by parser.storing("-d", "--directory", help = "Path to root directory for the project")

    val applicationId by parser.storing("-p", "--package", help = "ApplicationId or package name")
}