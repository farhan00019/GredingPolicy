package com.sourov.Cis.Controller;
import com.sourov.Cis.Model.Teacher;
import com.sourov.Cis.Service.TeacherNotFoundException;
import com.sourov.Cis.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher")
    public String ShowAllTeacher(Model model){
        List<Teacher> list=teacherService.teacherList();
        model.addAttribute("list",list);
        return "teacherlist";

    }
    @GetMapping("/newteacher")
    public String newteacher(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teachersave";
    }
    @PostMapping("/teachersave")
    public String teachersave(Teacher s){
        teacherService.save(s);
        return "redirect:/teacher";

    }
    @GetMapping("/teacheredit/{id}")
    public String TeacherEdit(@PathVariable("id") Integer id, Model model){
        try {
            Teacher teacher =teacherService.get(id);
            model.addAttribute("teacher",teacher);
            return "teachersave";
        } catch (TeacherNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/teacher";
    }
    @GetMapping("/teacherdelete/{id}")
    public String deleteTeacher(@PathVariable("id")Integer id){
        try {
            teacherService.teacherDelete(id);
            return "redirect:/teacher";
        } catch (TeacherNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/teacher";
    }
}


