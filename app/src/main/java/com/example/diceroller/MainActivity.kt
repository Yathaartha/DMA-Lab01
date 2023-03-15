package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById<Button>(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        //Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Update the screen with the dice roll
        val resultTextView: TextView = findViewById<TextView>(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

/**
 * This class is used to mimic a dice roll
 */
class Dice(private val numSides: Int) {

    /**
     * returns the result of the dice roll
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}