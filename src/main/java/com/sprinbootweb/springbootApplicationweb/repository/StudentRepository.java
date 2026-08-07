package com.sprinbootweb.springbootApplicationweb.repository;

import com.sprinbootweb.springbootApplicationweb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndDeletedFalse(Long id);
    List<Student> findByDeletedIsFalse();
    List<Student> findByDeletedTrue();
}

        /* use method using JPA for SQL Quereis */
        /*1. create-> save() ->  insert into student
        2.Read All -> findAll() -> select * from student
        3.Read single -> find() -> select * from student where id={id}
        4. delete by id -> deleteById() ->
        5. update -> save()
           -> ExistById() -> check id is existing or not
         */
/* save to db */

