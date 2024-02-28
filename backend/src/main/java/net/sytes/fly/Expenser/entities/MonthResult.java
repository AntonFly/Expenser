package net.sytes.fly.Expenser.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name ="MonthResult")
public class MonthResult {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long idMounth;

    @Column(name="start_sum")
    private BigDecimal startSum;

    @Column(name="end_sum")
    private BigDecimal endSum;

    @Column
    private int year;

    @Column
    private int month;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser",referencedColumnName="id", nullable = false)
    private User user;

}
