package templates

import util.GeneratorConfig

fun templateAndroidResourcesStyles() = """
<?xml version="1.0" encoding="utf-8"?>
<resources>
  <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>
  </style>
</resources>
""".trimStart()

fun templateAndroidResourcesColors() = """
<?xml version="1.0" encoding="utf-8"?>
<resources>
  <color name="colorPrimary">#3F51B5</color>
  <color name="colorPrimaryDark">#303F9F</color>
  <color name="colorAccent">#FF4081</color>
</resources>
""".trimStart()

fun templateAndroidResourcesStrings(config: GeneratorConfig) = """
<?xml version="1.0" encoding="utf-8"?>
<resources>
  <string name="app_name">${config.applicationId.substringAfterLast('.')}</string>
</resources>
""".trimStart()