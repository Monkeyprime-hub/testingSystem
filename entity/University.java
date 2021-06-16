package com.akvelon.testingSystem.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    UUID id;

    @Column(name = "name", length = 100, nullable = false)
    String name;

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    List<UniversityGroup> groups = new ArrayList<>();

    public static University makeDefault(String name) {
        return builder()
                .name(name)
                .build();
    }
    //api
    //class

}
