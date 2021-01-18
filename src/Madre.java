package Practica_0_despertar;

class Madre extends Thread {
	/* Numero de intentos de despertar al hijo */
	private int intentos;
	
	/* Thread que representa al hijo */
	private Thread hijo;

	private Thread thread; 
	
	/** Crea a la madre 
	 * @param int intentos
	 * @param Thread hijo
	 */
	public Madre(int intentos, Thread hijo) {
		this.intentos = intentos;
		this.hijo = hijo;
	}

	public void run() {
		//contador de intentos
		System.out.println("MADRE: Voy a despertar al chaval que tiene que estudiar PS");
		//creo un bucle que hará 30 iteraciones para intentar despertar al hijo
		for(int i = 1;i < intentos+1;i++) {
			/*como queremos que la madre sólo le llame 5 veces y que cuando sea la sexta el chaval se despierte,
			establecemos la condición de que solo se repita esto durante 6 intentos*/
			if(i < 7){
				System.out.println("\nMADRE: Voy a intentarlo por " + i + " vez...");
				//si el hilo hijo sigue en proceso, dirá que luego vuelve a mirar y duerme el hilo 5 segundos
				if(hijo.isAlive()) {
					System.out.println("MADRE: No se si se ha despertado, ahora vuelvo a mirar...");
					try {
						Madre.sleep(4500);
					}catch (InterruptedException e) {
						//como el hilo de la madre nunca se interrumpe, este print no se mostrará nunca por consola
						System.out.println("No deberia interrumpirse a una madre!");
						e.printStackTrace();
					}
				}
			}else {
				/*cuando se haya iterado 6 veces, quiere decir que el hijo se despertará por lo que interrumpo el hilo del
				hijo para salir del bucle for*/
				hijo.interrupt();
			}
		}
		System.out.println("MADRE: Ya se ha despertado!!!");
	}
}

