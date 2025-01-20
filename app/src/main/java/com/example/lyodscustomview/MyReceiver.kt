package com.example.lyodscustomview

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // Retrieves a map of extended data from the intent.
        val bundle = intent.extras
        try {
            if (bundle != null) {
                val pdusObj = bundle["pdus"] as Array<Any>?
                for (i in pdusObj!!.indices) {
                    val currentMessage = SmsMessage.createFromPdu(
                        pdusObj[i] as ByteArray
                    )
                    val phoneNumber = currentMessage.displayOriginatingAddress
                    val message = currentMessage.displayMessageBody

                    var arr = message.split(" ").toTypedArray()

                    var first = arr[0]
                    var second = arr[1]

                    Log.i("mytag","splitted $second and $first")
                    Log.i("SmsReceiver", "senderNum: $phoneNumber; message: $message")
                    // Show Alert
                    Toast.makeText( context,"senderNum: $phoneNumber, message: $message", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            Log.e("SmsReceiver", "Exception smsReceiver$e")
        }
    }

}