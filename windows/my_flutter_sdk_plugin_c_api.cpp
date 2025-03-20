#include "include/my_flutter_sdk/my_flutter_sdk_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "my_flutter_sdk_plugin.h"

void MyFlutterSdkPluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  my_flutter_sdk::MyFlutterSdkPlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
