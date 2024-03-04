package net.sytes.fly.Expenser.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.sytes.fly.Expenser.dto.IncomeType.TransactionTypeDTO;

import java.util.List;

@Entity
@Table(name ="Transaction_type")
@Getter
@Setter
public class TransactionType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    @JsonProperty("id")
    private long idTransaction;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean isIncome;

    @OneToMany(mappedBy = "transactionType")
    @JsonBackReference
    private List<Transaction> transactions;

    public TransactionTypeDTO toResponse(){
        return new TransactionTypeDTO(this.idTransaction,this.name,this.description,this.isIncome);
    }
}
