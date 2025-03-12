package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean estado = true;
        while (estado){
            System.out.println("--------");
            System.out.println("Bienvenidos");
            System.out.println("1. Crea Cabina telefonica");
            System.out.println("2. Escoger cabina(Local, LD, Celular)");
            System.out.println("3. Info x Cabina");
            System.out.println("4. Info total de cabinas");
            System.out.println("5. Reiniciar cabinas");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion");
            int opc = sc.nextInt();

            switch (opc){
                case 1:
                        Telefono.crearCabina();
                    break;
                case 2:
                        Telefono.registrarllamada();
                    break;
                case 3:
                        Telefono.mostrar_detalle_Cabina();
                    break;
                case 4:
                        Telefono.mostrar_consolidado();
                    break;
                case 5:
                        Telefono.reiniciarCabina();
                    break;
                case 6:
                    System.out.println("Saliendo... ");
                    return;
                default:
                    System.out.println("Opcion No valida, por favor escoge una opcion valida");
            }
        }
    }
}