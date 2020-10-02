package ca.sheridancollege.ghimirsh.springbootessentialdemo.dao;

import ca.sheridancollege.ghimirsh.springbootessentialdemo.model.Student;

import java.util.*;

public class StudentFakeDaoImpl  implements  StudentDao{
    private final Map<UUID, Student> studentDatabase;

    public StudentFakeDaoImpl() {
        this.studentDatabase = new HashMap<>();
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        studentDatabase.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {

        return studentDatabase.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(studentDatabase.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        studentDatabase.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        studentDatabase.remove(studentId);
        return 1;
    }
}
