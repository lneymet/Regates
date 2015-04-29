package com.ldn.regates.model;

import java.util.Scanner;

public class Proprietaire extends Personne {

	private String telProp;
	private String adresse;
	
	public Proprietaire(String nomPers, String prenPers, String eMail, String telProp, String adresse) {
		super(nomPers, prenPers, eMail);
		this.telProp = telProp;
		this.adresse = adresse;
	}
	
	public static String telProprio() {
		final String telProp;
		
		Scanner telKeyb = new Scanner(System.in);
		System.out.println("Saisissez votre numéro de téléphone:");
		telProp = telKeyb.nextLine();
//		nomKeyb.close();
		System.out.println(telProp);
		return telProp;
	}

	public static String adresseProp() {
		final String adresse;
		
		Scanner nomKeyb = new Scanner(System.in);
		System.out.println("Saisissez votre adresse:");
		adresse = nomKeyb.nextLine();
//		nomKeyb.close();
		System.out.println(adresse);
		return adresse;
	}
	
	public String getNomProp() {
		return telProp;
	}
	public void setNomProp(String nomProp) {
		this.telProp = nomProp;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
