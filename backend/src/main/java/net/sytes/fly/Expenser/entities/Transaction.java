package net.sytes.fly.Expenser.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.sytes.fly.Expenser.dto.Income.TransactionDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Table(name="Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column
    private LocalDate date;

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idTransaction",referencedColumnName="id", nullable = false)
    private TransactionType transactionType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser",referencedColumnName="id", nullable = false)
    private User user;

    public TransactionDTO toResponse(){
        return new TransactionDTO(
                this.id,
                this.sum,
                this.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                this.comment,
                this.transactionType.getIdTransaction(),
                this.user.getIdUser());
    }






}
