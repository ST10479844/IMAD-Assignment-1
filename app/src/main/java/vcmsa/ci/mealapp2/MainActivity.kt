package vcmsa.ci.mealapp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeOfTheDayInput: EditText = findViewById(R.id.timeoftheday)
        val saveButton: Button = findViewById(R.id.SavetimeofthedayButton)
        val suggestMealsButton: Button = findViewById(R.id.suggestmealsbutton)
        val resetButton: Button = findViewById(R.id.ResetButton)
        val resultText: TextView = findViewById(R.id.resulttext)

        saveButton.setOnClickListener {
            val timeOfTheDay = timeOfTheDayInput.text.toString().toIntOrNull()

            if (timeOfTheDay == null) {
                resultText.text = "Please enter a valid time!"
                return@setOnClickListener
            }

            val mealSuggestion = when (timeOfTheDay) {
                7 -> "Meal suggestion is eggs on toast!"
                9 -> "Meal suggestion is yoghurt with mixed fruit!"
                12 -> "Meal suggestion is a chicken and mayonnaise sandwich!"
                15 -> "Meal suggestion is a buttered croissant!"
                18 -> "Meal suggestion is steak and mashed potatoes!"
                else -> "Meal suggestion is a slice of cake!"
            }

            resultText.text = "Time: $timeOfTheDay:00\n$mealSuggestion"
        }

        suggestMealsButton.setOnClickListener {
            val mealOptions = listOf(
                "Eggs on toast",
                "Yoghurt with fruit",
                "Chicken and mayonnaise sandwich",
                "Buttered croissant",
                "Steak and mashed potatoes",
                "A slice of cake"
            )
            resultText.text = mealOptions.random()
        }

        resetButton.setOnClickListener {
            timeOfTheDayInput.text.clear()
            resultText.text = "Meal suggestion will be shown here."
        }
    }
}