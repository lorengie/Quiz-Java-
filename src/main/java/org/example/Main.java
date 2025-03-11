package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Auto.buscarPorPlaca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Auto> autos = new ArrayList<>();
        int opcion;
            do {
                System.out.println("Bienevenido al taller de autos (: Seleccione una opcion para continuar. ");
                System.out.println("1. Agregar un auto");
                System.out.println("2. Mostrar detalles de todos los autos");
                System.out.println("3. Verificar si un auto es antiguo");
                System.out.println("4. Verificar si un auto necesita mantenimiento");
                System.out.println("5. Calcular consumo de combustible");
                System.out.println("6. Calcular combustible restante");
                System.out.println("7. Salir\n");
            opcion = scanner.nextInt();
                scanner.nextLine();
                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese la placa: ");
                            String placa = scanner.nextLine();

                            System.out.print("Ingrese la marca: ");
                            String marca = scanner.nextLine();

                            System.out.print("Ingrese el modelo: ");
                            String modelo = scanner.nextLine();

                            System.out.print("Ingrese el año: ");
                            int anio = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Ingrese el kilometraje: ");
                            double kilometraje = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Ingrese el estado: ");
                            String estado = scanner.nextLine();

                            autos.add(new Auto(marca, modelo, anio, kilometraje, estado, placa));
                            System.out.println("Se agrego el auto al Taller (:");
                            break;

                        case 2:
                            System.out.print("Ingrese la placa del auto a buscar: ");
                            String placaBusqueda = scanner.nextLine();
                            Auto encontrado = buscarPorPlaca(autos, placaBusqueda);
                            if (encontrado != null) {
                                encontrado.descripcion();
                            } else {
                                System.out.println("No se encontró un auto con esa placa.");
                            }
                            break;

                        case 3:
                            System.out.print("Ingrese la placa del auto a verificar: ");
                            String placaAntiguo = scanner.nextLine();
                            Auto autoAntiguo = buscarPorPlaca(autos, placaAntiguo);
                            if (autoAntiguo != null) {
                                System.out.println("¿Es antiguo? " + autoAntiguo.esAntiguo());
                            } else {
                                System.out.println("No se encontró un auto con esa placa.");
                            }
                            break;

                        case 4:
                            System.out.print("Ingrese la placa del auto a verificar: ");
                            String placaMantenimiento = scanner.nextLine();
                            Auto autoMantenimiento = buscarPorPlaca(autos, placaMantenimiento);
                            if (autoMantenimiento != null) {
                                System.out.println("¿Necesita mantenimiento? " + autoMantenimiento.necesitamantenimiento());
                            } else {
                                System.out.println("No se encontró un auto con esa placa.");
                            }
                            break;

                        case 5:
                            System.out.print("Ingrese la placa del auto: ");
                            String placaConsumo = scanner.nextLine();
                            Auto autoConsumo = buscarPorPlaca(autos, placaConsumo);
                            if (autoConsumo != null) {
                                System.out.print("Ingrese la distancia recorrida (km): ");
                                double distancia = scanner.nextDouble();
                                System.out.print("Ingrese el rendimiento del vehículo (km/litro): ");
                                double rendimiento = scanner.nextDouble();
                                System.out.println("Consumo de combustible: " + autoConsumo.calcularConsumoCombustible(distancia, rendimiento) + " litros");
                            } else {
                                System.out.println("No se encontró un auto con esa placa.");
                            }
                            break;

                        case 6:
                            System.out.print("Ingrese la placa del auto: ");
                            String placaRestante = scanner.nextLine();
                            Auto autoRestante = buscarPorPlaca(autos, placaRestante);
                            if (autoRestante != null) {
                                System.out.print("Ingrese la cantidad actual de combustible en el tanque (litros): ");
                                double tanqueActual = scanner.nextDouble();
                                System.out.print("Ingrese la distancia recorrida (km): ");
                                double distanciaRestante = scanner.nextDouble();
                                System.out.print("Ingrese el rendimiento del vehículo (km/litro): ");
                                double rendimientoRestante = scanner.nextDouble();
                                System.out.println("Combustible restante: " + autoRestante.combustibleRestante(tanqueActual, distanciaRestante, rendimientoRestante));
                            } else {
                                System.out.println("No se encontró un auto con esa placa.");
                            }
                            break;

                        case 7:
                            System.out.println("Saliendo del programa, gracias por ingresar al taller (:");
                    }
                } while (opcion != 7);

        scanner.close();
    }


}