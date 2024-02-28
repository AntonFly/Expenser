package net.sytes.fly.Expenser.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="Users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    @JsonProperty("id")
    private long idUser;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column
    private BigDecimal startSum;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<MonthResult> monthResultList;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Income> incomeList;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Expense> expenseList;


}
