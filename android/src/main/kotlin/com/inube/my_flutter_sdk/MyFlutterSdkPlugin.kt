package com.inube.my_flutter_sdk

import android.content.Context
import android.content.Intent  // ✅ Import Intent
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

class MyFlutterSdkPlugin: FlutterPlugin, MethodCallHandler {
    private lateinit var channel: MethodChannel
    private var applicationContext: Context? = null  // ✅ Store Application Context

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "my_flutter_sdk")
        channel.setMethodCallHandler(this)
        applicationContext = flutterPluginBinding.applicationContext  // ✅ Store context
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        when (call.method) {
            "getPlatformVersion" -> {
                result.success("Android " + android.os.Build.VERSION.RELEASE)
            }
            "showToast" -> {
                val message = call.argument<String>("message")
                if (message != null) {
                    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                    result.success(null)
                } else {
                    result.error("INVALID_ARGUMENT", "Message cannot be null", null)
                }
            }
            "openNativeActivity" -> {
                openNativeActivity()  // ✅ Call the function to start activity
                result.success(null)
            }
            else -> result.notImplemented()
        }
    }

    private fun openNativeActivity() {
        val context = applicationContext ?: return  // ✅ Ensure context is not null
        val intent = Intent(context, SampleActivity::class.java)  // ✅ Start SampleActivity
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)  // ✅ Required for non-activity context
        context.startActivity(intent)  // ✅ Corrected startActivity call
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}
