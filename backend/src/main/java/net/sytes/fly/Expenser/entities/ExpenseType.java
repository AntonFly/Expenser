package net.sytes.fly.Expenser.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="Expense_type")
public class ExpenseType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name ="id")
    private long idExpense;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "expenseType")
    @JsonBackReference
    private List<Expense> incomes;
}
