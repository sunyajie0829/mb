package com.felix.sms_admin.controller;

import com.felix.common.result.FelixResult;
import com.felix.mbg.model.TStudent;
import com.felix.sms_admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/stu")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @ResponseBody
    @RequestMapping("/register")
    public FelixResult register(@RequestBody TStudent student) throws Exception{
        return studentService.register(student);
    }

    @ResponseBody
    @RequestMapping("/login")
    public FelixResult login(@RequestBody TStudent student) throws Exception{
        return studentService.login(student);
    }

    @ResponseBody
    @RequestMapping("/info")
    public FelixResult info(@RequestBody TStudent student) throws Exception {
        return studentService.info(student);
    }
}
