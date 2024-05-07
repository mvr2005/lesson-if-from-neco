package com.mikhail.lessoniffromneco

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mikhail.lessoniffromneco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bidingClass: ActivityMainBinding
    val maxPerson = 90
    var currentPerson = 87


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        bidingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bidingClass.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // ------------УСЛОВИЕ ЧЕРЕЗ ----IF------


        bidingClass.bt1.setOnClickListener {
            if (currentPerson < maxPerson) {
                bidingClass.tx1.setText(R.string.tx11)
                bidingClass.tx1.setBackgroundColor(Color.BLUE)
                bidingClass.tx1.setTextColor(Color.RED)
            } else {
                bidingClass.tx1.text = "проход запрещен"
                bidingClass.tx1.setBackgroundColor(Color.RED)
                bidingClass.tx1.setTextColor(Color.WHITE)
            }
        }

        bidingClass.bt2.setOnClickListener {
            bidingClass.tx2.text = if (currentPerson < maxPerson)       //упрощенный вариант если
                "проход разрешен"                                   //только если в одну линию
            else
                "проход запрещен"                                   // блок else  обязателен
        }


            // ------------УСЛОВИЕ ЧЕРЕЗ ----WHEN------



        bidingClass.bt3.setOnClickListener {
            when (currentPerson) {
                88, 87, 89 -> {bidingClass.tx3.text = "заходи"
                    bidingClass.tx3.setTextColor(Color.RED)
                }
                maxPerson -> bidingClass.tx3.text = "стоп"
                in 0..86 -> bidingClass.tx3.text = "добро пожаловать"

            }
        }

        bidingClass.bt4.setOnClickListener {
        bidingClass.tx4.text = when (currentPerson) {           //упрощенный вариант если
            88, 87, 89 -> "заходи"
            maxPerson -> "стоп"                                     //только если в одну линию
            else -> "добро пожаловать"                           // блок else  обязателен
        }
    }

    }
}
