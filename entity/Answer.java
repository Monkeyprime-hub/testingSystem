//package com.example.crazy_test.entity;
//
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
//@Table(name = "answer")
//public class Answer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    Long id;
//
//    Integer answerOrder;
//
//    @Column(length = 10000)
//    String name;
//
//    @ManyToOne
//    @JoinColumn(name = "question_id", referencedColumnName = "id")
//    Question question;
//
//    @Column(name = "question_id", updatable = false, insertable = false)
//    Long questionId;
//
//    public static Answer makeDefault() {
//        return builder().build();
//    }
//}
