package com.example.demoproject.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import com.example.demoproject.R

class LoginActivity : ComponentActivity() {

    public val REQUEST_CODE: Int = 1

    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("生命周期", "onCreate")
        setContentView(R.layout.login_activity)




        findViewById<Button>(R.id.btn_login).setOnClickListener {

            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()

            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("username", username)
                putExtra("password", password)
            }


//            startActivity(intent)
            startActivityForResult(intent, REQUEST_CODE)

//            activityResultLauncher.launch(intent)
        }


//        activityResultLauncher = registerForActivityResult(
//            ActivityResultContracts.StartActivityForResult()
//        ) { result: ActivityResult -> // 显式声明 result 类型
//
//            if (result.resultCode == RESULT_OK) {
//                val data = result.data
//                val resultData = data?.getStringExtra("data")
//                Toast.makeText(this, "我是来自InfoActivity的数据：$resultData", Toast.LENGTH_LONG).show()
//            }
//        }

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            val resultData = data?.getStringExtra("data")
            Log.d("jj:intent", data.toString())

            Toast.makeText(this, "onActivityResult", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
//        Log.d("onNewIntent", intent.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d("生命周期", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("生命周期", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("生命周期", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("生命周期", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("生命周期", "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("生命周期", "onDestroy")
    }

}

