package fr.imaginnovation.interactions100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textNumberInteraction = findViewById<TextView>(R.id.numberInteractionText)
        val buttonNewInteraction = findViewById<Button>(R.id.newInteractionButton)
        val buttonReset = findViewById<Button>(R.id.resetInteractionButton)
        var interactionNumber = 0

        buttonNewInteraction.setOnClickListener {
            if(interactionNumber >= 100) {
                interactionNumber = 0
            } else {
                interactionNumber++
            }

            textNumberInteraction.text = "Interactions : $interactionNumber"
        }

        buttonReset.setOnClickListener {
            interactionNumber = 0
            textNumberInteraction.text = "Interactions : $interactionNumber"
        }

    }
}