package com.imory.bam.banner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bam/imoryBanner")
public class ImoryBannerController {

    @RequestMapping("/imoryBanner")
    public String imoryBanner()
    {
        return "/bam/uploadImoryBanner";
    }
}
