package com.ldn.regates.model;

import java.util.Scanner;

public class Commisaire extends Personne {
	private String comite;

	public Commisaire(String nomPers, String prenPers, String eMail, String comite) {
		super(nomPers, prenPers, eMail);
		this.comite = comite;
	}
	
	public static String comiteNom() {
		String comite;
		
		Scanner comiKeyb = new Scanner(System.in);
		System.out.println("Saisissez le nom de votre comité:");
		comite = comiKeyb.nextLine();
//		persoInfo.add(comite);
		System.out.println(comite);

		
		return comite;		
	}

	public String getComite() {
		return comite;
	}

	public void setComite(String comite) {
		this.comite = comite;
	}

}
