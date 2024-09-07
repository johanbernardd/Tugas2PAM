package com.example.tugas2pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val res = intent.getDoubleExtra("EXTRA_RESULT", 0.0)
        val nama = intent.getStringExtra("EXTRA_NAMA")
        val nim = intent.getStringExtra("EXTRA_NIM")

        val results = findViewById<TextView>(R.id.tv_hasil)
        val namaa = findViewById<TextView>(R.id.tv_nama)
        val nimm = findViewById<TextView>(R.id.tv_nim)

        results.text = "Hasil: $res"
        namaa.text = "Nama: $nama"
        nimm.text = "NIM: $nim"
    }
}