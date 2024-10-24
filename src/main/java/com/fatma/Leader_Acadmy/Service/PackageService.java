package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.dto.PackageRequest;
import com.fatma.Leader_Acadmy.model.dto.PackageResponse;
import com.fatma.Leader_Acadmy.model.entity.Package;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PackageService extends CrudService<Package, PackageRequest, PackageResponse> {
    List<PackageResponse> findAllByTeacherIdAndLevelId(long teacherId, long levelId);
}
