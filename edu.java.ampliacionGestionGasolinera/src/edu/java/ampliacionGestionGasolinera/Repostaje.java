package edu.java.ampliacionGestionGasolinera;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Repostaje {
	// CLASE REPOSTAJE
	
	// Atributos
	
	private LocalDate fecha;
	private float litros;
	private float importe;
	private String dni;
	private String matricula;
	
	// Constructores
	
		// Constructor 1: Sin ningún atributo
	public Repostaje() {
		super();
	}

		// Constructor 2: Con todos los atributos/propiedades /// ESTE NO SE VA A UTILIZAR, PERO LO PONGO PARA RECORDAR
	public Repostaje(LocalDate fecha, float litros, float importe, String dni, String matricula) {
		super();
		this.fecha = fecha;
		this.litros = litros;
		this.importe = importe;
		this.dni = dni;
		this.matricula = matricula;
	}
	
	// Getters And Setters
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getLitros() {
		return litros;
	}

	public void setLitros(float litros) {
		this.litros = litros;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	// Método toString
	
	@Override
	public String toString() {
		return "Repostaje [fecha=" + fecha + ", litros=" + litros + ", importe=" + importe + ", dni=" + dni
				+ ", matricula=" + matricula + "]";
	}
	
	// Métodos
	
	/**
	 * REPOSTAJE NORMAL: se guarda la fecha, los litros y el importe.
	 * ENTRADA: Base de datos
	 * DEVUELVE: Un objeto de tipo Repostaje
	 */
	public Repostaje repostajeNormal(List<Repostaje> listaBD) {
		
		// Vamos a pedir al usuario los siguientes valores:
		// la fecha, los litros y el importe.
		// Scanner con los valores del usuario
		Scanner entradaValores = new Scanner(System.in);
		
		// Variables utilizadas
		LocalDate entradaFecha;
		float entradaLitros, entradaImporte, eurosLitroGasolina, totalIVAGasolina;
		
		// Preguntamos la fecha del repostaje
		System.out.println("Introduzca la fecha del respotaje:");
		entradaFecha = LocalDate.parse(entradaValores.next());
		
		// Preguntamos los litros del repostaje
		System.out.println("Introduzca los litros del repostaje:");
		entradaLitros = entradaValores.nextFloat();
		
		// Para calcular el importe
		// Vamos a usar el precio real del disel y le calculamos el iva (21%)
		eurosLitroGasolina = 1.65f;
		entradaImporte = entradaLitros * eurosLitroGasolina;
		// Ahora le calculamos le IVA, una vez calculada se lo sumamos al importe
		totalIVAGasolina = entradaImporte * 0.21f;
		entradaImporte += totalIVAGasolina;
		
		// Devolvemos el objeto de tipo Repostaje creado con los datos
		Repostaje aux = new Repostaje();
		aux.setFecha(entradaFecha);
		aux.setLitros(Math.round(entradaLitros*10.0)/10f);
		aux.setImporte(Math.round(entradaImporte*100.0)/100f);;
		
		// Cerramos la variable Scanner antes de cerrar
		// Si la cerramos da error
		//entradaValores.close();
		return aux;
	}

	/**
	 * REPOSTAJE FACTURA: se guarda la fecha, los litros, el importe, el DNI del cliente y la matrícula del vehículo.
	 */
	public List<Repostaje> repostajeFactura(List<Repostaje> listaBD) {
		
		// Declaramos las variables que vamos a utilizar
		LocalDate entradaFecha;
		float entradaLitros, entradaImporte, eurosLitroGasolina;
		String entradaDNI, entradaMatricula;
		
		// Scanner para preguntar los datos al usuario
		Scanner entradaDatos  = new Scanner(System.in);
		
		// Pedimos los datos
		// Empezamos pidiendo el DNI
		System.out.println("Introduzca su DNI:");
		entradaDNI = entradaDatos.next();
		
		// Pedimos la matrícula ahora
		System.out.println("Introduzca su matrícula del coche:");
		entradaMatricula = entradaDatos.next();
		
		// Pedimos la fecha
		System.out.println("Introduzca la fecha del repostaje:");
		entradaFecha = LocalDate.parse(entradaDatos.next());
		
		// Pedimos el importe a echar de gasolina y después calculamos cuántos litros serían
		System.out.println("Importe para el repostaje:");
		entradaImporte = entradaDatos.nextFloat();
		
		// Calculamos ahora los litros que serían
		eurosLitroGasolina = 1.65f;
		entradaLitros = entradaImporte / eurosLitroGasolina;
		
		// Creamos el objeto de tipo Repostaje para asignarle los valores
		Repostaje aux = new Repostaje();
		aux.setFecha(entradaFecha);
		aux.setLitros(Math.round(entradaLitros*10.0)/10f);
		aux.setImporte(Math.round(entradaImporte*100.0)/100f);
		aux.setDni(entradaDNI);
		aux.setMatricula(entradaMatricula);
		
		// Devolvemos la lista con el nuevo objeto Repostaje
		listaBD.add(aux);
		return listaBD;
	}
	
	/**
	 * Para mostrar todos los repostajes
	 * ENTRADA: Base de datos
	 * DEVUELVE: Todos los repostajes (Normales y Facturas)
	 */
	public void todosRepostajes(List<Repostaje> listaBD) {
		
		// Vamos a mostrar todos los repostajes de la base de datos
		for (Repostaje aux : listaBD) {
			System.out.println("[Fecha Repostaje=" + aux.getFecha() + "; Litros=" + aux.getLitros() + "; Importe=" + aux.getImporte() + 
					"; Dni=\"" + aux.getDni() + "\"; Matricula=\"" + aux.getMatricula() + "\"]");
		}
	}
	
}
