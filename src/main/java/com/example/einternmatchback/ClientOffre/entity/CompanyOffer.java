package com.example.einternmatchback.ClientOffre.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "company_offers")
@Data
public class CompanyOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private StageType stage_type;

    private String location;
    private LocalDate start_date;
    private String duration;
    private String skills_required;
    private String responsibilities;
    private String benefits;
    private Boolean is_sponsored;
    private Boolean is_active;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
