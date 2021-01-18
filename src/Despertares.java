package Practica_0_despertar;

/**
 * - Objetivo:
 * Consolidar el conocimiento de la gestion de hilos aplicando las dos partes estudiadas en clase. 
 * Por un lado la creacion y arranque de hilos y por otro lado espera de hilos.
 * 
 * En este ejercicio se ilustra que un metodo interrupt() no implica que siempre vaya a terminar de ejecutar el hilo, es posible ignorarlo.
 * 
 * - Metodos utilizados: 
 * interrupt(), sleep(), isAlive(), start(), join()
 * 
 */

public class Despertares {
	public static void main(String[] args) throws InterruptedException {
		/* El hijo ignora a la madre 5 veces */
		Thread hijo = new Hijo (5);
		
		/* La madre intenta despertarle 30 veces */
		Thread madre = new Madre(30, hijo); 
		
		madre.start();
		hijo.start();
		
		madre.join();
		hijo.join();
		
	}
}
