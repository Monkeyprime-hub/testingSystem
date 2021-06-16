package com.akvelon.testingSystem.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class UniversityDTO {

    @NonNull
    UUID id;

    @NonNull
    String name;
}
