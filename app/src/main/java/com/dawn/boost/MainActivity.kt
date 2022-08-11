package com.dawn.boost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dawn.boost.databinding.ActivityMainBinding
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostRouteOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a=DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);
        findViewById<View>(R.id.to_flutter).setOnClickListener {
            FlutterBoost.instance().open(
                FlutterBoostRouteOptions.Builder()
                    .pageName("homePage")
                    .arguments(hashMapOf()).build()
            )
        }
    }
}