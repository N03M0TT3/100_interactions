package fr.imaginnovation.interactions100

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        var interactionNumber = sharedPreferences.getInt("interactions", -1)
        if(interactionNumber == -1) {
            editor.putInt("interactions", 0)
            editor.commit()
        }

        val textNumberInteraction = findViewById<TextView>(R.id.numberInteractionText)
        val buttonNewInteraction = findViewById<Button>(R.id.newInteractionButton)
        val buttonReset = findViewById<Button>(R.id.resetInteractionButton)

        textNumberInteraction.text = "Interactions : $interactionNumber"

        buttonNewInteraction.setOnClickListener {
            var interactionNumber = sharedPreferences.getInt("interactions", -1)
            if(interactionNumber >= 100) {
                interactionNumber = 0
            } else {
                interactionNumber++
            }

            textNumberInteraction.text = "Interactions : $interactionNumber"
            editor.putInt("interactions", interactionNumber)
            editor.commit()
        }

        buttonReset.setOnClickListener {
            editor.putInt("interactions", 0)
            editor.commit()
            textNumberInteraction.text = "Interactions : 0"
        }

    }
}