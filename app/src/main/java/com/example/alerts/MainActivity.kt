package com.example.alerts

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alerts.databinding.ActivityMainBinding
import com.example.alerts.databinding.CustomDialogueBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.btnSnackbar.setOnClickListener {

           var snackbarView = Snackbar.make(binding.btnSnackbar,"This is snackbar",Snackbar.LENGTH_LONG)
            snackbarView.show()
            snackbarView.setAnchorView(R.id.btnSnackbar)
            snackbarView.setAction("OK"){
                Toast.makeText(this,"This is toast",Toast.LENGTH_LONG).show()
            }
        }
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert Title")
                .setMessage("This is alert")
                .setCancelable(true)
                .setPositiveButton("Positive"){_,_->
                    Toast.makeText(this,"This is positive button",Toast.LENGTH_LONG)
                        .show()
                }
                .setNegativeButton("Negative"){_,_->
                    Toast.makeText(this,"This is negative button",Toast.LENGTH_LONG)
                        .show()
                }
                .setNeutralButton("Neutral"){_,_->
                    Toast.makeText(this,"This is neutral button",Toast.LENGTH_LONG)
                        .show()
                }
                .show()
        }
        binding.btnCustom.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialogue)
            dialog.show()
            var btnSet = dialog.findViewById<Button>(R.id.btnSet)
            var btnCancel = dialog.findViewById<Button>(R.id.btnCancel)

            var etEnterHere = dialog.findViewById<EditText>(R.id.etEnterHere)
            etEnterHere.setText(binding.tvHello.text)


            btnSet.setOnClickListener {
                if (etEnterHere.text.toString().isNullOrEmpty()){
                    etEnterHere.error = "Enter name"
                }else{
                    binding.tvHello.setText(etEnterHere.text.toString())
                Toast.makeText(this,"Set",Toast.LENGTH_LONG)
                    .show()
                dialog.dismiss()}
            }
            btnCancel.setOnClickListener {
                Toast.makeText(this,"Cancelled",Toast.LENGTH_LONG)
                    .show()
                dialog.dismiss()
            }
        }
    }
}