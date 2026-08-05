package com.sprinbootweb.springbootApplicationweb.service;


import com.sprinbootweb.springbootApplicationweb.entity.Student;
import com.sprinbootweb.springbootApplicationweb.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    // delegate to student repository through dependency injection

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentreq){

        Student studentresp=studentRepository.save(studentreq);
        return studentresp;

        // bussiness logic
        // service class tell to repository to store in db--> only for validation or bussiness logic then deligate student repostory
    }

    public Student getStudent(Long id){
        Optional<Student> studentresp =studentRepository.findById(id);
        if(studentresp.isPresent()){
            return  studentresp.get();
        }
        return null;
    }
    public List<Student>  getAllStudent(){
        List<Student>  studentList=studentRepository.findAll();
        return studentList;
    }
    public Student updateStudent(Long id,Student studentreq){
        Optional<Student> studentExisting =studentRepository.findById(id);
        if(studentExisting.isEmpty()){
            return null;
        }
        Student studentToSave=studentExisting.get();
        studentToSave.setName(studentreq.getName());
        studentToSave.setAge(studentreq.getAge());
        studentToSave.setEmail(studentreq.getEmail());
        studentToSave.setSubject(studentreq.getSubject());
        studentToSave.setRollNo(studentreq.getRollNo());
        return studentRepository.save(studentToSave);

    }
    public Boolean deleteStudent(Long id){
        Boolean isStudent =studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
    }


    // 1. post call and store student information
    // 2. get information provide
    // 3. bussiness logic
    // 4. interect with db
    // 5. response back to client
}
