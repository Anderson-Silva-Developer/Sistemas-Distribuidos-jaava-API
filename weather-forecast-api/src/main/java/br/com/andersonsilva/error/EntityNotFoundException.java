package br.com.andersonsilva.error;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String msm) {
        super(msm);
    }
}
