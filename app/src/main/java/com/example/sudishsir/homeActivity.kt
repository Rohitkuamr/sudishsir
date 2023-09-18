package com.example.sudishsir

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class homeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val inten=intent.extras?.getString("name")
        val intens=intent.extras?.getString("password")
        var editText =findViewById<TextView>(R.id.edittext)
        var editText2 =findViewById<TextView>(R.id.edittext2)
        var butto =findViewById<Button>(R.id.button)
        var button1 =findViewById<Button>(R.id.button1)

        editText.text=inten
        editText2.text=intens

        butto.setOnClickListener{
            showdilaogs()
        }
        button1.setOnClickListener{
            edit()
        }

    }
    fun showdilaogs(){
        val alert=AlertDialog.Builder(this)
        alert.setPositiveButton("Yes" ,DialogInterface.OnClickListener{
                dialogInterface, i ->
            onBackPressed()

        })
        alert.setNegativeButton("No" ,DialogInterface.OnClickListener{
            dialogInterface, i ->


        })

        var dialog=alert.create()

        dialog.setTitle("gretting")
        dialog.setMessage("are you sure logout")
        dialog.show()


    }
    @SuppressLint("MissingInflatedId")
    fun edit(){
        val alert=AlertDialog.Builder(this)
        alert.setCancelable(false)

        val inflater=layoutInflater.inflate(R.layout.custom,null)
        val editText1=inflater.findViewById<EditText>(R.id.button1)
        val editText2=inflater.findViewById<EditText>(R.id.button2)
        val closedtext=inflater.findViewById<TextView>(R.id.closedtext)
        closedtext.setOnClickListener{
            Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show()

            onBackPressed()
        }
        val updatebutton=inflater.findViewById<Button>(R.id.updatebutton)
        updatebutton.setOnClickListener{
            Toast.makeText(this, "update successful", Toast.LENGTH_SHORT).show()
//            val inten=Intent(this ,homeActivity::class.java)
//            startActivity(inten)



        }
        val intents=intent.extras?.getString("name")
        val intented=intent.extras?.getString("password")
        editText1.setText(intents)
        editText2.setText(intented)

        var dialog=alert.create()
//        dialog.setTitle("gretting")
        dialog.setView(inflater)
//        dialog.setMessage("are you sure logout")
        dialog.show()

    }

}