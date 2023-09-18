package com.example.sudishsir

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button =findViewById<Button>(R.id.button)
        val password =findViewById<EditText>(R.id.password)
        val editText =findViewById<EditText>(R.id.edittext)


        button.setOnClickListener{

            if(editText.length()==0||password.length()==0){
                if(editText.length()==0) {
                    editText.error = "Fill carefully"
                }
                else if(password.length()==0){
                    password.error="Fill carefully"
                }
            }
            else {


                if (password.text.isEmpty() || editText.text.isEmpty()) {
                    if (editText.text.isEmpty()) {
                        Toast.makeText(this, "Enter your Email", Toast.LENGTH_SHORT).show()

                    } else if (password.text.isEmpty()) {
                        Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show()

                    }


                }
                else {

                    val inten = Intent(this, homeActivity::class.java)
                    inten.putExtra("name", "${editText.text}")
                    inten.putExtra("password", "${password.text}")
                    startActivity(inten)
                }
            }

        }
    }

}