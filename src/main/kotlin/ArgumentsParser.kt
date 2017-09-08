import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class ArgumentsParser(parser: ArgParser) {

  val librariesConfigFile by parser.storing("-l", "--libconfig", help = "Path to libraries config file").default("assets/config/libraries.yml")

  val standardConfigFile by parser.storing("-s", "--stdconfig", help = "Path to standard config file").default("assets/config/standard.yml")

  val extraGradleDependency by parser.adding("-e", "--extra", help = "Extra gradle dependencies")

  val projectRootDir by parser.storing("-d", "--directory", help = "Path to root directory for the project")

  val applicationId by parser.storing("-p", "--package", help = "ApplicationId or package name")

  val verbose by parser.flagging("-v", "--verbose", help = "Verbose mode").default(false)
}