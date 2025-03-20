#ifndef FLUTTER_PLUGIN_MY_FLUTTER_SDK_PLUGIN_H_
#define FLUTTER_PLUGIN_MY_FLUTTER_SDK_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace my_flutter_sdk {

class MyFlutterSdkPlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  MyFlutterSdkPlugin();

  virtual ~MyFlutterSdkPlugin();

  // Disallow copy and assign.
  MyFlutterSdkPlugin(const MyFlutterSdkPlugin&) = delete;
  MyFlutterSdkPlugin& operator=(const MyFlutterSdkPlugin&) = delete;

  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace my_flutter_sdk

#endif  // FLUTTER_PLUGIN_MY_FLUTTER_SDK_PLUGIN_H_
