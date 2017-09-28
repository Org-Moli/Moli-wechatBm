package com.imory.bam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bam/imory_user")
public class ImoryUserController {

    @RequestMapping("/imory_userList")
    public String listImoryUser()
    {
        return "/bam/ImoryUserList";
    }
    
    @RequestMapping("/toastr_notifications")
    public String toastr_notifications()
    {
        return "/bam/toastr_notifications";
    }
}
