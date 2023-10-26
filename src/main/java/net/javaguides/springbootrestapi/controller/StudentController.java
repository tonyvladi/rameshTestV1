package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Tony",
                "Vladi"
        );
        //return new ResponseEntity<>(student, HttpStatus.OK);
    return ResponseEntity.ok()
            .header("custom-header","Tony")
            .body(student);
    }

    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity <List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Tony", "Vladi"));
        students.add(new Student(2, "Ira", "Zacharenko"));
        students.add(new Student(3, "Lima", "Kusco"));
        students.add(new Student(4, "Povar", "Ramzy"));
        return ResponseEntity.ok(students);
    }

    //SpringBoot REST API with Path Variable
    //{id} URI template variable
    //http://localhost:8080/students/1
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    //SpringBoot REST API with REQUEST PARAM
    //http://localhost:8080/students?id=1&firstName=Tony&lastName=VladiReqParam
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName, @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return  ResponseEntity.ok(student);
    }

    //Spring boot Rest API that handles HTTP POST request -creating new resource
    //@PostMapping and @RequestBody

    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring boot REST API that handles HTTP DELETE Request - delete existing user
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted Successfully!");
    }
}
