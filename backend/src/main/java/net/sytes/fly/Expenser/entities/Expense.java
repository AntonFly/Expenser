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
@Table(name ="Expense")
public class Expense {
    @Id
    @Column(name="id")
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
    @JoinColumn(name="id_expense" ,referencedColumnName="id", nullable = false)
    private ExpenseType expenseType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser",referencedColumnName="id", nullable = false)
    private Users users;

}
