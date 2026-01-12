package com.example.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val students: MutableList<Student>,
    private val onItemClick: (Student) -> Unit,
    private val onCheckChanged: (Student, Boolean) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.studentName)
        val idText: TextView = view.findViewById(R.id.studentId)
        val checkBox: CheckBox = view.findViewById(R.id.studentCheckbox)
        val image: ImageView = view.findViewById(R.id.studentImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        
        holder.nameText.text = student.name
        holder.idText.text = student.id
        holder.checkBox.isChecked = student.isChecked
        holder.image.setImageResource(R.drawable.student_avatar)

        holder.itemView.setOnClickListener {
            onItemClick(student)
        }

        holder.checkBox.setOnClickListener {
            onCheckChanged(student, holder.checkBox.isChecked)
        }
    }

    override fun getItemCount() = students.size
}
