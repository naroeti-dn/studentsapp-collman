package com.example.studentsapp

object StudentRepository {
    
    val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun deleteStudent(id: String) {
        students.removeAll { it.id == id }
    }

    fun getStudent(id: String): Student? {
        return students.find { it.id == id }
    }

    fun updateStudent(id: String, name: String, phone: String, address: String, isChecked: Boolean) {
        val student = getStudent(id)
        if (student != null) {
            student.name = name
            student.phone = phone
            student.address = address
            student.isChecked = isChecked
        }
    }
}
