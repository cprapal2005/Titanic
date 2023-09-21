package POJOS;

public class NombresAleatorios {

	public static String[] generarNombresAleatorios(int cantidad) {
		String[] nombresAleatorios = new String[cantidad];

		String[] nombres = { "Andrea", "David", "Christian", "Cayetano", "Juan Carlos", "Jose", "Joaquin", "Laura",
				"Luis", "Ignacio", "Marta", "Candelaria", "Maria", "Canela", "Caridad", "Julia", "Nera",
				"Jesus", "Carlota", "Baltazar"};
		String[] apellidos = { "Gomez", "Guerrero", "Prado", "Garcia", "Cardona", "Linares", "Gil", "Carrillo",
				"Guerrero", "Castillo", "Galan", "Vega", "Merino", "Parada", "Acosta", "Salgado", "Saenz",
				"Otero" };

		for (int i = 0; i < cantidad; i++) {
			nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
					+ apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
		}
		return nombresAleatorios;
	}
	
}
