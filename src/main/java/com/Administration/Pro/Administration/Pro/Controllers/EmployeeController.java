package com.Administration.Pro.Administration.Pro.Controllers;

import com.Administration.Pro.Administration.Pro.Repository.EmployeeRepository;
import com.Administration.Pro.Administration.Pro.Services.EmployeeService;
import com.Administration.Pro.Administration.Pro.Webdomains.Employee;
import com.Administration.Pro.Administration.Pro.Webdomains.EmployeeDTO;

import com.Administration.Pro.Administration.Pro.utils.FormatterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EmployeeController {
    public static String  uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/employeeImages";

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(Model model) {
        Long countEmployees = employeeService.totalEmployees();
        model.addAttribute("countEmployees", countEmployees);
        return "index";
    }

    @GetMapping("/registerEmployee")
    public String employeeForm(ModelMap model) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        model.put("employeeDTO", employeeDTO);
//        model.addAttribute("employeeDTO", employeeDTO + "successful");
        return "employeeForm";
    }

//    @GetMapping("/dates")
//    public String tryDate(Model model) {
//        model.addAttribute("localDateTime", LocalDateTime.now());
//        return "tryDate";
//    }

    @GetMapping("/allEmployees")
    public String employeeList(Model model) {
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YY");
//        System.out.println(dateFormat.format(date));
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("DateTime", FormatterUtils.formatDateTime(LocalDateTime.now()));
//        model.addAttribute("DateCreated", FormatterUtils);

        return "employeeList";
    }

    @GetMapping("/search")
    public String searchEmployee(@RequestParam("query") String query, ModelMap map) {
        List<Employee> employees = employeeService.searchEmployee(query);
        map.put("employees", employees);
        return "employeeList";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
                               @RequestParam("employeeImage")MultipartFile file,
                               @RequestParam("imgName") String imgName) throws IOException
    {
        Employee employee = new Employee ();
        employee.setId(employeeDTO.getId());
        employee.setSurname(employeeDTO.getSurname().toLowerCase());
        employee.setGivenName(employeeDTO.getGivenName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAddress(employeeDTO.getAddress());
        employee.setYoe(employeeDTO.getYoe());
        employee.setPob(employeeDTO.getPob());
        employee.setDob(employeeDTO.getDob());
//        employee.setDob(employeeDTO.getDob());
        employee.setHq(employeeDTO.getHq());
        employee.setNumber(employeeDTO.getNumber());
        employee.setNationality(employeeDTO.getNationality());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSex(employeeDTO.getSex());
        String imageUUID;

        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        employee.setImageName(imageUUID);
        employeeService.saveEmployee(employee);
        return "redirect:/allEmployees";
    }

    @GetMapping("/showAllEmployees/{id}")
    public String specificStaff(@PathVariable(name = "id") Long id,Model model) {
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("employees", employeeRepository.findById(id).get());
        model.addAttribute("localDates", FormatterUtils.formatDateTime(LocalDateTime.now()));
        return "employeeDetailedPage";
    }

    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable(name = "id") Long id, Model model) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setGivenName(employee.getGivenName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setYoe(employee.getYoe());
        employeeDTO.setPob(employee.getPob());
//        employeeDTO.setDob((Date) employee.getDob());
        employeeDTO.setDob(employee.getDob());
        employeeDTO.setHq(employee.getHq());
        employeeDTO.setNumber(employee.getNumber());
        employeeDTO.setNationality(employee.getNationality());
        employeeDTO.setDepartment(employee.getDepartment());
        employeeDTO.setSex(employee.getSex());
        employeeDTO.setImageName(employee.getImageName());
        model.addAttribute("employee", employee);
        model.addAttribute("employeeDTO", employeeDTO);
        return "editEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/allEmployees";
    }

}
