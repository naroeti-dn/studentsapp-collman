package com.example.studentsapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "New Student"

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val idInput = findViewById<EditText>(R.id.idInput)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val addressInput = findViewById<EditText>(R.id.addressInput)
        val checkedBox = findViewById<CheckBox>(R.id.checkedBox)
        val saveBtn = findViewById<Button>(R.id.saveButton)
        val cancelBtn = findViewById<Button>(R.id.cancelButton)

        saveBtn.setOnClickListener {
            val student = Student(
                id = idInput.text.toString(),
                name = nameInput.text.toString(),
                phone = phoneInput.text.toString(),
                address = addressInput.text.toString(),
                isChecked = checkedBox.isChecked
            )
            StudentRepository.addStudent(student)
            finish()
        }

        cancelBtn.setOnClickListener {
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
