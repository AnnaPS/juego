/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomates;

import javax.swing.JOptionPane;

/**
 *
 * @author Anna
 */
public class Juego {

    private int contador, segundosParaJugar, cantidadOperaciones, num1, num2, resultadoJugador, resultadoBien;
    private long horaDeComienzo, horaActual, tiempoTranscurrido;
    private String tipoDeOperacion, menu;

    public Juego() {
        menu();
    }

    void saberSiEsPositivo() {

        segundosParaJugar = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique el tiempo (en segundos) que va a durar el juego: "));

        while (segundosParaJugar <= 0) {
            JOptionPane.showMessageDialog(null, "El número es negativo");
            segundosParaJugar = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique el tiempo (en segundos) que va a durar el juego: "));

        }

        cantidadOperaciones = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique la cantidad de operciones a realizar: "));
        while (cantidadOperaciones <= 0) {
            JOptionPane.showMessageDialog(null, "El número es negativo");

            cantidadOperaciones = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique la cantidad de operciones a realizar: "));
        }

    }

    void menu() {

        do {
            menu = JOptionPane.showInputDialog("Menu\n+ Suma\n- Resta\n/ Division\n* Multiplicacion. \n0 Salir");

            switch (menu) {
                case "+":
                    JOptionPane.showMessageDialog(null, "Las operaciones seran de suma");
                    tipoDeOperacion = menu;
                    saberSiEsPositivo();
                    suma();
                    break;
                case "-":
                    JOptionPane.showMessageDialog(null, "Las operaciones seran de resta");
                    tipoDeOperacion = menu;
                    saberSiEsPositivo();
                    resta();
                    break;
                case "/":
                    JOptionPane.showMessageDialog(null, "Las operaciones seran de division");
                    tipoDeOperacion = menu;
                    saberSiEsPositivo();
                    division();
                    break;
                case "*":
                    JOptionPane.showMessageDialog(null, "Las operaciones seran de multiplicacion");
                    tipoDeOperacion = menu;
                    saberSiEsPositivo();
                    multiplicar();
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo....");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "El caracter introducido no es valido , debes introducir los siguientes caracteres: + - * / ");

            }

        } while (!"*".equals(menu) || !"+".equals(menu) || !"-".equals(menu) || !"/".equals(menu));

    }

    int comprobarResultado() {
        switch (tipoDeOperacion) {
            case "+":
                resultadoBien = num1 + num2;
                break;
            case "-":
                resultadoBien = num1 - num2;
                break;
            case "/":
                resultadoBien = num1 / num2;
                break;
            case "*":
                resultadoBien = num1 * num2;
                break;

        }
        return resultadoBien;
    }

