package net.sytes.fly.Expenser.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.sytes.fly.Expenser.dto.MonthResult.MonthResultResponse;
import net.sytes.fly.Expenser.dto.Users.SimpleUserResponse;
import net.sytes.fly.Expenser.dto.Users.UserResponse;

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
    @JsonManagedReference
    private List<MonthResult> monthResultList;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Income> incomeList;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Expense> expenseList;

    public UserResponse toResponse(){
        List<MonthResultResponse> mrrList = this.getMonthResultList().stream()
                .map(MonthResult::toResponse).toList();
        return new UserResponse(
                toSimpleResponse(),
                mrrList
        );
    }

    public SimpleUserResponse toSimpleResponse(){
        return new SimpleUserResponse(
                this.getIdUser(),
                this.getName(),
                this.getPatronymic(),
                this.getSurname(),
                this.getStartSum()
        );
    }
}
