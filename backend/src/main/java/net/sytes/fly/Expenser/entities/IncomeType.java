package net.sytes.fly.Expenser.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeResponse;

import java.util.List;

@Entity
@Table(name ="Income_type")
@Getter
@Setter
public class IncomeType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    @JsonProperty("id")
    private long idIncome;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "incomeType")
    @JsonBackReference
    private List<Income> incomes;

    public IncomeTypeResponse toResponse(){
        return new IncomeTypeResponse(this.idIncome,this.name,this.description);
    }
}
