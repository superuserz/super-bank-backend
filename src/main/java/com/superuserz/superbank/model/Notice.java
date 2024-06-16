package com.superuserz.superbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

    private String header;

    private String description;

    private LocalDate postedOn;

}
