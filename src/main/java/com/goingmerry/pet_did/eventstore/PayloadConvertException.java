package com.goingmerry.pet_did.eventstore;

public class PayloadConvertException extends RuntimeException {

    public PayloadConvertException(Exception e) {
        super(e);
    }
}
