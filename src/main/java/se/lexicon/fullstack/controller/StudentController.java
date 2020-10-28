package se.lexicon.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.fullstack.dto.StudentDto;
import se.lexicon.fullstack.entity.Student;
import se.lexicon.fullstack.repository.StudentRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/list")
    public String showStudentList(Model model) {
        List<Student> studentList = (List<Student>) studentRepository.findAll();
        List<StudentDto> studentDTOs = studentList.stream().map(student -> new StudentDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                student.getRegisterDate())).collect(Collectors.toList());
        model.addAttribute("students", studentDTOs);
        return "student_control";
    }


    @GetMapping("/find/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        System.out.println("id = " + id);
        Student student = studentRepository.findById(id).get();
        StudentDto dto = new StudentDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                student.getRegisterDate()
        );
        model.addAttribute("dto", dto);
        return "student_view";
    }

    @GetMapping("/signup")
    public String showRegisterForm(Model model) {
        StudentDto dto = new StudentDto();
        model.addAttribute("dto", dto);
        return "register_form";
    }

    @PostMapping("/add")
    public String registerStudent(@ModelAttribute("dto") @Valid StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (studentDto.getName().startsWith("M")) {
            FieldError error = new FieldError("dto", "name", "Name is not valid");
            bindingResult.addError(error);
        }


        if (bindingResult.hasErrors()) {
            return "register_form";
        }


        System.out.println("studentDto.toString() = " + studentDto.toString());
        Student student = new Student(studentDto.getName(), studentDto.getEmail(), studentDto.getCourse());
        studentRepository.save(student);
        redirectAttributes.addFlashAttribute("message", "Saving Student Email: " + studentDto.getEmail() + " is Done");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/student/list";
    }


    @GetMapping("delete/{id}")
    public String deleteStudentById(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        studentRepository.deleteById(id);

        redirectAttributes.addFlashAttribute("message", "Student id " + id + " is deleted!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/student/list";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {

        Student student = studentRepository.findById(id).get();

        StudentDto dto = new StudentDto(student.getId(), student.getName(), student.getEmail(), student.getCourse(), student.getRegisterDate());
        model.addAttribute("dto", dto);
        return "edit_form";
    }


    @PostMapping("/edit")
    public String updateStudent(@ModelAttribute("dto") @Valid StudentDto dto,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "edit_form";
        }

        Student student=new Student(dto.getId(),dto.getName(),dto.getEmail(),dto.getCourse());
        studentRepository.save(student);
        return "redirect:/student/list";

    }

}
