package com.analyze.matrix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    // TODO update length
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 10, nullable = false)
    private String name;
    @Column(name = "password", length = 120, nullable = false)
    private String password;
    @Column(name = "mail_address", length = 120, nullable = false)
    private String mailAddress;
    @Column(name = "role", length = 10)
    private String role;
    @Column(name = "status", nullable = false)
    private UserStatusEnum status;
}
