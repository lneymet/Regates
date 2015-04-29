package com.ldn.regates.utlis;

import java.util.Date;

public class Affichage {

	public static void affichePersonne(String nom, String prenom, String mail){
		System.out.println("Personne: \nNom: "+nom+", Prénom: "+prenom+", Courriel: "+mail);
		System.out.println();
	}
	
	public static void afficheProprietaire(String tel, String adresse){
		System.out.println("Propriétaire: \nNo de téléphone: "+tel+", Adresse: "+adresse);
		System.out.println();
	}
	
	public static void afficheLicencie(int numLic, double points, double addpoints, Date naiss, String age, int anLic){
		StringBuilder licNum = new StringBuilder();
		licNum.append(numLic);
		String licSt = licNum.toString();
		
		StringBuilder pointSb = new StringBuilder();
		pointSb.append(points);
		String pointSt = pointSb.toString();
		
		StringBuilder addpointSb = new StringBuilder();
		addpointSb.append(addpoints);
		String addpointSt = addpointSb.toString();
		
		StringBuilder dateSb = new StringBuilder();
		dateSb.append(naiss);
		String dateSt = dateSb.toString();
		
		StringBuilder licAnSb = new StringBuilder();
		licAnSb.append(anLic);
		String licAnSt = licAnSb.toString();
		
		System.out.println("Licencié: \nNuméro de licence: "+licSt+", Points FFV: "+pointSt+", "
				+ "Points additionnés: "+addpointSt+", Date de naissance: "+dateSt+", Âge: "+age+", Année Licence: "+licAnSt);	
	}
	
	public static void afficheCommisaire(String comite){
		System.out.println("Commisaire: \nComité: "+comite);
		System.out.println();
	}
}
