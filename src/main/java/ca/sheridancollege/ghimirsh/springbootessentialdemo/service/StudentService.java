package ca.sheridancollege.ghimirsh.springbootessentialdemo.service;

import ca.sheridancollege.ghimirsh.springbootessentialdemo.dao.StudentDao;
import ca.sheridancollege.ghimirsh.springbootessentialdemo.model.Student;

import java.util.List;
import java.util.UUID;

public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public  int persistNewStudent(UUID studentId, Student student){
        UUID studentUId = (studentId == null? UUID.randomUUID(): studentId);
        return studentDao.insertNewStudent(studentUId, student);
    }

    public  Student getStudentById(UUID studentId){
        return  studentDao.selectStudentById(studentId);
    }

    public  List<Student> selectAllStudents(){
        return  studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student studentUpdate){
        return studentDao.updateStudentById(studentId, studentUpdate);
    }

    public int deleteStudentById(UUID studentId){
        Student student = getStudentById(studentId);
        if(student == null){
            throw new NullPointerException("Cannot find student");
        }
        return studentDao.deleteStudentById(studentId);
    }
}
