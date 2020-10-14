package me.right42.querydsl.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="study")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Builder
@AllArgsConstructor
public class Study {

    @Id
    @GeneratedValue
    @Column(name = "study_id")
    private Long id;

    private String name;

    private Integer maximumNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id")
    private User user;

}
