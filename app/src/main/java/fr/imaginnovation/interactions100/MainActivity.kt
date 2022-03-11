package fr.imaginnovation.interactions100

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        var interactionNumber = sharedPreferences.getInt("interactions", -1)
        var startingDate = sharedPreferences.getString("date", "01/01/2022")
        if(interactionNumber == -1) {
            editor.putInt("interactions", 0)
            editor.commit()
        }

        val textNumberInteraction = findViewById<TextView>(R.id.numberInteractionText)
        val textStartingDate = findViewById<TextView>(R.id.startDateText)
        val buttonNewInteraction = findViewById<Button>(R.id.newInteractionButton)
        val buttonReset = findViewById<Button>(R.id.resetInteractionButton)

        textNumberInteraction.text = "Interactions : $interactionNumber"
        textStartingDate.text = textStartingDate.text.toString() + startingDate

        buttonNewInteraction.setOnClickListener {
            var interactionNumber = sharedPreferences.getInt("interactions", -1)
            var startingDate = sharedPreferences.getString("date", "01/01/2022")
            if(interactionNumber >= 100) {
                interactionNumber = 0
            } else {
                interactionNumber++
                if(startingDate == "01/01/2022") {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        startingDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
                    }
                }
            }

            textNumberInteraction.text = "Interactions : $interactionNumber"
            textStartingDate.text = "Challenge started on the : $startingDate"
            editor.putInt("interactions", interactionNumber)
            editor.putString("date", startingDate)
            editor.commit()
        }

        buttonReset.setOnClickListener {
            editor.putInt("interactions", 0)
            editor.putString("date", "01/01/2022")
            editor.commit()
            textNumberInteraction.text = "Interactions : 0"
        }

    }
}