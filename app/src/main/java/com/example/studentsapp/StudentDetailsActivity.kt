package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {

    private var studentId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentId = intent.getStringExtra("studentId") ?: ""
    }

    override fun onResume() {
        super.onResume()
        loadStudent()
    }

    private fun loadStudent() {
        val student = StudentRepository.getStudent(studentId)

        if (student != null) {
            findViewById<TextView>(R.id.detailName).text = "name: " + student.name
            findViewById<TextView>(R.id.detailId).text = "id: " + student.id
            findViewById<TextView>(R.id.detailPhone).text = "phone: " + student.phone
            findViewById<TextView>(R.id.detailAddress).text = "address: " + student.address
            findViewById<CheckBox>(R.id.detailChecked).isChecked = student.isChecked
            findViewById<ImageView>(R.id.detailImage).setImageResource(R.drawable.student_avatar)
        }

        findViewById<Button>(R.id.editButton).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentId", studentId)
            startActivity(intent)
        }
    }
}
