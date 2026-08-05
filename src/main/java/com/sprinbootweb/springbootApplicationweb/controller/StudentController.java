package com.sprinbootweb.springbootApplicationweb.controller;

import com.sprinbootweb.springbootApplicationweb.entity.Student;
import com.sprinbootweb.springbootApplicationweb.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    //deletege to student service class for bussiness login through dependency injection

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }


    //create student (Post -> /api/students with body
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student createdStudent=studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }


    // read one record of student (Get -> /api/students/{id}
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp=studentService.getStudent(id);
        if(studentResp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

     // read all/multiple record (Get -> /api/students
    @GetMapping("/getAll")
     public  ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentsList=studentService.getAllStudent();
        if(studentsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentsList);
     }


    // update student (put -> /api/students/{id} with body puri body
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentreq){
        Student studentupdate=studentService.updateStudent(id,studentreq);
        if(studentupdate==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentupdate);
    }

    // delete student  ( delete -> /api/students/{id}
    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted=studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Successfully deleted");
    }
}
