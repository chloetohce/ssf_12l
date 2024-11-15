package sg.edu.nus.iss.ssf_12l.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.ssf_12l.model.student.Student;




@Controller
@RequestMapping("/students") // For class level mapping, don't give it a method.
public class StudentController {
    // private List<Student> students;

    // public StudentController() {
    //     students = new ArrayList<>();
    // }

    @GetMapping
    public String getStudents(Model model) throws ParseException {
        List<Student> students = new ArrayList<>();

        String dob = "31 Dec 2001 10:18:00.000 HKT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:MM:ss.SSS zzz");
        TimeZone tz = TimeZone.getTimeZone("Asia/Singapore"); 
        sdf.setTimeZone(tz); 
        Date dDob = sdf.parse(dob);
        Long epochDob = dDob.getTime();
        students.add(new Student("Jacob"));
        students.add(new Student("Jude"));
        
        System.out.println("Students: " + students.size());

        // Convert epoch long to date
        Long epochTime = 13329030023L;
        Date date = new Date(epochTime);

        List<Integer> temp = List.of(1, 2, 3);

        // thymeleaf
        model.addAttribute("studentList", students);
        return "students";
    }
    
}
