//package com.example.crazy_test.entity;
//
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
//@Table(name = "test")
//public class Test {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    Long id;
//
//    String name;
//
//    @Builder.Default
//    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    List<Question> questions = new ArrayList<>();
//
//
//}