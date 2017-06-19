package templates

import util.GeneratorConfig

fun templateAndroidApplication(config: GeneratorConfig) = """
package ${config.applicationId}

import android.app.Application
import timber.log.Timber

class Application : Application() {

  override fun onCreate() {
    super.onCreate()
    initializeLogs()
  }

  private fun initializeLogs() {
    Timber.plant(Timber.DebugTree())
  }
}
""".trimStart()