package io.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate : TextView? =null
    private var tvAgeInMinutes : TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
//       tvSelectedDate = findViewById(R.id.SelectedDate)
tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)



        btnDatePicker.setOnClickListener{
//            Toast.makeText(this, "btnDatePicker pressed", Toast.LENGTH_LONG).show()
       clickDatePicker()
        }
    }
     private fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month  = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
       val dpd =  DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{view, selectedyear, selectedmonth, selectedDayOfMonth->

//            val selectedDayOfMonth
            Toast.makeText(this,
                "Year was $selectedyear, month was ${selectedmonth+1}, day of month was $selectedDayOfMonth",
                 Toast.LENGTH_LONG).show()

       val selectedDate = "$selectedDayOfMonth/${selectedmonth+1}/$selectedyear"
            tvSelectedDate?.text = selectedDate
            val sdf  = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            val selectedDateInMinutes = theDate.getTime()/60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMinutes = currentDate.time/60000

            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

tvAgeInMinutes?.text = differenceInMinutes.toString()

                                          },
        year,
        month,
        day,
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()


    }

       // DatePickerDialog()

       // Toast.makeText(this, "btnDatePicker pressed", Toast.LENGTH_LONG).show()

    }


