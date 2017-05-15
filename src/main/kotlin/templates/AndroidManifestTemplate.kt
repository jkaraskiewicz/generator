package templates

import util.GeneratorConfig

fun templateAndroidManifest(config: GeneratorConfig) = """
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="${config.applicationId}">

    <application
            android:allowBackup="true"
            android:label="@string/app_name"
            android:name=".Application"
            android:icon="@mipmap/ic_launcher"
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