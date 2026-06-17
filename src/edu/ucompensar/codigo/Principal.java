/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucompensar.codigo;

import java.util.Scanner;

/**
 * Sistema de gestión de reservas para restaurante.
 * Permite registrar reservas, consultar disponibilidad,
 * calcular valores y generar reportes de ventas.
 * 
 * @author Cristian Vargas
 * @author Juan Pablo Franco
 */

public class Principal {

    // Para poder usar estas variables en otros metodos se uso el static

    static Scanner sc = new Scanner(System.in);

    static int opcionn;
    static int per;
    static String texto;
    static int rtexto;

    static int menu;
    static String textoo;
    static int mrtexto;

    static int totalReservas = 0;
    static int comensalesMediodia = 0;
    static int comensalesTarde = 0;
    static int comensalesNoche = 0;
    static int totalVentas = 0;

    static int mesas = 7;
    static int turno = 1;

    /**
     * Metodo principal del programa.
     * Muestra el menu e invoca los diferentes metodos.
     *
     * @param args argumentos de linea de comandos
     */
    
    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println("-------BIENVENIDO AL MENU------");
            System.out.println("Opciones:");
            System.out.println("1. Registrar Reserva");
            System.out.println("2. Ver disponibilidad");
            System.out.println("3. Calcular valor");
            System.out.println("4. Ver reporte");
            System.out.println("5. Salir");

            System.out.println("Digite la opcion deseada: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

            case 1:
                registrarReserva();    
            break;

            case 2:
                 mostrarMesas(mesas, turno);     
            break;

            case 3:    
                valorTotal();    
            break;

            case 4:    
                verReporte();   
            break;

            case 5:    
                System.out.println("Hasta pronto :>");
            break;

                default:
                    System.out.println("Opción inválida");
                break;
                
            }

        } while (opcion != 5);
    }

    /**
     * Permite registrar una reserva ingresando:
     * nombre, cantidad de personas, turno y tipo de menu.
     *
     * Tambien incrementa el total de reservas realizadas.
     */
    
    public static void registrarReserva() {

        System.out.println("------Bienvenido al Registro de Reserva------");

        System.out.println("Digite su nombre: ");
        String nombre = sc.nextLine();

        System.out.println("¿Numero de personas en la reserva? ");
        System.out.println("Solo se admiten 4 personas por reserva");
        per = sc.nextInt();
 
        if (per > 4) {
            
            System.out.println("Tendra que registrar otra mesa porfavor ");
            
        } else {
            
            System.out.println("Gracias");
            
        }

        System.out.println("¿Cual es el turno? ");
        System.out.println("----Turnos----");
        System.out.println("1. Mediodia");
        System.out.println("2. Tarde");
        System.out.println("3. Noche");

        opcionn = sc.nextInt();

        switch (opcionn) {

            case 1:
                
                System.out.println("Seria $25.000 por persona");
                
                comensalesMediodia += per;
                totalVentas += 25000 * per;
                
                break;

            case 2:
                
                System.out.println("Seria $30.000 por persona");
                
                comensalesTarde += per;
                totalVentas += 30000 * per;
                
                break;

            case 3:
                
                System.out.println("Seria $45.000 por persona");
                
                comensalesNoche += per;
                totalVentas += 45000 * per;
                
                break;

            default:
                
                System.out.println("Opción inválida");
                
                break;
        }

        System.out.println("¿Que tipo de menu desea? ");
        System.out.println("1. Ejecutivo");
        System.out.println("2. Carta");
        System.out.println("3. Premium");

        menu = sc.nextInt();

        System.out.println("Gracias por realizar su reserva!!!");

        totalReservas++;
    }

    
   /**
   * Muestra las mesas disponibles y asigna el turno correspondiente.
   *
   * @param mesasDisponibles cantidad de mesas disponibles
   * @param turnoActual numero del turno actual
   */
    
   public static void mostrarMesas(int mesasDisponibles, int turnoActual) {

    if (mesasDisponibles > 0) {

        System.out.println("Las mesas disponibles son " + mesasDisponibles);
        System.out.println("Su turno es el " + turnoActual);

        // Actualiza las variables globales originales
        mesas--;
        turno++;

    } else {

        System.out.println("No hay mesas disponibles");
    }
}

    /**
    * Calcula y retorna el valor total de la reserva.
    *
    * @return valor total de la reserva
    */
   
    public static int valorTotal() {

    switch (opcionn) {

        case 1:

            texto = "Mediodia ($25.000/persona)";
            rtexto = 25000 * per;

            break;

        case 2:

            texto = "Tarde ($30.000/persona)";
            rtexto = 30000 * per;

            break;

        case 3:

            texto = "Noche ($45.000/persona)";
            rtexto = 45000 * per;

            break;
    }

    switch (menu) {

        case 1:

            textoo = "Ejecutivo (-10%)";
            mrtexto = rtexto - ((rtexto * 10) / 100);

            break;

        case 2:

            textoo = "Carta (precio base)";
            mrtexto = rtexto;

            break;

        case 3:

            textoo = "Premium (+25%)";
            mrtexto = rtexto + ((rtexto * 25) / 100);

            break;
    }

    System.out.println("----Valor de reserva----");

    System.out.println("De acuerdo al turno " + texto);
    System.out.println("Y el menu seleccionado " + textoo);

    System.out.println("El valor total es: " + mrtexto);

    return mrtexto;
}

    /**
     * Genera un reporte con:
     * total de reservas,
     * total de comensales por turno
     * y total esperado en ventas.
     */
    
    public static void verReporte() {

    System.out.println("----- REPORTE -----");
    System.out.println("Total reservas: " + totalReservas);
    System.out.println("Comensales Mediodia: " + comensalesMediodia);
    System.out.println("Comensales Tarde: " + comensalesTarde);
    System.out.println("Comensales Noche: " + comensalesNoche);
    System.out.println("Ingresos totales del dia $" + totalVentas);
        
    }
}
              
              
              
     



