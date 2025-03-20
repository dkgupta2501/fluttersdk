import 'package:flutter/material.dart';
import 'package:my_flutter_sdk/my_flutter_sdk.dart';  // ✅ Ensure this matches your SDK name

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String? platformVersion;

  @override
  void initState() {
    super.initState();
    getPlatformVersion();
  }

  Future<void> getPlatformVersion() async {
    String? version = await MyFlutterSdk.getPlatformVersion();
    setState(() {
      platformVersion = version;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Flutter SDK Example')),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text('Platform Version: $platformVersion'),
              ElevatedButton(
                onPressed: () {
                  // MyFlutterSdk.showToast("Hello from Flutter SDK!");
                  MyFlutterSdk.openNativeActivity();
                },
                child: Text('Show Toast'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
