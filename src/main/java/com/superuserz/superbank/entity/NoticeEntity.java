package com.superuserz.superbank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "notice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noticeid")
    private Long noticeId;

    @Column
    private String header;

    @Column
    private String description;

    @Column(name = "published_on", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate publishedOn;

}
