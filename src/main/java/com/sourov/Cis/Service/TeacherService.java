package com.sourov.Cis.Service;

import com.sourov.Cis.Model.Teacher;
import com.sourov.Cis.Repojetory.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    public void save(Teacher s){

        teacherRepo.save(s);
    }
    public List<Teacher> teacherList(){
        return teacherRepo.findAll();
    }
    public Teacher get(Integer id) throws TeacherNotFoundException {
        Optional<Teacher> result=teacherRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new TeacherNotFoundException("no user in this ID"+id);
    }
    public  void teacherDelete(Integer id) throws TeacherNotFoundException{
        Integer count=teacherRepo.countById(id);
        if(count==null ||count==0){

            throw new TeacherNotFoundException("Student not found ");
        }
        teacherRepo.deleteById(id);
    }

}
