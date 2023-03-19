package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find the button in the layout
        val rollButton: Button = findViewById<Button>(R.id.button)

        //Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {
            rollDice(findViewById<TextView>(R.id.diceResult1))
            rollDice(findViewById<TextView>(R.id.diceResult2))
        }
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice(resultTextView: TextView) {
        //Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Update the screen with the dice roll
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