package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditStudentActivity : AppCompatActivity() {

    private var studentId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Edit Student"

        studentId = intent.getStringExtra("studentId") ?: ""

        val nameInput = findViewById<EditText>(R.id.editNameInput)
        val idInput = findViewById<EditText>(R.id.editIdInput)
        val phoneInput = findViewById<EditText>(R.id.editPhoneInput)
        val addressInput = findViewById<EditText>(R.id.editAddressInput)
        val checkedBox = findViewById<CheckBox>(R.id.editCheckedBox)

        val student = StudentRepository.getStudent(studentId)

        if (student != null) {
            nameInput.setText(student.name)
            idInput.setText(student.id)
            phoneInput.setText(student.phone)
            addressInput.setText(student.address)
            checkedBox.isChecked = student.isChecked
        }

        findViewById<Button>(R.id.saveEditButton).setOnClickListener {
            StudentRepository.deleteStudent(studentId)
            val newStudent = Student(
                id = idInput.text.toString(),
                name = nameInput.text.toString(),
                phone = phoneInput.text.toString(),
                address = addressInput.text.toString(),
                isChecked = checkedBox.isChecked
            )
            StudentRepository.addStudent(newStudent)
            finish()
        }

        findViewById<Button>(R.id.deleteButton).setOnClickListener {
            StudentRepository.deleteStudent(studentId)
            val intent = Intent(this, StudentsListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        findViewById<Button>(R.id.cancelEditButton).setOnClickListener {
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
