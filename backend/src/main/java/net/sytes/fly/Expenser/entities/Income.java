package net.sytes.fly.Expenser.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="Income")
public class Income {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idIncome",referencedColumnName="id", nullable = false)
    private IncomeType incomeType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser",referencedColumnName="id", nullable = false)
    private User user;






}
