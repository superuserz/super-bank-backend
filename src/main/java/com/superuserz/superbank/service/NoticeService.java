package com.superuserz.superbank.service;

import com.superuserz.superbank.model.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoticeService {

    public List<Notice> getNotices();
}
