package net.sytes.fly.Expenser.dto.Users;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.sytes.fly.Expenser.dto.MonthResult.MonthResultResponse;

import java.math.BigDecimal;
import java.util.List;

public class UserResponse extends SimpleUserResponse{
    @JsonProperty("monthResults")
    List<MonthResultResponse> monthResults;

    public UserResponse(Long id, String name, String patronymic, String surname, BigDecimal startSum, List<MonthResultResponse> mrrList) {
        super(id, name, patronymic, surname, startSum);
        this.monthResults = mrrList;

    }

    public UserResponse(SimpleUserResponse simpleUserResponse, List<MonthResultResponse> mrrList) {
        super(simpleUserResponse.id, simpleUserResponse.name, simpleUserResponse.patronymic, simpleUserResponse.surname, simpleUserResponse.startSum);
        this.monthResults = mrrList;

    }
}
