package com.balyan.pankaj.student_service.service;

import com.balyan.pankaj.student_service.dto.School;
import com.balyan.pankaj.student_service.dto.StudentResponse;
import com.balyan.pankaj.student_service.model.Student;
import com.balyan.pankaj.student_service.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private JSONPlaceHolderClient placeHolderClient;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SchoolServiceImpl schoolClient;

    public ResponseEntity<?> createStudent(Student student){
        try{
            return new ResponseEntity<Student>(studentRepo.save(student), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getStudentById(String id){
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()){
            StudentResponse stuReponse = new StudentResponse();
            stuReponse.setId(student.get().getId());
            // School school = restTemplate.getForObject("http://SCHOOL-SERVICE/school/"+student.get().getSchoolId(), School.class);
            stuReponse.setAge(student.get().getAge());
            stuReponse.setName(student.get().getName());
            stuReponse.setGender(student.get().getGender());
            logger.info("getting data from Feign client from School Service");
            stuReponse.setSchool(schoolClient.getSchoolById(2L));
            stuReponse.setPost(placeHolderClient.getPostById(2L));
            return new ResponseEntity<>(stuReponse, HttpStatus.OK);
        } else {

            return new ResponseEntity<>("No Student Found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getAllStudent(){
        List<Student> students = studentRepo.findAll();
        if (!students.isEmpty()){
            return new ResponseEntity<>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No student exist", HttpStatus.NOT_FOUND);
        }
    }
}
