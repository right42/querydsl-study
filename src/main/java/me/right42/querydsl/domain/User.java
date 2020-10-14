package me.right42.querydsl.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Builder
public class User {

    @Id
    @GeneratedValue
    @Column(name = "users_id")
    private Long id;

    private String name;

    private String password;
}
