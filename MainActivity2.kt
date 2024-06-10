package com.example.ishaanparthabweatherapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




        private lateinit var editTextsMin: Array<EditText>
        private lateinit var editTextsMax: Array<EditText>
        private lateinit var editTextsCondition: Array<EditText>
        private var minTemps: Array<Int?> = arrayOfNulls( 7)
        private var conditions: Array<String?> = arrayOfNulls(7)

        editTextsMin = arrayOf(
        )
        editTextsMax = arrayOf(

        )

        editTextsConditions = arrayOf(

        )

        findViewByid<Button>(R.id.saveBtn).setOnClickListener {
            if (saveData())
                Toast.makeText( this, "Data saved", Toast.Lengty_Short).show()
         }

     }
    findViewByid<Button>(R.id.clearBtn).setOnClickListener {
        clearData()
    }

    findViewById<Button>(R.id.viewWeatherBtn).setOnClickListener {
        if (saveData() && isDataComplete()) {
            val intent = Intent( this, WeatherDetails::class.java)
            intent .putExtra( "minTemps", minTemps)
            intent.putExtra( "maxTemps", maxTemps)
            intent.putExtra( "conditions", conditions)
            startActivity(intent)
        } else {
            Toast.makeText( this, "Please fill all fields correctly.", Toast.LENGTH_SHORT).show()
        }
    }
}