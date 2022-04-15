package br.com.azevedo.rayldo.vialactea.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeuBackEndException extends ResponseStatusException {
    public MeuBackEndException (String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
