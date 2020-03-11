package co.cheapshot.v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseRemoteConfig.getInstance().fetchAndActivate()
            .addOnCompleteListener {
                val value = FirebaseRemoteConfig.getInstance().getString("store_banners")
            }.addOnFailureListener {
                //Error is here
                Log.e("MainActivity", it.message!!)
            }
    }
}
