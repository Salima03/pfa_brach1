package com.example.einternmatchback.Authentification.user;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("COMPANY")
@Table(name = "company_profiles")
public class CompanyProfile extends User {

    private String name;

    private String sector;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String website;

    private String logoPath;

    private String profilePicture;

    private String coverPhoto;

  }
