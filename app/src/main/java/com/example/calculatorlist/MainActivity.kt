package com.example.calculatorlist

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var input = mutableListOf<String>()
        var justSolved = false
        var tempResult = ""

        fun errorMessage(){
            result.run {
                setTextColor(Color.RED)
                postDelayed({result.setText(input.last()); setTextColor(Color.BLACK)},1000)
            }
        }

        fun clear(){
            input.removeAll(input)
            result.setText("")
            tempResult = ""
        }

        fun isOp(item:String):Boolean{
            if (item.isEmpty())
                return false
            else if (item == "+" || item == "-" ||
                item == "*" || item == "/" ||
                item == "√" || item == "²")
                return true
            else
                return false
        }

        fun stillNumber():Boolean{
            if(input.isEmpty())
                return false
            return !isOp(input.last())
        }

        fun trimTrailing(input: String):String{
            if(input.substring(input.length - 5,input.length) == ".0000")
                return input.substring(0 , input.length - 5)
            else if(input.substring(input.length - 3, input.length) == "000")
                return input.substring(0, input.length - 3)
            else if(input.substring(input.length - 2, input.length) == "00")
                return input.substring(0, input.length - 2)
            else if(input.last() == '0')
                return input.substring(0, input.length - 1)
            else
                return input
        }

        button0.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "0")
            else
                input.add("0")
            tempResult += "0"
            justSolved = false
            result.setText(tempResult)
        }
        button1.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "1")
            else
                input.add("1")
            tempResult += "1"
            justSolved = false
            result.setText(tempResult)
        }
        button2.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "2")
            else
                input.add("2")
            tempResult += "2"
            justSolved = false
            result.setText(tempResult)
        }
        button3.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "3")
            else
                input.add("3")
            tempResult += "3"
            justSolved = false
            result.setText(tempResult)
        }
        button4.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "4")
            else
                input.add("4")
            tempResult += "4"
            justSolved = false
            result.setText(tempResult)
        }
        button5.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "5")
            else
                input.add("5")
            tempResult += "5"
            justSolved = false
            result.setText(tempResult)
        }
        button6.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "6")
            else
                input.add("6")
            tempResult += "6"
            justSolved = false
            result.setText(tempResult)
        }
        button7.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "7")
            else
                input.add("7")
            tempResult += "7"
            justSolved = false
            result.setText(tempResult)
        }
        button8.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "8")
            else
                input.add("8")
            tempResult += "8"
            justSolved = false
            result.setText(tempResult)
        }
        button9.setOnClickListener {
            if(justSolved)
                clear()
            if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + "9")
            else
                input.add("9")
            tempResult += "9"
            justSolved = false
            result.setText(tempResult)
        }
        buttonDec.setOnClickListener {
            if(justSolved)
                clear()
            if(input.isEmpty())
                input.add(".")
            else if(input.last().contains('.'))
                errorMessage()
            else if(stillNumber())
                input.set(input.lastIndex, input.get(input.lastIndex) + ".")
            else
                input.add(".")
            tempResult += "."
            justSolved = false
            result.setText(tempResult)
        }
        buttonSqr.setOnClickListener {
            if(input.isEmpty())
                errorMessage()
            else if(!isOp(input.last())){
                input.set(input.lastIndex, trimTrailing("%.4f".format(Math.pow( input.last().toDouble(), 2.0))))
                tempResult += "² "
            }
            else
                errorMessage()

            result.setText(tempResult)
        }
        buttonSqrt.setOnClickListener {
            input.add("√")
            tempResult += "√"
            result.setText(tempResult)
            justSolved = false
        }
        buttonAdd.setOnClickListener {
            if(input.isEmpty()) {
                errorMessage()
                return@setOnClickListener
            }
            else if(!isOp(input.last())) {
                input.add("+")
                tempResult += " + "
            }
            else{
                input.set(input.lastIndex, "+")
                tempResult = tempResult.substring(0,tempResult.lastIndex - 2) + " + "
            }
            result.setText(tempResult)
            justSolved = false
        }
        buttonSubtract.setOnClickListener {
            if(input.isEmpty()) {
                errorMessage()
            }
            else if(!isOp(input.last())) {
                input.add("-")
                tempResult += " - "
            }
            else{
                input.set(input.lastIndex, "-")
                tempResult = tempResult.substring(0,tempResult.lastIndex - 2) + " - "
            }
            result.setText(tempResult)
            justSolved = false
        }
        buttonMultiply.setOnClickListener {
            if(input.isEmpty()) {
                errorMessage()
                return@setOnClickListener
            }
            else if(!isOp(input.last())) {
                input.add("*")
                tempResult += " * "
            }
            else{
                input.set(input.lastIndex, "*")
                tempResult = tempResult.substring(0,tempResult.lastIndex - 2) + " * "
            }
            result.setText(tempResult)
            justSolved = false
        }
        buttonDivide.setOnClickListener {
            if(input.isEmpty()) {
                errorMessage()
                return@setOnClickListener
            }
            else if(!isOp(input.last())) {
                input.add("/")
                tempResult += " / "
            }
            else{
                input.set(input.lastIndex, "/")
                tempResult = tempResult.substring(0,tempResult.lastIndex - 2) + " / "
            }
            result.setText(tempResult)
            justSolved = false
        }
        buttonClear.setOnClickListener {
            clear()
            justSolved = false
        }
        buttonEquals.setOnClickListener {
            if(!isOp(input.first()) && !isOp(input.last())) {
                while (input.size >= 0) {
                    if (input.contains("√")) {
                        var cursor = input.indexOf("√")
                        input.set(cursor, trimTrailing("%.4f".format(Math.pow(input.get(cursor + 1).toDouble(), 0.5))))
                        input.removeAt(cursor + 1)
                    } else if (input.contains("*") || input.contains("/")) {
                        if (input.contains("*") && input.contains("/")) {
                            if (input.indexOf("*") < input.indexOf("/")) {
                                var cursor = input.indexOf("*")
                                input.set(
                                    cursor,
                                    trimTrailing("%.4f".format(input.get(cursor - 1).toFloat() * input.get(cursor + 1).toFloat()))
                                )
                                input.removeAt(cursor - 1)
                                input.removeAt(cursor)
                            } else {
                                var cursor = input.indexOf("/")
                                input.set(
                                    cursor,
                                    trimTrailing("%.4f".format(input.get(cursor - 1).toFloat() / input.get(cursor + 1).toFloat()))
                                )
                                input.removeAt(cursor - 1)
                                input.removeAt(cursor)
                            }
                        } else if (input.contains("*") && !input.contains("/")) {
                            var cursor = input.indexOf("*")
                            input.set(
                                cursor,
                                trimTrailing("%.4f".format(input.get(cursor - 1).toFloat() * input.get(cursor + 1).toFloat()))
                            )
                            input.removeAt(cursor - 1)
                            input.removeAt(cursor)
                        } else if (!input.contains("*") && input.contains("/")) {
                            var cursor = input.indexOf("/")
                            input.set(
                                cursor,
                                trimTrailing("%.4f".format(input.get(cursor - 1).toFloat() / input.get(cursor + 1).toFloat()))
                            )
                            input.removeAt(cursor - 1)
                            input.removeAt(cursor)
                        }
                    } else if (input.contains("+") || input.contains("-")) {
                        if (input.contains("+") && input.contains("-")) {
                            if (input.indexOf("*") < input.indexOf("/")) {
                                var cursor = input.indexOf("+")
                                input.set(
                                    cursor,
                                    trimTrailing("%.4f".format(input.get(cursor - 1).toFloat() + input.get(cursor + 1).toFloat()))
                                )
                                input.removeAt(cursor - 1)
                                input.removeAt(cursor)
                            } else {
                                var cursor = input.indexOf("-")
                                input.set(
                                    cursor,
                                    trimTrailing("%.4f".format(input.get(cursor - 1).toFloat() - input.get(cursor + 1).toFloat()))
                                )
                                input.removeAt(cursor - 1)
                                input.removeAt(cursor)
                            }
                        } else if (input.contains("+") && !input.contains("-")) {
                            var cursor = input.indexOf("+")
                            input.set(
                                cursor,
                                trimTrailing("%.4f".format(input.get(cursor - 1).toFloat() + input.get(cursor + 1).toFloat()))
                            )
                            input.removeAt(cursor - 1)
                            input.removeAt(cursor)
                        } else if (!input.contains("+") && input.contains("-")) {
                            var cursor = input.indexOf("-")
                            input.set(
                                cursor,
                                trimTrailing("%.4f".format(input.get(cursor - 1).toFloat() - input.get(cursor + 1).toFloat()))
                            )
                            input.removeAt(cursor - 1)
                            input.removeAt(cursor)
                        }
                    } else {
                        result.setText("YOU SCREWED UP CHUMP")
                        break
                    }
                }
            }
            tempResult = input.last()
            result.setText(tempResult)
            justSolved = true
        }

    }
}

