package com.springbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "The account does not belong to this user")
public class AccountOwnerException extends RuntimeException {
}
