package com.example.lyodscustomview

import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.lyodscustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var user : Users
    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)

        lifecycle.addObserver(MainActivityObserver())
        Log.i("maintag", "activiyt created")
       // setContentView(R.layout.activity_main)

        var mainXml : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

         user = Users("RAVI")
        mainXml.myusers = user

        mainXml.buttonSubmit.setOnClickListener {
            Toast.makeText(this, "Username is ${user.username}",Toast.LENGTH_SHORT).show()

        }








        var filter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        var myReceiver = MyReceiver()
        registerReceiver(myReceiver, filter)

        if(ActivityCompat.checkSelfPermission
                (this, android.Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show()
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECEIVE_SMS), 123)
        }

    }
}