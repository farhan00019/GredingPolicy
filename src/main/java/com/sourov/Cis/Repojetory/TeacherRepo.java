package com.sourov.Cis.Repojetory;

import com.sourov.Cis.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
    public Integer countById(Integer id);
}
