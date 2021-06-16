package com.akvelon.testingSystem.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "university_group")
public class UniversityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    UUID id;

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    University university;

    @Column(name = "university_id", updatable = false, insertable = false)
    Long universityId;

    public static UniversityGroup makeDefault(String name, University university) {
        return builder()
                .name(name)
                .university(university)
                .build();
    }
}
