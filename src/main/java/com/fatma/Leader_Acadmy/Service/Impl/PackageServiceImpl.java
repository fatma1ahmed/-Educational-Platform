package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Repository.PackageRepo;
import com.fatma.Leader_Acadmy.Service.PackageLevelSubjectTeacherService;
import com.fatma.Leader_Acadmy.Service.PackageService;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.PackageRequest;
import com.fatma.Leader_Acadmy.model.dto.PackageResponse;
import com.fatma.Leader_Acadmy.model.entity.Package;
import com.fatma.Leader_Acadmy.model.mapper.PackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements PackageService {
    @Autowired
    private PackageRepo packageRepo;
    @Autowired
    private PackageMapper packageMapper;
    @Autowired
    private PackageLevelSubjectTeacherService packageLevelSubjectTeacherService;
    @Override
    public PackageResponse add(PackageRequest Request) {
        Package packagee=packageMapper.toEntity(Request);
        packageLevelSubjectTeacherService.assignLevelAndSubjectAndTeacherToPackage(packagee,Request.getLevelId(),Request.getSubjectId(),Request.getTeacherId());
        return packageMapper.toResponse(packageRepo.save(packagee));
    }

    @Override
    public PackageResponse update(PackageRequest Request, long id) {
        getEntityById(id);
        Package packagee=packageMapper.toEntity(Request);
        packageLevelSubjectTeacherService.assignLevelAndSubjectAndTeacherToPackage(packagee,Request.getLevelId(),Request.getSubjectId(),Request.getTeacherId());
        packagee.setId(id);
        return packageMapper.toResponse(packageRepo.save(packagee));
    }

    @Override
    public PackageResponse getById(long id) {
        Package packagee=packageRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("package with id " + id + "not found")
        );
        return packageMapper.toResponse(packagee);
    }
    public Package getEntityById(long id) {
        return packageRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("package with id " + id + "not found")
        );
    }

    @Override
    public List<PackageResponse> getAll() {
        return packageRepo.findAll().stream().map(
                packageMapper::toResponse
        ).toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getEntityById(id);
        packageRepo.deleteById(id);
        return new ResponseEntity<>("Package with id " + id + "deleted successfully", HttpStatus.ACCEPTED);
    }

    @Override
    public List<PackageResponse> findAllByTeacherIdAndLevelId(long teacherId, long levelId) {
        return packageRepo.findAllByTeacherIdAndLevelId(teacherId,levelId).stream().map(
                packageMapper::toResponse
        ).collect(Collectors.toList());
    }
}
