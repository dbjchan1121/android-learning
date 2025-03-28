package com.example.demoproject.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.demoproject.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        binding = LoginActivityBinding.inflate(layoutInflater)


//        setContentView(R.layout.affirmation_activity)
//
//        val myDataset = Datasource().loadAffirmations()
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//
//        recyclerView.adapter = ItemAdapter(this, myDataset)
//
//        recyclerView.setHasFixedSize(true)

        setContentView(R.layout.layout)



        findViewById<Button>(R.id.btn_go_to_login).setOnClickListener {
            val intent = Intent(this, HtmlActivity::class.java)
            startActivity(intent)
//                for (i in 0 until 3) {
//                    startActivity(intent)
//                }
        }


    }
}


