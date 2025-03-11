package org.example;

import java.util.List;

public class Auto {
    private String  marca;
    private String modelo;
    private int anio;
    private double kilometraje;
    private String estado;
    private String placa;

    public Auto(String marca, String modelo, int anio, double kilometraje, String estado, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.placa = placa;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void descripcion() {
        System.out.println("La marca es: " + marca);
        System.out.println("El modelo es: " + modelo);
        System.out.println("El año es: " + anio);
        System.out.println("Tiene " + kilometraje + " km");
        System.out.println("El estado actual es: " + estado);
    }
    public void actualizarKilometraje(double nuevoKilometraje) {
        if (nuevoKilometraje > kilometraje) {
            this.kilometraje = nuevoKilometraje;
        } else {
            System.out.println("El nuevo kilometraje debe ser mayor al actual.");
        }
    }
    public boolean esAntiguo() {
        int anioActual = java.time.Year.now().getValue();
        return (anioActual - anio) > 15;
    }
    public Boolean necesitamantenimiento(){
        return kilometraje > 100000;
    }
    public double calcularConsumoCombustible(double distancia, double rendimiento) {
        if (rendimiento <= 0) {
            throw new IllegalArgumentException("El rendimiento debe ser mayor a 0.");
        }
        return distancia / rendimiento;
    }
    public double combustibleRestante(double tanqueActual, double distancia, double rendimiento) {
        double consumo = calcularConsumoCombustible(distancia, rendimiento);
        return Math.max(tanqueActual - consumo, 0);
    }
    public static Auto buscarPorPlaca(List<Auto> autos, String placa) {
        for (Auto auto : autos) {
            if (auto.getPlaca().equalsIgnoreCase(placa)) {
                return auto;
            }
        }
        return null;
    }

}
