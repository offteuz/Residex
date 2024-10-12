package br.com.fiap.residex.exception;

public class RecipienteNotFoundException extends RuntimeException {

    public RecipienteNotFoundException() {
        super("Recipiente não encontrado!");
    }

    public RecipienteNotFoundException(String message) {
        super(message);
    }

}
