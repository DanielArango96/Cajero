package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        String usuarioBD = "daniel123";
        String usuario;
        String contrasenaBD = "daniel96";
        String contrasena;
        double saldoInicial = 3000;
        int opcion;

        Scanner leer = new Scanner(System.in);
        int intentos = 0;
        boolean sesionIniciada = false;
        double saldo = saldoInicial;

        while (intentos < 3 && !sesionIniciada) {
            System.out.print("Ingrese usuario: ");
            usuario = leer.nextLine();


            if (usuario.equals(usuarioBD)) {
                System.out.print("Ingrese contraseña: ");
                contrasena = leer.nextLine();



                if (contrasena.equals(contrasenaBD)) {
                    System.out.println("Inicio de sesión exitoso.");
                    sesionIniciada = true;
                }


                } else {
                    System.out.println("Usuario o contraseña incorrectos. Intente de nuevo.");
                    intentos++;
                }
            }

            if (!sesionIniciada) {
                System.out.println("Excedió el número de intentos permitidos. El programa se cerrará.");

            }


            do {
                System.out.println("\nMenú:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar saldo");
                System.out.println("3. Consignar saldo");
                System.out.println("4. Transferir saldo");
                System.out.println("5. Salir");

                System.out.print("Seleccione una opción: ");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Saldo actual: " + saldo);
                        break;
                    case 2:
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidadRetiro = leer.nextDouble();
                        if (cantidadRetiro <= saldo && cantidadRetiro >= 0) {
                            saldo -= cantidadRetiro;
                            System.out.println("Retiro exitoso. Saldo restante: " + saldo);
                        } else {
                            System.out.println("Cantidad inválida o saldo insuficiente.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese la cantidad a consignar: ");
                        double cantidadConsignacion = leer.nextDouble();
                        if (cantidadConsignacion >= 0) {
                            saldo += cantidadConsignacion;
                            System.out.println("Consignación exitosa. Saldo actual: " + saldo);
                        } else {
                            System.out.println("Cantidad inválida.");
                        }
                        break;
                    case 4:
                        System.out.print("Ingrese la cuenta de destino: ");
                        String cuentaDestino = leer.next();
                        System.out.print("Ingrese la cantidad a transferir: ");
                        double cantidadTransferencia = leer.nextDouble();
                        if (cantidadTransferencia <= saldo && cantidadTransferencia >= 0) {
                            saldo -= cantidadTransferencia;
                            System.out.println("Transferencia exitosa. Saldo restante: " + saldo);
                        } else {
                            System.out.println("Cantidad inválida o saldo insuficiente.");
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } while (opcion != 5);

            System.out.println("Gracias por utilizar el cajero automático.");
        }
    }
