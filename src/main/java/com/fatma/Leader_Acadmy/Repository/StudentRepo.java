package com.fatma.Leader_Acadmy.Repository;

import com.fatma.Leader_Acadmy.model.dto.StudentResponse;
import com.fatma.Leader_Acadmy.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    Optional<Student> findByPhone( String phone);
    Optional<Student> findByPhoneAndPassword(String phone, String password);
}
