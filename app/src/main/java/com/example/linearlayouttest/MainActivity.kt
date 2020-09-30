package com.example.linearlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tvResult
import kotlinx.android.synthetic.main.testlayout.*
import java.lang.StringBuilder



class MainActivity : AppCompatActivity(), View.OnClickListener {

    var digit_to_String = StringBuilder()
    var left_part:Double = 0.0
    var right_part:Double =0.0
    var operation: Char = ' '


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.testlayout)

         tvResult.text ="0"

        implementsmethods()


    }

    private fun implementsmethods() {

        functionalButton()
        operationButton()
        numericalButton()

    }

    private fun operationButton() {

        btnAddition.setOnClickListener {

            if(left_part == 0.0){
                tvResult.text = "0"
            }
            selectOperation('A')
        }

        btnSubtract.setOnClickListener {
            if(left_part == 0.0){
                tvResult.text = "0"
            }
            selectOperation('B')
        }

        btnMultiplication.setOnClickListener {
            if(left_part == 0.0){
                tvResult.text = "0"
            }
            selectOperation('C')
        }

        btndivide.setOnClickListener {
            if(left_part == 0.0){
                tvResult.text = "0"
            }
            selectOperation('D')
        }
        btnPerecnt.setOnClickListener {
            if(left_part == 0.0){
                tvResult.text = "0"
            }
            selectOperation('E')
        }
    }

    private fun selectOperation(operator: Char) {

        operation =operator
        left_part = digit_to_String.toString().toDouble()
        digit_to_String.clear()
        tvResult.text="0"
    }



    private fun numericalButton() {
        btn1.setOnClickListener {
            appenddigittostring("1")
        }

        btn2.setOnClickListener {
            appenddigittostring("2")
        }

        btn3.setOnClickListener {
            appenddigittostring("3")
        }

        btn4.setOnClickListener {
            appenddigittostring("4")
        }

        btn5.setOnClickListener {
            appenddigittostring("5")
        }

        btn6.setOnClickListener {
            appenddigittostring("6")
        }

        btn7.setOnClickListener {
            appenddigittostring("7")
        }

        btn8.setOnClickListener {
            appenddigittostring("8")
        }

        btn9.setOnClickListener {
            appenddigittostring("9")
        }
        btn0.setOnClickListener {
            appenddigittostring("0")
        }
    }

    private fun appenddigittostring(digit: String) {
       digit_to_String.append(digit)

        tvResult.text = digit_to_String.toString()
    }

    private fun functionalButton() {
        btnclearAll.setOnClickListener {
            digit_to_String.clear()
            tvResult.text="0"
        }
        btnbs.setOnClickListener {
           if( digit_to_String.length<=0){
               return@setOnClickListener
           }else{
               clearDigit();
           }
        }
        btnclear.setOnClickListener {

            if( digit_to_String.length<=0){
                return@setOnClickListener
            }else{
                clearDigit();
            }
        }
        btnequals.setOnClickListener {
            performoperation()
        }

    }

    private fun clearDigit() {
        var length = digit_to_String.length

        digit_to_String.deleteCharAt(length-1)
        tvResult.text = digit_to_String.toString()
    }


    private fun performoperation() {

        right_part = digit_to_String.toString().toDouble()
        digit_to_String.clear()
        when(operation){
            'A' -> {
                var sum = left_part + right_part
                tvResult.text = sum.toString()
                digit_to_String.append(sum)
            }
            'B' -> {
                var subtract = left_part - right_part
                tvResult.text = subtract.toString()
                digit_to_String.append(subtract)
            }
            'C' -> {
                var multiply = left_part*right_part
                tvResult.text = multiply.toString()
                digit_to_String.append(multiply)
            }
            'D' -> {
                var divide = left_part/right_part
                tvResult.text = divide.toString()
                digit_to_String.append(divide)
            }

            'E' -> {
                var percent = left_part/100
                tvResult.text = percent.toString()
                digit_to_String.append(percent)
            }
        }
    }

    override fun onClick(p0: View?) {

    }


}