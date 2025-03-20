
import 'package:flutter/services.dart';

import 'my_flutter_sdk_platform_interface.dart';

class MyFlutterSdk {
  static const MethodChannel _channel = MethodChannel('my_flutter_sdk');

  // Function to get platform version
  static Future<String?> getPlatformVersion() async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  // Function to show a native toast message
  static Future<void> showToast(String message) async {
    await _channel.invokeMethod('showToast', {"message": message});
  }

  /// Function to open a native Android activity
  static Future<void> openNativeActivity() async {
    await _channel.invokeMethod('openNativeActivity');
  }
}
