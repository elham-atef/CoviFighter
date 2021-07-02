package com.example.covifighter

import com.example.covifighter.Constants.OPEN_GOOGLE
import com.example.covifighter.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }


            //Hello
            message.contains("hello") -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }
            message.contains("mid-chest?") -> {
                "Intermittent chest burning with palpitations just before sleep is likely due to gastric reflux or anxiety (especially thinking about stressful events or having insomnia). You should avoid oily, spicy, and heavy meals, especially at dinner. So dinner should be light and have some time before the expected sleep time. You should have a walk for 15 to 20 minutes after dinner. You may try having antacids prokinetic combination before breakfast or other antacids."
                    }

            message.contains("vaccination?")-> {
                "I am glad you got your shot. Do not worry. It is a normal immune response to feel slight tiredness and have a slight fever and body ache.\n" +
                        "\n" +
                        "1) Please go ahead and take tablet Tylenol 500 mg (Acetaminophen) every six hours as needed for your body ache and fever.\n" +
                        "\n" +
                        "2) Drink plenty of fluids and take it easy for the next couple of days.\n" +
                        "\n" +
                        "3) Eat plenty of vegetables and fruits.\n" +
                        "\n" +
                        "4) If you are just on oral diabetic medication, take it as prescribed.\n" +
                        "\n" +
                        "5) If you are on Insulin, monitor your blood sugar more frequently than recommended or before giving yourself the injection.\n" +
                        "\n" +
                        "6) If you start having any other symptoms like high fever not coming down with medicine, severe headache, difficulty breathing, or chest pain, please call for an emergency.\n" +
                        "\n" +
                        "7) Take care, and I hope you feel better soon. Please let me know if you have any further questions."
            }
            message.contains("What is the reason for increased sugar levels in the morning?\n" +
                    "\n")or message.contains("My sugar level in the morning increases to 160 mg/dL and reduces gradually. Am I diabetic?\n")-> {
                        "A fasting blood sugar level of 160 mg/dL is very high, suggesting you have diabetes. So please do an HbA1c test (glycated hemoglobin), giving you the three-month average of your blood sugar levels, and we can decide on your treatment."
            }
            message.contains("toothache")-> {
                "Do dental x-rays, and go to the dentist for an examination. For now, take some painkillers to relieve the pain."
            }
            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}