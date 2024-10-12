package br.com.fiap.residex.exception;

public class CaminhaoNotFoundException extends RuntimeException {

    public CaminhaoNotFoundException() {
        super("Caminhão não encontrado!");
    }

    public CaminhaoNotFoundException(String message) {
        super(message);
    }
}
