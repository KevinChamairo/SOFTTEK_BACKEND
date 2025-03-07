package com.kacr.back.backend_softtek.services.Impl;

import com.kacr.back.backend_softtek.entity.studentEntity;
import com.kacr.back.backend_softtek.services.studentService;
import com.kacr.back.backend_softtek.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImpl implements studentService {
    private final studentRepository studentRepository;

    @Autowired
    public studentServiceImpl(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public studentEntity createStudent(studentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public List<studentEntity> createStudents(List<studentEntity> students) {
        return studentRepository.saveAll(students);
    }

    @Override
    public Optional<studentEntity> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<studentEntity> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public studentEntity updateStudent(studentEntity student) {
        return studentRepository.findById(student.getId()).map(existingStudent -> {
            existingStudent.setNombre(student.getNombre());
            existingStudent.setApellido(student.getApellido());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setCreditos(student.getCreditos());
            existingStudent.setSemestre(student.getSemestre());
            existingStudent.setPromedio(student.getPromedio());
            return studentRepository.save(existingStudent);
        }).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Student deleted";
    }
}

