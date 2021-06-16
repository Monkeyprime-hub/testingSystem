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
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "question")
//public class Question {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    Long id;
//
//    Integer questionOrder;
//
//    @Column(length = 10000)
//    String text;
//
//    @ManyToOne
//    @JoinColumn(name = "test_id", referencedColumnName = "id")
//    Test test;
//
//    @Column(name = "test_id", updatable = false, insertable = false)
//    Long testId;
//
//    @Builder.Default
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "question_id", referencedColumnName = "id")
//    List<Answer> answers = new ArrayList<>();
//
//    public static Question makeDefault() {
//        return builder().build();
//    }
//}
