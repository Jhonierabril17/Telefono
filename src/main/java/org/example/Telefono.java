package org.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Telefono {
    private String id;
    private static List<Telefono> cabinas = new ArrayList<>();
    private static List<Telefono.Llamada> llamadas = new ArrayList<>();
    private static Random random = new Random();
    private static Scanner sc = new Scanner(System.in);

    public Telefono(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class Llamada {
        String idCabina;
        String Tipo;
        int Duracion;
        int Costo;

        public Llamada(String idCabina, String tipo, int duracion, int costo) {
            this.idCabina = idCabina;
            Tipo = tipo;
            Duracion = duracion;
            Costo = costo;
        }
    }

    public static void crearCabina() {
        System.out.println("Ingrese el ID de la cabina");
        String id = sc.next();

        for (Telefono cabina : cabinas) {
            if (cabina.getId().equals(id)) {
                System.out.println("La cabina ya existe");
                return;
            }
        }
        cabinas.add(new Telefono(id));
        System.out.println("Cabina " + id + " Creada");
    }

    public static void registrarllamada() {
        System.out.println("Ingresar el Id de la Cabina");
        String id = sc.next();
        boolean existe = false;
        for (Telefono cabina : cabinas) {
            if (cabina.getId().equals(id)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("La cabina no existe");
            return;
        }

        System.out.println("Ingrese el tipo de llamada (Local, LD, Celular)");
        String tipo = sc.next();
        int duracion = random.nextInt(60) + 1;

        // -> conector utilizado para el Switch Se llama
        // switch con expresión de flecha y se introdujo para hacer el código más limpio y seguro.
        int costoPorMinuto = switch (tipo) {
            case "Local" -> 50;
            case "LD" -> 350;
            case "Celular" -> 150;
            default -> {
                System.out.println("Tipo de llamada no válido.");
                yield 0; // Devuelve un valor
            }
        };

        if (costoPorMinuto > 0) {
            int costoTotal = costoPorMinuto * duracion;
            llamadas.add(new Llamada(id, tipo, duracion, costoTotal));
            System.out.println("📞 Llamada registrada.");
            System.out.println(" - Tipo: " + tipo);
            System.out.println(" - Duración: " + duracion + " minutos");
            System.out.println(" - Costo: $" + costoTotal + " pesos");
        }
    }

    public static void mostrar_detalle_Cabina() {
        System.out.println("Ingrese el Id de la cabina");
        String id = sc.next();

        boolean existe = false;
        for (Telefono cabina : cabinas) {
            if (cabina.getId().equals(id)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("La cabina no existe.");
            return;
        }

        int TotalLlamadas = 0;
        int TotalDuracion = 0;
        int TotalCosto = 0;

        for (Llamada llamada : llamadas) {
            if (llamada.idCabina.equals(id)) {
                TotalLlamadas++;
                TotalDuracion += llamada.Duracion;
                TotalCosto += llamada.Costo;
            }
        }
        System.out.println("📞 Cabina: " + id);
        System.out.println("Total de llamadas: " + TotalLlamadas);
        System.out.println("Total Duracion de llamdas: " + TotalDuracion);
        System.out.println("Total costos: " + TotalCosto);
    }

    public static void mostrar_consolidado() {
        int totalllamadas = llamadas.size();
        int totalDuracion = 0;
        int totalCosto = 0;

        for (Llamada llamada : llamadas) {
            totalDuracion += llamada.Duracion;
            totalCosto += llamada.Costo;
        }

        System.out.println(" Consolidado General");
        System.out.println(" - Total de llamadas: " + totalllamadas);
        System.out.println(" - Total Duracion: " + totalDuracion);
        System.out.println("- Costo Total: " + totalCosto);
    }

    public static void reiniciarCabina(){
        System.out.println("Ingrese el Id de la cabina");
        String id = sc.next();

        boolean existe = false;
        for (Telefono cabina : cabinas) {
            if (cabina.getId().equals(id)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("La cabina no existe.");
            return;
        }
        //removeIf elimina elementos de una lista si cumplen con una condición.
        llamadas.removeIf(llamada -> llamada.idCabina.equals(id));
        System.out.println("Cabina " + id + " reiniciada.");
    }
}
