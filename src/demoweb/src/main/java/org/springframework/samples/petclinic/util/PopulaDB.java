package org.springframework.samples.petclinic.util;

import java.util.Random;

public class PopulaDB {
	public static void main(String[] args) {
		StringBuilder sqlsInserts = new StringBuilder("");
		int idVets = 7;
		int idOwner = 11;
		int idPet = 14;
		
		Random randomVeterinario = new Random();
		
		Random randomPets = new Random();

		for (int i = 0; i < 300; i++) {
			sqlsInserts.append("INSERT INTO vets VALUES (" + idVets
					+ ", 'Veterinário " + i + " ', 'Silva " + idVets + "');\n");
			sqlsInserts.append("INSERT INTO vet_specialties VALUES (" + idVets
					+ ", " + (randomVeterinario.nextInt((3 - 1) + 1) + 1) + ");\n");
			idVets += 1;

			sqlsInserts
					.append("INSERT INTO owners VALUES ("
							+ idOwner
							+ ", 'Dono "
							+ idOwner
							+ "', 'Estaban', '2335 Independence La.', 'Waunakee', '60855554"
							+ i + "');\n");

			sqlsInserts.append("INSERT INTO pets VALUES (" + idPet
					+ ", 'nome "+ i +"', '2010-09-07', " + (randomPets.nextInt((6-1) + 1) + 1)
					+ ", " + idOwner + ");\n");

			idOwner += 1;
			idPet += 1;

		}
		System.out.println(sqlsInserts.toString());
	}
}
