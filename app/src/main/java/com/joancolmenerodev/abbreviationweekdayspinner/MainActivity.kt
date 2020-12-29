package com.joancolmenerodev.abbreviationweekdayspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner

private const val FIRST_POSITION = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weekDays = resources.getStringArray(R.array.Weekdays)
        val abbreviationWeekDays = resources.getStringArray(R.array.WeekdaysAbbreviations)
        //find the spinner
        val spinner = findViewById<AppCompatSpinner>(R.id.spinner)
        //create an adapter with the weekdays
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, weekDays)
        //set the adapter
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
            ) {
                //find the first TextView of the Adapter
                val selectedText = parent.getChildAt(FIRST_POSITION) as TextView
                //As the abbreviationWeekDays and WeekDays have the same size, you can get the position selected on weebDays and then print what you have on abbreviationdays
                //Another option would be selectedText.text = weekDays[position].substring(0,4)
                selectedText.text = abbreviationWeekDays[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                //Nothing selected \o/
            }
        }
    }
}