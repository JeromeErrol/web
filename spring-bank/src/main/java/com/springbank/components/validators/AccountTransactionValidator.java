package com.springbank.components.validators;

import com.springbank.domain.AccountTransaction;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AccountTransactionValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(AccountTransaction.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AccountTransaction accountTransaction = (AccountTransaction) o;

        if (accountTransaction.isProcessed()) {
            errors.reject("The transaction has already been processed");
        }
        if(accountTransaction.getAmount() <= 0){
            errors.reject("The amount must be greater than 0");
        }
    }
}
