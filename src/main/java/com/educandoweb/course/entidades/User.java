package com.educandoweb.course.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private List<Order> orders = new ArrayList <>();

    public User ( Long id, String name, String email, String phone, String password, List <Order> orders ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.orders = orders;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass( this ) != Hibernate.getClass( o )) return false;
        User user = (User) o;
        return getId() != null && Objects.equals( getId(), user.getId() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}