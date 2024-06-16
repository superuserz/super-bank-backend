package com.superuserz.superbank.impl;

import com.superuserz.superbank.entity.NoticeEntity;
import com.superuserz.superbank.model.Notice;
import com.superuserz.superbank.repository.NoticeRepository;
import com.superuserz.superbank.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<Notice> getNotices() {
        List<NoticeEntity> noticeEntities = (List<NoticeEntity>) noticeRepository.findAll();
        List<Notice> notices = new ArrayList<>();
        for(NoticeEntity entity : noticeEntities){
            Notice notice = new Notice(entity.getHeader(), entity.getDescription(), entity.getPublishedOn());
            notice.setHeader(entity.getHeader());
            notice.setDescription(entity.getDescription());
            notices.add(notice);
        }
        return notices;
    }
}
