package com.ldn.regates.utlis;

import java.util.Scanner;

import com.ldn.regates.Personne;
import com.ldn.regates.dao.veutContinuer2;

public class Email {

	public static String mailing(){
		String eMail;
		
		do {
			Scanner eMailKeyb = new Scanner(System.in);
			System.out.println("Saissisez votre courriel:");
			eMail = eMailKeyb.nextLine();
//			eMailKeyb.close();

			// Vérification des contraints adresse mail.
				// La @ doit se retrouver au moins à 2 places du premier char
//			String addmail = "lik@fikerinopertinence.com";
		String recherche = "@";
		int position;
		position = eMail.indexOf(recherche);
			// Le point doit se retrouver au moins à 2 places de la @.
		if (position > 1) {
			String recherche1 = ".";
			int position2;
			position2 = eMail.lastIndexOf(recherche1);
				// Il doit y avoir au moins deux chars après le point
			if (position2 > (position + 2)) {
				int len = eMail.length();
				char lastChar = eMail.charAt(len -1);
				int lastIndex = eMail.lastIndexOf(lastChar);				
				if (lastIndex > (position2 + 1)) {
					System.out.println(eMail);
				}
				else {
					System.out.println("Error: Extension non valable");
				}	
			}
			else {
				System.out.println("Error: Il doit y avoir au moins deux caractères entre @ et le point");
			}
		}
		else {
			System.out.println("Error: Il doit y avoir au moins deux caractères avant @");
		}
		}
		while (veutContinuer2.vC());
		
		return (eMail);
	}
}
