package templates

import util.GeneratorConfig

fun templateAndroidManifest(config: GeneratorConfig) = """
<manifest
    xmlns:android="http://schemas.android.com/apk/res/android"
    package="${config.applicationId}">

  <application
      android:name=".Application"
      android:allowBackup="true"
      android:icon="@mipmap/ic_launcher"
      android:label="@string/app_name"
      android:theme="@style/AppTheme">
    <activity
        android:name=".main.MainActivity"
        android:screenOrientation="portrait">
      <intent-filter>
        <action android:name="android.intent.action.MAIN"/>
        <category android:name="android.intent.category.LAUNCHER"/>
      </intent-filter>
    </activity>
  </application>
</manifest>
""".trimStart()