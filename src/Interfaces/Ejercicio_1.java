package Interfaces;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ejercicio_1 {


    static Scanner sc = new Scanner(System.in);
    static int dia;
    static int mes;
    static int anio;

    static LocalDate fecha;
    static LocalDate fechaMaxima = LocalDate.of(2050, 12, 31);
    static LocalDate fechaMinima = LocalDate.of(1900, 1, 1);




    public static void main(String[] args) {


        leer();

        validar();



        mostrarCorta();
        bisiesto();
        diasMes();
        diasTranscurridos();
        diaSemana();
        mostrarLarga();
        fechaTras();
        siguiente();
    }

    private static void leer() {
        System.out.println("Introduce una fecha entre el 1-1-1900 y el 31-12-2050");

        System.out.println("Introduce el año");
        while (!sc.hasNextInt()){
            System.out.println("Introduce un valor válido");
            sc.next();
        }

        anio = sc.nextInt();

        System.out.println("Introduce el mes");
        while (!sc.hasNextInt()){
            System.out.println("Introduce un valor válido");
            sc.next();
        }

        mes = sc.nextInt();

        System.out.println("Introduce el dia");
        while (!sc.hasNextInt()){
            System.out.println("Introduce un valor válido");
            sc.next();
        }
        dia = sc.nextInt();


    }



    private static void validar() {

        if (anio > 0){
            if (mes < 0 ) mes = 1;
            if (mes > 12 ) mes = 12;
            fecha = LocalDate.of(anio, mes, 1);
            if (dia > fecha.lengthOfMonth()) dia = fecha.lengthOfMonth();
            if (dia < 0) dia = 1;
            fecha = LocalDate.of(anio, mes, dia);
        }
        if (fecha.isAfter(fechaMaxima)) fecha = fechaMaxima;
        if (fecha.isBefore(fechaMinima)) fecha = fechaMinima;
        System.out.println("\nFecha validada, la fecha ahora es " + fecha.toString());
    }

    private static void mostrarCorta() {

        System.out.println("\nFecha en formato corto " + fecha.getDayOfMonth() + "-" + fecha.getMonth() + "-" + fecha.getYear());

    }

    private static void bisiesto() {
        System.out.println();
        if (fecha.lengthOfYear() == 365) System.out.println("El año " + fecha.getYear() + " es no bisiesto");
        if (fecha.lengthOfYear() == 366) System.out.println("El año " + fecha.getYear() + " es año bisiesto");
    }

    private static void diasMes() {

        System.out.println("\nEl mes tiene " + fecha.lengthOfMonth() + " días");
    }

    private static void diasTranscurridos() {

        System.out.println("Han transcurrido " + ChronoUnit.DAYS.between(fechaMinima, fecha)+ " desde 1900 a tu fecha introducida");

    }

    private static void diaSemana() {

        System.out.println("El día de la semana es " + fecha.getDayOfWeek());
    }

    private static void mostrarLarga() {



        System.out.println(fecha.getDayOfWeek() + ", " + fecha.getDayOfMonth() + " de " + fecha.getMonth() + " de " + fecha.getYear());
    }

    private static void fechaTras() {
        System.out.println("\n ¿Cuantos días quieres sumar a 1-1-1900?");

        while (!sc.hasNextInt()){
            System.out.println("Introduce un valor válido");
            sc.next();
        }
        int dias = sc.nextInt();
        System.out.println("La nueva fecha es: " + fechaMinima.plusDays(dias));
    }

    private static void siguiente() {
        System.out.println("Tu fecha más un día es " + fecha.plusDays(1));
    }


}
