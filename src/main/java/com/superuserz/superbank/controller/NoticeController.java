package com.superuserz.superbank.controller;

import com.superuserz.superbank.model.Notice;
import com.superuserz.superbank.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notice")
    public List<Notice> getNotices() {
        List<Notice> notices = new ArrayList<>();
        return noticeService.getNotices();
    }
}
