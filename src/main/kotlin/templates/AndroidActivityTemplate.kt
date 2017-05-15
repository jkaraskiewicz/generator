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

fun templateAndroidActivityLayout() = """
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="match_parent">

    <TextView
            android:text="Hello!"
            android:layout_gravity="center"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
</FrameLayout>
""".trimStart()