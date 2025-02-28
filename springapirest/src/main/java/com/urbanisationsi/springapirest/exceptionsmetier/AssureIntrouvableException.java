package com.urbanisationsi.springapirest.exceptionsmetier;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // C'est une exception de type BAD_REQUEST, code 400, c'est à dire que la requête n'est pas correcte
public class AssureIntrouvableException extends RuntimeException {
    // Exception levée lorsqu'un assure n'est pas trouvé
    public AssureIntrouvableException(String message) {
        super(message);
    }
}
