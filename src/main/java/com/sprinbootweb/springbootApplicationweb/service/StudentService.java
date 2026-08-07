package com.sprinbootweb.springbootApplicationweb.service;


import com.sprinbootweb.springbootApplicationweb.entity.Student;
import com.sprinbootweb.springbootApplicationweb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    // delegate to student repository through dependency injection

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    // bussiness logic
    // service class tell to repository to store in db--> only for validation or bussiness logic then deligate student repostory
    public Student createStudent(Student studentreq){
        studentreq.setDeleted(false);
        Student studentresp=studentRepository.save(studentreq);
        return studentresp;


    }

    public Student getStudent(Long id){
        Optional<Student> studentresp =studentRepository.findByIdAndDeletedFalse(id);
        if(studentresp.isPresent()){
            return  studentresp.get();
        }
        return null;
    }
    public List<Student>  getAllStudent(){
        List<Student>  studentList=studentRepository.findByDeletedIsFalse();
        return studentList;
    }
    public Student updateStudent(Long id,Student studentreq){
        Optional<Student> studentExisting =studentRepository.findByIdAndDeletedFalse(id);
        if(studentExisting.isEmpty()){
            return null;
        }
        Student studentToSave=studentExisting.get();
        studentToSave.setName(studentreq.getName());
        studentToSave.setAge(studentreq.getAge());
        studentToSave.setEmail(studentreq.getEmail());
        studentToSave.setSubject(studentreq.getSubject());
        studentToSave.setRollNo(studentreq.getRollNo());
        studentToSave.setDeleted(false);
        return studentRepository.save(studentToSave);

    }
    public Boolean deleteStudent(Long id){
        Boolean isStudent =studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
    }
    public Boolean deletedAllStudent() {

        if (studentRepository.findAll().isEmpty()) {
            return false;
        }
        studentRepository.deleteAll();
        return true;
    }
    public  Boolean deleteStudentSoftly(Long id){
        //get and update set 1
        Optional<Student> existingStudent=studentRepository.findByIdAndDeletedFalse(id);
        if(existingStudent.isEmpty()){
            return false;
        }
        Student studentTOSave=existingStudent.get();
        studentTOSave.setDeleted(true);
        studentRepository.save(studentTOSave);
        return true;

    }

    public List<Student> getAllDeletedSoftly(){
        List<Student> deletedsoftlyRes=studentRepository.findByDeletedTrue();
        return deletedsoftlyRes;
    }



    // 1. post call and store student information
    // 2. get information provide
    // 3. bussiness logic
    // 4. interect with db
    // 5. response back to client
}
