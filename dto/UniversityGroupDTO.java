package com.akvelon.testingSystem.dto;

import com.akvelon.testingSystem.entity.University;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniversityGroupDTO {

    @NonNull
    UUID id;

    @NonNull
    String name;

    @NonNull
    University university;
}
