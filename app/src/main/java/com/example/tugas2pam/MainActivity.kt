package com.example.tugas2pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val kolomPertama = findViewById<EditText>(R.id.et_kolom1)
        val kolomKedua = findViewById<EditText>(R.id.et_kolom2)
        val operasiKalkulasi = findViewById<RadioGroup>(R.id.rg_operasi)
        val buttonHitung = findViewById<Button>(R.id.btn_hitung)

        buttonHitung.setOnClickListener {
            val num1 = kolomPertama.text.toString().toDoubleOrNull()
            val num2 = kolomKedua.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                var res = 0.0
                when(operasiKalkulasi.checkedRadioButtonId) {
                    R.id.rb_penjumlahan -> res = num1 + num2
                    R.id.rb_pengurangan -> res = num1 - num2
                    R.id.rb_perkalian -> res = num1 * num2
                    R.id.rb_pembagian -> res = if (num2 != 0.0) num1 / num2 else Double.NaN
                }

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_RESULT", res)
                    putExtra("EXTRA_NAMA", "Johanes Paulus Bernard Purek")
                    putExtra("EXTRA_NIM", "225150407111090")
                }
                startActivity(intent)
            }
        }
    }
}