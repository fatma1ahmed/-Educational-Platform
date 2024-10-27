package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Repository.PdfRepo;
import com.fatma.Leader_Acadmy.Service.PdfLessonService;
import com.fatma.Leader_Acadmy.Service.PdfService;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.PdfRequest;
import com.fatma.Leader_Acadmy.model.dto.PdfResponse;
import com.fatma.Leader_Acadmy.model.entity.Pdf;
import com.fatma.Leader_Acadmy.model.mapper.PdfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PdfServiceImpl implements PdfService {
    @Autowired
    private PdfRepo pdfRepo;
    @Autowired
    private PdfMapper pdfMapper;
    @Autowired
    private PdfLessonService pdfLessonService;
    @Override
    public PdfResponse add(PdfRequest Request) {
        Pdf pdf=pdfMapper.toEntity(Request);
        pdfLessonService.assignLessonToPdf(pdf,Request.getLessonId());
        return pdfMapper.toResponse(pdfRepo.save(pdf));
    }

    @Override
    public PdfResponse update(PdfRequest Request, long id) {
        getEntityById(id);
        Pdf pdf = pdfMapper.toEntity(Request);
        pdfLessonService.assignLessonToPdf(pdf, Request.getLessonId());
        pdf.setId(id);
        return pdfMapper.toResponse(pdfRepo.save(pdf));
    }
    @Override
    public PdfResponse getById(long id) {
        Pdf pdf=pdfRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this Pdf with id " + id + "not found")
        );

        return pdfMapper.toResponse(pdf);
    }
    public Pdf getEntityById(long id) {
        return pdfRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this Pdf with id " + id + "not found")
        );
    }

    @Override
    public List<PdfResponse> getAll() {
        return pdfRepo.findAll().stream().map(
                pdfMapper::toResponse
        ).toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getEntityById(id);
        pdfRepo.deleteById(id);
        return new ResponseEntity<>("pdf with id " + id + "deleted successfully", HttpStatus.ACCEPTED);
    }

    @Override
    public List<PdfResponse> getAllPdfsByLessonId(long lessonId) {
        return pdfRepo.findAllByLessonId(lessonId).stream().map(pdfMapper::toResponse).collect(Collectors.toList());
    }
}
