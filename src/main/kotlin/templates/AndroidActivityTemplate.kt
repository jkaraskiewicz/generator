package templates

import util.GeneratorConfig

fun templateAndroidActivity(config: GeneratorConfig) = """
package ${config.applicationId}.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ${config.applicationId}.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
""".trimStart()