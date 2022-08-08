package com.dawn.boost

import android.app.Application
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostDelegate
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import io.flutter.embedding.engine.FlutterEngine


class BoostApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        FlutterBoost.instance().setup(
            this,
            object : FlutterBoostDelegate{
                override fun pushNativeRoute(options: FlutterBoostRouteOptions?) {
//                    val intent = Intent(
//                        FlutterBoost.instance().currentActivity(), NativePageActivity::class.java
//                    )
//                    FlutterBoost.instance().currentActivity()
//                        .startActivityForResult(intent, options!!.requestCode())
                }

                override fun pushFlutterRoute(options: FlutterBoostRouteOptions) {
                    val intent = FlutterBoostActivity.CachedEngineIntentBuilder(MainFlutterActivity::class.java)
                        .destroyEngineWithActivity(false)
                        .uniqueId(options.uniqueId())
                        .url(options.pageName())
                        .urlParams(options.arguments())
                        .build(FlutterBoost.instance().currentActivity())
                    FlutterBoost.instance().currentActivity().startActivity(intent)

                }

            }

        ) { engine: FlutterEngine ->

        }
    }
}