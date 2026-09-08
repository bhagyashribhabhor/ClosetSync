package com.example.closetsync

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.util.Calendar

class MaintenanceActivity : AppCompatActivity() {

    private lateinit var etClothingName: EditText
    private lateinit var tvSelectedDate: TextView
    private lateinit var tvSelectedTime: TextView

    private var selectedYear = 0
    private var selectedMonth = 0
    private var selectedDay = 0
    private var selectedHour = 0
    private var selectedMinute = 0

    private var dateSelected = false
    private var timeSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maintenance)

        etClothingName = findViewById(R.id.etClothingName)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvSelectedTime = findViewById(R.id.tvSelectedTime)

        val btnSelectDate =
            findViewById<Button>(R.id.btnSelectDate)

        val btnSelectTime =
            findViewById<Button>(R.id.btnSelectTime)

        val btnSetReminder =
            findViewById<MaterialButton>(R.id.btnSetReminder)

        // DATE
        btnSelectDate.setOnClickListener {

            val calendar = Calendar.getInstance()

            DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->

                    selectedYear = year
                    selectedMonth = month
                    selectedDay = dayOfMonth

                    dateSelected = true

                    tvSelectedDate.text =
                        "$dayOfMonth/${month + 1}/$year"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // TIME
        btnSelectTime.setOnClickListener {

            val calendar = Calendar.getInstance()

            TimePickerDialog(
                this,
                { _, hourOfDay, minute ->

                    selectedHour = hourOfDay
                    selectedMinute = minute

                    timeSelected = true

                    tvSelectedTime.text =
                        String.format(
                            "%02d:%02d",
                            hourOfDay,
                            minute
                        )
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            ).show()
        }

        // SET REMINDER
        btnSetReminder.setOnClickListener {

            val clothingName =
                etClothingName.text.toString().trim()

            if (clothingName.isEmpty()) {
                Toast.makeText(
                    this,
                    "Enter clothing name",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (!dateSelected) {
                Toast.makeText(
                    this,
                    "Please select a date",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (!timeSelected) {
                Toast.makeText(
                    this,
                    "Please select a time",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val calendar = Calendar.getInstance()

            calendar.set(
                selectedYear,
                selectedMonth,
                selectedDay,
                selectedHour,
                selectedMinute,
                0
            )

            // Check whether selected time is in the past
            if (calendar.timeInMillis <= System.currentTimeMillis()) {

                Toast.makeText(
                    this,
                    "Please select a future date and time",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val reminderIntent =
                Intent(this, ReminderReceiver::class.java)

            reminderIntent.putExtra(
                "clothingName",
                clothingName
            )

            val pendingIntent =
                PendingIntent.getBroadcast(
                    this,
                    System.currentTimeMillis().toInt(),
                    reminderIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT or
                            PendingIntent.FLAG_IMMUTABLE
                )

            val alarmManager =
                getSystemService(ALARM_SERVICE)
                        as AlarmManager

            // Check exact alarm permission
            if (!alarmManager.canScheduleExactAlarms()) {

                Toast.makeText(
                    this,
                    "Please allow exact alarms in Settings",
                    Toast.LENGTH_LONG
                ).show()

                return@setOnClickListener
            }

            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )

            Toast.makeText(
                this,
                "Reminder set successfully! 🔔",
                Toast.LENGTH_SHORT
            ).show()

            val homeIntent =
                Intent(this, HomeActivity::class.java)

            homeIntent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(homeIntent)

            finish()
        }
    }
}