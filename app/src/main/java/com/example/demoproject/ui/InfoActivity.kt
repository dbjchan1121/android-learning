package com.example.demoproject.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.demoproject.R


class InfoActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.info_activity)

        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        val data = "username: ".plus(username).plus("\n password: ").plus(password)
        findViewById<TextView>(R.id.tv_userinfo).text = data




    }

    override fun onBackPressed() {
        Log.d("jj:intent", "back")

        intent.putExtra("data", "InfoActivity onBackPressed Data")

        setResult(RESULT_OK, intent)

        super.onBackPressed()
    }


    override fun onDestroy() {
        super.onDestroy()


    }
}

