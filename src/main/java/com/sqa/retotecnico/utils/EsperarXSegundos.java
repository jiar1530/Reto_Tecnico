package com.sqa.retotecnico.utils;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;

public class EsperarXSegundos implements Task {
    private final int segundos;

    public EsperarXSegundos(int segundos) {
        this.segundos = segundos;
    }

    public static EsperarXSegundos por(int segundos) {
        return new EsperarXSegundos(segundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
