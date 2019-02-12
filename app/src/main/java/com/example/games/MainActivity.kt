package com.example.games

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random
import android.text.Layout



class MainActivity : AppCompatActivity() {

    var player = 1
    var p1 = ArrayList<Int>()
    var p2 = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gameOn(buttonCode:Int, selectedButton:Button){
        if(player == 1) {
            selectedButton.text = "X"
            selectedButton.setBackgroundResource(R.color.blue)
            p1.add(buttonCode)
            player = 2
        } else if (player == 2) {
            selectedButton.text = "O"
            selectedButton.setBackgroundResource(R.color.green)
            p2.add(buttonCode)
            player = 1
        }
        selectedButton.isEnabled = false
    }

    fun andTheWinnerIs(){
        var win = 0
        if(p1.contains(1) && p1.contains(2) && p1.contains(3))win=1
        if(p1.contains(4) && p1.contains(5) && p1.contains(6))win=1
        if(p1.contains(7) && p1.contains(8) && p1.contains(9))win=1
        if(p1.contains(1) && p1.contains(4) && p1.contains(7))win=1
        if(p1.contains(2) && p1.contains(5) && p1.contains(8))win=1
        if(p1.contains(3) && p1.contains(6) && p1.contains(9))win=1
        if(p1.contains(1) && p1.contains(5) && p1.contains(9))win=1
        if(p1.contains(3) && p1.contains(5) && p1.contains(7))win=1

        if(p2.contains(1) && p2.contains(2) && p2.contains(3))win=2
        if(p2.contains(4) && p2.contains(5) && p2.contains(6))win=2
        if(p2.contains(7) && p2.contains(8) && p2.contains(9))win=2
        if(p2.contains(1) && p2.contains(4) && p2.contains(7))win=2
        if(p2.contains(2) && p2.contains(5) && p2.contains(8))win=2
        if(p2.contains(3) && p2.contains(6) && p2.contains(9))win=2
        if(p2.contains(1) && p2.contains(5) && p2.contains(9))win=2
        if(p2.contains(3) && p2.contains(5) && p2.contains(7))win=2

        if(win != 0){
            Toast.makeText(this, "Winner is player $win", Toast.LENGTH_LONG).show()
        }
    }

    fun select(view: View) {
        val selectedButton = view as Button
        var buttonCode = 0
        when( selectedButton.id) {
            R.id.button -> buttonCode = 1
            R.id.button2 -> buttonCode = 2
            R.id.button3 -> buttonCode = 3
            R.id.button4 -> buttonCode = 4
            R.id.button5 -> buttonCode = 5
            R.id.button6 -> buttonCode = 6
            R.id.button7 -> buttonCode = 7
            R.id.button8 -> buttonCode = 8
            R.id.button9 -> buttonCode = 9
        }

        gameOn(buttonCode, selectedButton)
        andTheWinnerIs()
    }

   fun  restart(view: View){
       player = 1
       p1.clear()
       p2.clear()
       for(i in 1..9){
          
       }
    }

    fun autoPlay(view: View){
        var randButton:Button = findViewById(R.id.button)
        var random = 0
        do{
            random = Random.nextInt(1,10)
            when( random) {
                1 -> randButton = findViewById(R.id.button)
                2 -> randButton = findViewById(R.id.button2)
                3 -> randButton = findViewById(R.id.button3)
                4 -> randButton = findViewById(R.id.button4)
                5 -> randButton = findViewById(R.id.button5)
                6 -> randButton = findViewById(R.id.button6)
                7 -> randButton = findViewById(R.id.button7)
                8 -> randButton = findViewById(R.id.button8)
                9 -> randButton = findViewById(R.id.button9)
            }
        } while(!randButton.isEnabled)
        gameOn(random, randButton)
        andTheWinnerIs()
    }


}
