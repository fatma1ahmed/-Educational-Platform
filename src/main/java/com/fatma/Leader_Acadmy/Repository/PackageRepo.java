package com.fatma.Leader_Acadmy.Repository;

import com.fatma.Leader_Acadmy.model.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepo extends JpaRepository<Package,Long> {
    List<Package> findAllByTeacherIdAndLevelId(long teacherId,long levelId);
}
