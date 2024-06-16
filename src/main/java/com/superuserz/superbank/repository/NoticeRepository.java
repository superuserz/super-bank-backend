package com.superuserz.superbank.repository;


import com.superuserz.superbank.entity.NoticeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface NoticeRepository extends CrudRepository<NoticeEntity, String> {

}
