package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var decButton: Button

    private var operand = 0.0
    private var secOperand = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.textView20)
        decButton = findViewById(R.id.button7)

        findViewById<TextView>(R.id.button).setOnClickListener{
            operand = 0.0
            operation = ""
            resultTextView.text = "0"
            decButton.setEnabled(true)
        }
    }

    fun doubleOrInt(sum: Double){
        if(sum % 1 == 0.0){
            resultTextView.text = sum.toInt().toString()
        } else {
            resultTextView.text = sum.toString()
        }
    }

    fun numberClick(view: View){
        if (view is TextView){

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0"){
                result = ""
            }

            resultTextView.text = result + number
        }
    }

    fun decClick(view: View){
        if (view is TextView){
            var result: String = resultTextView.text.toString()

            if (result.isEmpty()){
                decButton.setEnabled(false)
            }

            resultTextView.text = result + "."
            decButton.setEnabled(false)
        }
    }

    fun operationClick(view: View){

        if(view is TextView){

            if(!TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""
            operation = view.text.toString()
            decButton.setEnabled(true)
        }
    }

    fun equalsClick(view: View) {

        if(!TextUtils.isEmpty(resultTextView.text)){
            secOperand = resultTextView.text.toString().toDouble()
        }

        if(operation == "÷"){
            var sum = operand / secOperand
            doubleOrInt(sum)
        }
        if(operation == "+") {
            var sum = operand + secOperand
            doubleOrInt(sum)
        }
        if(operation == "-") {
            var sum = operand - secOperand
            doubleOrInt(sum)
        }
        if(operation == "×") {
            if(secOperand != 0.0){
                var sum = operand * secOperand
                doubleOrInt(sum)
            } else {
                resultTextView.text = "Error"
            }
        }
    }



}