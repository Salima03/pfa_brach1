package com.example.einternmatchback.Authentification.user;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("STUDENT")
@Table(name = "student_profiles")
public class StudentProfils extends User {

    private String firstName;

    private String lastName;

    private String headline;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private String location;

    private String phone;

    private String cvPath;

    private String motivationLetterPath;

    private String profilePicture;

    private String coverPhoto;

  }
