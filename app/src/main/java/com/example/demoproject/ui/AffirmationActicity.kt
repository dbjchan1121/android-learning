package com.example.demoproject.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.R
import com.example.demoproject.adapter.ItemAdapter
import com.example.demoproject.bean.Status
import com.example.demoproject.bean.UserBean
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class AffirmationActicity : ComponentActivity() {
    private val client = OkHttpClient()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private var userList: List<UserBean> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.affirmation_activity)

        recyclerView = findViewById(R.id.recycler_view)
        adapter = ItemAdapter(this, userList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)


        fetchDataFromServer()

    }

    private fun fetchDataFromServer() {
        // 使用协程来避免阻塞主线程
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // 创建请求
                val request = Request.Builder()
                    .url("http://192.168.1.33:8080/api/getUserList")
                    .build()

                // 执行请求
                val response = client.newCall(request).execute()

                // 处理响应
                if (response.isSuccessful) {
                    // 如果请求成功，处理响应
                    val responseData = response.body?.string()

                    val userListResponse = parseJsonToUserList(responseData)

                    Log.d("http:req", userListResponse.toString())

                    withContext(Dispatchers.Main) {
                        userList = userListResponse
                        adapter = ItemAdapter(this@AffirmationActicity, userList)
                        recyclerView.adapter = adapter
//                        Log.d("http:req", responseData.toString())
//
//                        // 切换回主线程更新 UI
//                        Toast.makeText(this@MainActivity, "数据获取成功: $responseData", Toast.LENGTH_LONG).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {

                        // 如果请求失败，提示错误
                        Toast.makeText(this@AffirmationActicity, "请求失败", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("http:req", e.message.toString())
                    // 如果发生异常，提示错误
                    Toast.makeText(
                        this@AffirmationActicity,
                        "请求异常: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun parseJsonToUserList(json: String?): List<UserBean> {
        val userList = mutableListOf<UserBean>()
        val jsonObject = JSONObject(json)
        val dataArray = jsonObject.getJSONArray("data")

        for (i in 0 until dataArray.length()) {
            val userObject = dataArray.getJSONObject(i)
            val statusValue = userObject.getInt("status")
            val status = Status.fromValue(statusValue)

            val user = UserBean(
                avatar = userObject.getString("avatar"),
                name = userObject.getString("name"),
                id = userObject.getInt("id"),
                status = status
            )

            userList.add(user)
        }

        return userList
    }
}