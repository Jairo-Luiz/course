package com.educandoweb.course.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order ( Long id, Instant moment, User client ) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass( this ) != Hibernate.getClass( o )) return false;
        Order order = (Order) o;
        return getId() != null && Objects.equals( getId(), order.getId() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}