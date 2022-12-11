package com.sourov.Cis.Service;

import com.sourov.Cis.Model.Teacher;
import com.sourov.Cis.Repojetory.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    private TeacherRepo teacherRepo;

    public List<Teacher> studentList(){
        return teacherRepo.findAll();
    }
    public Teacher get(Integer id) throws TeacherNotFoundException {
        Optional<Teacher> result=teacherRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new TeacherNotFoundException("no user in this ID"+id);
    }

    }


