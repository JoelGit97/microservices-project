package com.microservices.domains;

import com.microservices.exception.BusinessLogicException;
import com.microservices.exception.LogLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Account balance")
public class AccountBalance {
    private BigDecimal balance;

    public void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessLogicException("The balance of an account cannot be less than zero.", LogLevel.ERROR);
        }
        this.balance = balance;
    }
}