    void suma() {

        horaDeComienzo = System.currentTimeMillis() / 1000;

        do {

            num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el primer numero: "));

            num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el segundo numero: "));

            resultadoJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "¿ Cuanto es " + num1 + " + " + num2 + " ?"));
            horaActual = System.currentTimeMillis() / 1000;
            tiempoTranscurrido = (horaActual - horaDeComienzo);
            long tiempoRestante = (segundosParaJugar - tiempoTranscurrido);
            if (resultadoJugador == this.comprobarResultado()) {
                contador++;
                cantidadOperaciones--;
                System.out.println(Colores.VERDE + "Bien!! Tu respuesta es correcta. LLevas " + contador + " respuestas correctas");

            } else {
                System.out.println(Colores.ROJO + "NO ES CORRECTA, EL RESULTADO SERÍA " + resultadoBien);

            }
            if (tiempoTranscurrido < segundosParaJugar) {
                System.out.println(Colores.MORADO + "TE QUEDAN " + tiempoRestante + " segundos.");
                System.out.println(Colores.MORADO + "TE QUEDAN " + cantidadOperaciones + " respuestas restantes.");
                if (cantidadOperaciones == 0) {
                    segundosParaJugar = 0;
                    System.out.println(Colores.VERDE + "HAS GANADO");
                }

            } else {
                System.out.println(Colores.VERDE + "Te quedaban " + cantidadOperaciones + " preguntas por responder");
                cantidadOperaciones = 0;
                System.out.println(Colores.ROJO + "El tiempo se acabó!");

            }

        } while (tiempoTranscurrido < segundosParaJugar || cantidadOperaciones != 0);

    }

    void resta() {

        horaDeComienzo = System.currentTimeMillis() / 1000;

        do {

            num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el primer numero: "));

            num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el segundo numero: "));

            resultadoJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "¿ Cuanto es " + num1 + " - " + num2 + " ?"));
            horaActual = System.currentTimeMillis() / 1000;
            tiempoTranscurrido = (horaActual - horaDeComienzo);
            long tiempoRestante = (segundosParaJugar - tiempoTranscurrido);
            if (resultadoJugador == this.comprobarResultado()) {
                contador++;
                cantidadOperaciones--;
                System.out.println(Colores.VERDE + "Bien!! Tu respuesta es correcta. LLevas " + contador + " respuestas correctas");

            } else {
                System.out.println(Colores.ROJO + "NO ES CORRECTA, EL RESULTADO SERÍA " + resultadoBien);

            }
            if (tiempoTranscurrido < segundosParaJugar) {
                System.out.println(Colores.MORADO + "TE QUEDAN " + tiempoRestante + " segundos.");
                System.out.println(Colores.MORADO + "TE QUEDAN " + cantidadOperaciones + " respuestas restantes.");
                if (cantidadOperaciones == 0) {
                    segundosParaJugar = 0;
                    System.out.println(Colores.VERDE + "HAS GANADO");
                }
            } else {
                System.out.println(Colores.VERDE + "Te quedaban " + cantidadOperaciones + " preguntas por responder");
                cantidadOperaciones = 0;
                System.out.println(Colores.ROJO + "Fuera de tiempo");
            }

        } while (tiempoTranscurrido < segundosParaJugar || cantidadOperaciones != 0);

    }

    void multiplicar() {

        horaDeComienzo = System.currentTimeMillis() / 1000;

        do {

            num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el primer numero: "));

            num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el segundo numero: "));

            resultadoJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "¿ Cuanto es " + num1 + " * " + num2 + " ?"));
            horaActual = System.currentTimeMillis() / 1000;
            tiempoTranscurrido = (horaActual - horaDeComienzo);
            long tiempoRestante = (segundosParaJugar - tiempoTranscurrido);
            if (resultadoJugador == this.comprobarResultado()) {
                contador++;
                cantidadOperaciones--;
                System.out.println(Colores.VERDE + "Bien!! Tu respuesta es correcta. LLevas " + contador + " respuestas correctas");

            } else {
                System.out.println(Colores.ROJO + "NO ES CORRECTA, EL RESULTADO SERÍA " + resultadoBien);

            }
            if (tiempoTranscurrido < segundosParaJugar) {
                System.out.println(Colores.MORADO + "TE QUEDAN " + tiempoRestante + " segundos.");
                System.out.println(Colores.MORADO + "TE QUEDAN " + cantidadOperaciones + " respuestas restantes.");
                if (cantidadOperaciones == 0) {
                    segundosParaJugar = 0;
                    System.out.println(Colores.VERDE + "HAS GANADO");
                }
            } else {
                System.out.println(Colores.VERDE + "Te quedaban " + cantidadOperaciones + " preguntas por responder");
                cantidadOperaciones = 0;
                System.out.println(Colores.ROJO + "Fuera de tiempo");
            }

        } while (tiempoTranscurrido < segundosParaJugar || cantidadOperaciones != 0);

    }

    void division() {

        horaDeComienzo = System.currentTimeMillis() / 1000;

        do {

            num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el primer numero: "));

            num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el segundo numero: "));

            resultadoJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "¿ Cuanto es " + num1 + "/" + num2 + " ?"));
            horaActual = System.currentTimeMillis() / 1000;
            tiempoTranscurrido = (horaActual - horaDeComienzo);
            long tiempoRestante = (segundosParaJugar - tiempoTranscurrido);
            if (resultadoJugador == this.comprobarResultado()) {
                contador++;
                cantidadOperaciones--;
                System.out.println(Colores.VERDE + "Bien!! Tu respuesta es correcta. LLevas " + contador + " respuestas correctas");

            } else {
                System.out.println(Colores.ROJO + "NO ES CORRECTA, EL RESULTADO SERÍA " + resultadoBien);

            }
            if (tiempoTranscurrido < segundosParaJugar) {
                System.out.println(Colores.MORADO + "TE QUEDAN " + tiempoRestante + " segundos.");
                System.out.println(Colores.MORADO + "TE QUEDAN " + cantidadOperaciones + " respuestas restantes.");
                if (cantidadOperaciones == 0) {
                    segundosParaJugar = 0;
                    System.out.println(Colores.VERDE + "HAS GANADO");
                }
            } else {
                System.out.println(Colores.VERDE + "Te quedaban " + cantidadOperaciones + " preguntas por responder");
                cantidadOperaciones = 0;
                System.out.println(Colores.ROJO + "Fuera de tiempo");
            }

        } while (tiempoTranscurrido < segundosParaJugar || cantidadOperaciones != 0);

    }
}
