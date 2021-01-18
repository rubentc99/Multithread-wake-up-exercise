package Practica_0_despertar;

class Hijo extends Thread {
	/* Numero de veces que ignorare a quien me despierte */
	private int despertares;

	/** Crea al hijo 
	 * @param int despertares
	 */
	public Hijo(int despertares) {
		this.despertares = despertares;
	}

	public void run() {
		//creo un bucle del numero de veces que tardará el hijo en despertarse
		//(realmente no sé por qué empieza en 1 y tengo que poner despertares+1, pero si lo pongo con 0 y despertares, no me funciona)
		for(int i = 1; i < despertares+1; i++) {
			System.out.println("HIJO: Joe, me despiertan...");
			//establezco esta condición porque queremos que el hijo solo duerma 4 veces y que a la 5a se despierte
			if(i < 5) {
				System.out.println("HIJO: Paso de mi madre, voy a seguir durmiendo 5 seg mas");
				try {
					Hijo.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("HIJO: Me voy a levantar que soy un tio responsable (estudiando...)");
	}
}
