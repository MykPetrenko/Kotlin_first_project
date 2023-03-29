package com.example.hello_world

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.math.pow

val G:Double = 6.6743 * 10.0.pow(-11)
val minimum = 0.000001
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val m1 = findViewById<EditText>(R.id.m1)
        val m2 = findViewById<EditText>(R.id.m2)
        val r = findViewById<EditText>(R.id.r)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            val m1_num = m1.text.toString().toDouble()
            val m2_num = m2.text.toString().toDouble()
            val r_num = r.text.toString().toDouble()
            if (m1_num > minimum && m2_num > minimum && r_num > minimum) {
                val result = G * m1_num * m2_num / (r_num * r_num)
                intent.putExtra("result", result.toString())
            }
            else {
                val message = "The entered values are not allowed. Please try again"
                intent.putExtra("result", message)
            }
            startActivity(intent)
        }
    }
}
