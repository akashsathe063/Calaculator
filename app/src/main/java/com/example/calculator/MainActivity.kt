package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        var edit:EditText = this.findViewById(R.id.editText)
        var one:Button= this.findViewById(R.id.bu1)
        var two:Button = this.findViewById(R.id.bu2)
        var three:Button = this.findViewById(R.id.bu3)
        var four:Button = this.findViewById(R.id.bu4)
        var five:Button = this.findViewById(R.id.bu5)
        var six:Button = this.findViewById(R.id.bu6)
        var seven:Button = this.findViewById(R.id.bu7)
        var eight:Button = this.findViewById(R.id.bu8)
        var nine:Button = this.findViewById(R.id.bu9)
        var zero:Button = this.findViewById(R.id.bu0)
        var dot:Button = this.findViewById(R.id.buDot)
        var minusPlus:Button = findViewById(R.id.buPlusMinus)
        if(isNewOp)
            edit.setText("")
        isNewOp = false
        var buClick:String = edit.text.toString()
        var buSelect:Button = view as Button
        when(buSelect.id){
            one.id  -> {buClick += "1"}
            two.id  -> {buClick += "2"}
            three.id  -> {buClick += "3"}
            four.id  -> {buClick += "4"}
            five.id  -> {buClick += "5"}
            six.id  -> {buClick += "6"}
            seven.id  -> {buClick += "7"}
            eight.id  -> {buClick += "8"}
            nine.id  -> {buClick += "9"}
            zero.id  -> {buClick += "0"}
            dot.id  -> {buClick += "." }
            minusPlus.id ->{buClick = "-${buClick}"}
        }
        edit.setText(buClick)

    }

    fun operatorEvent(view: View) {
        var edit:EditText = this.findViewById(R.id.editText)
        var multiply:Button = findViewById(R.id.buMul)
        var division:Button = findViewById(R.id.buDivide)
        var plus:Button = findViewById(R.id.buPlus)
        var minus:Button = findViewById(R.id.buMinus)
        var module:Button = findViewById(R.id.buMod)
        isNewOp = true
        oldNumber = edit.text.toString()
        var buSelect:Button = view as Button
        when(buSelect.id){
            multiply.id -> {op = "*"}
            division.id -> {op = "/"}
            plus.id -> {op = "+"}
            minus.id -> {op = "-"}
            module.id -> {op = "%"}

        }

    }

    fun equalEvent(view: View) {
        var edit:EditText = findViewById(R.id.editText)
        var newNumber:String = edit.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}

        }
        edit.setText(result.toString())
    }

    fun acEvent(view: View) {
        var edit:EditText = findViewById(R.id.editText)
        edit.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {
        var edit:EditText = findViewById(R.id.editText)
        var number: Double = edit.text.toString().toDouble() / 100
        edit.setText(number.toString())
        isNewOp = true
    }
}