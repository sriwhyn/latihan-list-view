package com.sriwahyuni.latihan6

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var lv_data: ListView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)

        lv_data = findViewById(R.id.lv_data)

//        bikin array list

        val namaHewan = listOf(
            "Ayam",
            "Bebek",
            "Domba",
            "Elang",
            "Gajah",
            "Harimau",
            "Jerapah",
            "Singa",
            "Sapi",
            "Buaya",
            "Kambing",
        )
        lv_data.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namaHewan)

        lv_data.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Anda memilih hewan ${namaHewan[position]}", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}