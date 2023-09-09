package it.nave.fabrickapitest.controller.model;

import java.util.List;

public class BaseResponse<T> {
    private Status status;
    private List<Error> errors;
    private T payload;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
