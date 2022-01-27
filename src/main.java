import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);


		System.out.println("Bienvenido al juego de las canicas");
		//Declaración de variables 

		int eleccion = 0;

		int canicasJUno = 10;
		int canicasJDos = 10;

		int guardarJUno = 0;
		int apuestaJUno = 0;

		String parimparUsuario =  "";
		int parImparCPU = 0;


		int guardarJDos = 0;
		int apuestaJDos = 0;



		boolean finPartida = false;

		//----------IA------------------

		int canicasCPU = 10;
		int guardarCPU = 0;
		int apuestaCPU = 0;



		do {
			//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
			try {
				System.out.println("Seleccione modo de juego (1) Contra la CPU || (2) 2 Jugadores");
				eleccion = teclado.nextInt();

			}catch(Exception e) {
				System.out.println("No has introducido un numero");
				teclado.next();	
			}

			//Hacemos control de errores para que no pueda meter numeros fuera del rango
		}while(eleccion >= 3 || eleccion <= 0);

		if(eleccion == 2) {
			//PRIMER TURNO---------------------------------------------

			//le decimos que ejecute las instrucciones
			do {

				do {
					//Entrara en el if si la booleana sigue dando false, si no, será fin de partida en la funcion
					if(finPartida == false) {

						do {
							//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
							try {
								System.out.println("Jugador1: ¿Cuántas canicas quieres guardar?");
								guardarJUno = teclado.nextInt();

							}catch(Exception e) {
								System.out.println("No has introducido un numero");
								teclado.next();	
							}

							//Hacemos control de errores para que no pueda meter numeros fuera del rango
						}while(guardarJUno > canicasJUno || guardarJUno <= 0);

						do {
							//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
							try {
								System.out.println("Jugador2: ¿Apuesta el número de canicas?");
								apuestaJDos = teclado.nextInt();

							}catch(Exception e) {
								System.out.println("No has introducido un numero");
								teclado.next();	
							}

							//Hacemos control de errores para que no pueda meter numeros fuera del rango
						}while(apuestaJDos > canicasJDos || apuestaJDos <= 0);

						do {

							//pedimos al usuario que nos diga si es un numero par o impar
							System.out.println("Jugador2: ¿El número de canicas que ha apostado el jugador1 es par o impar?");
							parimparUsuario = teclado.next();

							//miramos que el usuario lo introduzca en minusculas
							parimparUsuario = parimparUsuario.toLowerCase();


							//se repetira hasta que se cumpla una de las condiciones
						}while(parimparUsuario.equals("impar") && parimparUsuario.equals("par"));

						//si acierta que es par
						if (guardarJUno % 2 == 0 && parimparUsuario.equals("par")) {

							canicasJUno = canicasJUno - guardarJUno;
							canicasJDos = canicasJDos + guardarJUno;

							//si acierta que es impar
						}else if (guardarJUno % 2 != 0 && parimparUsuario.equals("impar")) {

							canicasJUno = canicasJUno - guardarJUno;
							canicasJDos = canicasJDos + guardarJUno;

						}
						//si se equivoca y falla
						else {
							canicasJUno = canicasJUno + apuestaJDos;
							canicasJDos = canicasJDos - apuestaJDos;
						}


						//mostramos cuantas canicas le quedan a cada uno
						System.out.println("Jugador1 tienes " + canicasJUno + " canicas.");
						System.out.println("Jugador2 tienes " + canicasJDos + " canicas.");


						finPartida = finDePrograma (canicasJUno, canicasJDos);
					}

				}while(finPartida == true);

				//---------------------------------------------------------------------------------------------------------		

				//SEGUNDO TURNO----------------------------------------------


				do {
					//mientras no gane ninguno de los dos, entraará en este if
					if(finPartida == false) {


						do {
							//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
							try {
								System.out.println("Jugador2: ¿Cuántas canicas quieres guardar?");
								guardarJDos = teclado.nextInt();

							}catch(Exception e) {
								System.out.println("No has introducido un numero");
								teclado.next();	
							}

							//Hacemos control de errores para que no pueda meter numeros fuera del rango
						}while(guardarJDos > canicasJDos || guardarJDos <= 0);

						do {
							//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
							try {
								System.out.println("Jugador1: ¿Apuesta el número de canicas?");
								apuestaJUno = teclado.nextInt();

							}catch(Exception e) {
								System.out.println("No has introducido un numero");
								teclado.next();	
							}

							//Hacemos control de errores para que no pueda meter numeros fuera del rango
						}while(apuestaJUno > canicasJUno || apuestaJUno <= 0);

						do {

							//pedimos al usuario que nos diga si es un numero par o impar
							System.out.println("Jugador1: ¿El número de canicas que ha apostado el jugador2 es par o impar?");
							parimparUsuario = teclado.next();

							parimparUsuario = parimparUsuario.toLowerCase();





							//se repetira hasta que se cumpla una de las condiciones
						}while(parimparUsuario.equals("impar") && parimparUsuario.equals("par"));



						//si acierta que es par
						if (guardarJDos % 2 == 0 && parimparUsuario.equals("par")) {

							canicasJUno = canicasJUno + guardarJDos;
							canicasJDos = canicasJDos - guardarJDos;

							//si acierta que es impar
						}else if (guardarJDos % 2 != 0 && parimparUsuario.equals("impar")) {

							canicasJUno = canicasJUno + guardarJDos;
							canicasJDos = canicasJDos - guardarJDos;

						}
						//si se equivoca y falla
						else {
							canicasJUno = canicasJUno + apuestaJUno;
							canicasJDos = canicasJDos - apuestaJUno;
						}


						//mostramos cuantas canicas le quedan a cada uno
						System.out.println("Jugador1 tienes " + canicasJUno + " canicas.");
						System.out.println("Jugador2 tienes " + canicasJDos + " canicas.");

						finPartida = finDePrograma (canicasJUno, canicasJDos);

					}

				}while(finPartida == true);

				//mientras que la instruccion sea distinto de true, va a buclear

				
			}while(finPartida != true);

		}


		if(eleccion == 1) {
			//PRIMER TURNO---------------------------------------------

			//le decimos que ejecute las instrucciones
			do {

				//Entrara en el if si la booleana sigue dando false, si no, será fin de partida en la funcion
				if(finPartida == false) {
					do {
						//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
						try {
							System.out.println("Jugador1: ¿Cuántas canicas quieres guardar?");
							guardarJUno = teclado.nextInt();

						}catch(Exception e) {
							System.out.println("No has introducido un numero");
							teclado.next();	
						}

						//Hacemos control de errores para que no pueda meter numeros fuera del rango
					}while(guardarJUno > canicasJUno || guardarJUno <= 0);

					//apuesta de la CPU
					apuestaCPU = (int)(Math.random()*(canicasCPU-1+1)+1); 

					//le decimos al usuario lo que ha apostado la CPU
					System.out.println("La CPU ha apostado " + apuestaCPU + " canicas");


					parImparCPU = (int)(Math.random()*(2-1+1)+1);

					if(parImparCPU == 1) {
						System.out.println("La CPU ha escogido IMPAR");

					}

					if(parImparCPU == 2) {
						System.out.println("La CPU ha escogido PAR");

					}


					//si acierta que es par
					if (guardarJUno % 2 == 0 && parImparCPU == 2) {

						canicasJUno = canicasJUno - guardarJUno;
						canicasCPU = canicasCPU + guardarJUno;

						//si acierta que es impar
					}else if (guardarJUno % 2 != 0 && parImparCPU == 1) {

						canicasJUno = canicasJUno - guardarJUno;
						canicasCPU = canicasCPU + guardarJUno;

					}
					//si se equivoca y falla
					else {
						canicasJUno = canicasJUno + apuestaCPU;
						canicasCPU = canicasCPU - apuestaCPU;
					}


					//mostramos cuantas canicas le quedan a cada uno
					System.out.println("Jugador1 tienes " + canicasJUno + " canicas.");
					System.out.println("CPU tiene " + canicasCPU + " canicas.");


					finPartida = finDeProgramaCPU (canicasJUno, canicasCPU);
				}


				//---------------------------------------------------------------------------------------------------------		

				//SEGUNDO TURNO----------------------------------------------



				//mientras no gane ninguno de los dos, entraará en este if
				if(finPartida == false) {


					guardarCPU = (int)(Math.random()*(canicasCPU-1+1)+1); 
					System.out.println("La CPU ha guardado canicas");



					do {
						//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
						try {
							System.out.println("Jugador1: ¿Apuesta el número de canicas?");
							apuestaJUno = teclado.nextInt();

						}catch(Exception e) {
							System.out.println("No has introducido un numero");
							teclado.next();	
						}

						//Hacemos control de errores para que no pueda meter numeros fuera del rango
					}while(apuestaJUno > canicasJUno || apuestaJUno <= 0);

					do {

						//pedimos al usuario que nos diga si es un numero par o impar
						System.out.println("Jugador1: ¿El número de canicas que ha apostado la CPU es par o impar?");
						parimparUsuario = teclado.next();

						parimparUsuario = parimparUsuario.toLowerCase();


						//se repetira hasta que se cumpla una de las condiciones
					}while(parimparUsuario.equals("impar") && parimparUsuario.equals("par"));



					//si acierta que es par
					if (guardarCPU % 2 == 0 && parimparUsuario.equals("par")) {

						canicasJUno = canicasJUno + guardarCPU;
						canicasCPU = canicasCPU - guardarCPU;

						//si acierta que es impar
					}else if (guardarCPU % 2 != 0 && parimparUsuario.equals("impar")) {

						canicasJUno = canicasJUno + guardarCPU;
						canicasCPU = canicasCPU - guardarCPU;

					}
					//si se equivoca y falla
					else {
						canicasJUno = canicasJUno + apuestaJUno;
						canicasCPU = canicasCPU - apuestaJUno;
					}


					//mostramos cuantas canicas le quedan a cada uno
					System.out.println("Jugador1 tienes " + canicasJUno + " canicas.");
					System.out.println("La CPU tiene " + canicasCPU + " canicas.");

					finPartida = finDeProgramaCPU (canicasJUno, canicasCPU);

				}



				//mientras que la instruccion sea distinto de true, va a buclear
			}while(finPartida != true);
		}


	}

	private static boolean finDePrograma (int canicasJUno, int canicasJDos) {

		boolean partida = false;

		//condicion para si gana el jugador1
		if(canicasJUno == 20) {

			partida = true;	

			System.out.print("El Jugador2 ha perdido.\r\n"
					+ "¡¡¡Felicidades jugador1!!!\r\n");


		}
		//condicion para si gana el jugador2
		else if(canicasJDos == 20) {

			partida = true;	

			System.out.print("El Jugador1 ha perdido.\r\n"
					+ "¡¡¡Felicidades jugador2!!!\r\n");

			//si no, se devulve false
		}else {
			partida = false;
		}

		return partida;

	}

	private static boolean finDeProgramaCPU (int canicasJUno, int canicasCPU) {

		boolean partida = false;

		//condicion para si gana el jugador1
		if(canicasJUno == 20) {

			partida = true;	

			System.out.print("La CPU ha perdido\r\n"
					+ "¡¡¡Felicidades jugador1!!!\r\n");


		}
		//condicion para si gana la CPU
		else if(canicasCPU == 20) {

			partida = true;	

			System.out.print("El Jugador1 ha perdido.\r\n"
					+ "¡¡¡TE HA GANADO LA CPU!!!\r\n");

			//si no, se devulve false
		}else {
			partida = false;
		}

		return partida;

	}

}



