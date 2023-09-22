package POJOS;

public class NombresAleatorios {

	public static String[] generarNombresAleatorios(int cantidad) {
		String[] nombresAleatorios = new String[cantidad];

		String[] nombres = { "Hugo","Mateo","Martín","Lucas","Leo","Daniel","Alejandro","Manuel","Pablo","Álvaro","Adrián",
				"Enzo","Mario","Diego","David","Oliver","Marcos","Thiago","Marco","Álex","Javier","Izan","Bruno","Miguel","Antonio",
				"Gonzalo","Liam","Gael","Marc","Carlos","Juan","Ángel","Dylan","Nicolás","José","Sergio","Gabriel","Luca","Jorge","Darío",
				"Íker","Samuel","Eric","Adam","Héctor","Francisco","Rodrigo","Jesús","Erik","Amir","Jaime","Ian","Rubén","Aarón","Iván","Pau",
				"Víctor","Guillermo","Luis","Mohamed","Pedro","Julen","Unai","Rafael","Santiago","Saúl","Alberto","Noah","Aitor","Joel","Nil",
				"Jan","Pol","Raúl","Matías","Martí","Fernando","Andrés","Rayan","Alonso","Ismael","Asier","Biel","Ander","Aleix","Axel","Alan",
				"Ignacio","Fabio","Neizan","Jon","Teo","Isaac","Arnau","Luka","Max","Imran","Youssef","Anas","Elías","Andrea", "David", "Christian",
				"Cayetano", "Juan Carlos", "Jose", "Joaquin", "Laura", "Luis", "Ignacio", "Marta", "Candelaria", "Maria", "Canela", "Caridad", "Julia", "Nera",
				"Jesus", "Carlota", "Baltazar"};
		String[] apellidos = { "García","Rodríguez","González","Fernández","López","Martínez","Sánchez","Pérez","Gómez","Martín","Jimenez","Hernández","Ruiz",
				"Díaz","Moreno","Muñoz","Álvarez","Romero","Gutiérrez","Alonso","Navarro","Torres","Domínguez","Ramos","Vázquez","Ramírez","Gil","Serrano","Morales",
				"Molina","Blanco","Suárez","Castro","Ortega","Delgado","Ortiz","Marin","Rubio","Nuñez","Medina","Sanz","Castillo","Iglesias","Cortés","Garrido","Santos",
				"Guerrero","Lozano","Cano","Cruz","Méndez","Flores","Prieto","Herrera","Peña","León","Márquez","Cabrera","Gallego","Calvo","Vidal","Campos","Reyes","Vega",
				"Fuentes","Carrasco","Diez","Aguilar","Caballero","Nieto","Santana","Vargas","Pascual","Giménez","Herrero","Hidalgo","Montero","Lorenzo","Santiago","Benitez",
				"Duran","Ibáñez","Arias","Mora","Ferrer","Carmona","Vicente","Rojas","Soto","Crespo","Roman","Pastor","Velasco","Parra","Sáez","Moya","Bravo","Rivera",
				"Gallardo","Soler","Gomez", "Guerrero", "Prado", "Garcia", "Cardona", "Linares", "Gil", "Carrillo", "Guerrero", "Castillo", "Galan", "Vega", "Merino", "Parada",
				"Acosta", "Salgado", "Saenz", "Otero" };

		for (int i = 0; i < cantidad; i++) {
			nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
					+ apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
		}
		return nombresAleatorios;
	}
	
}
