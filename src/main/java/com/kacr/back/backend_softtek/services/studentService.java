package com.kacr.back.backend_softtek.services;
import com.kacr.back.backend_softtek.entity.studentEntity;

import java.util.List;
import java.util.Optional;

public interface studentService {
    studentEntity createStudent(studentEntity student);
    List<studentEntity> createStudents(List<studentEntity> students);
    Optional<studentEntity> getStudentById(int id);
    List<studentEntity> getStudents();
    studentEntity updateStudent(studentEntity student);
    String deleteStudentById(int id);
}
