package net.sytes.fly.Expenser.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name ="Income_type")
@Getter
@Setter
public class IncomeType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long idIncome;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "incomeType")
    @JsonBackReference
    private List<Income> incomes;
}
