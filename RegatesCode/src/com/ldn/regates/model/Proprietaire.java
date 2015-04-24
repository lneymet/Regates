package com.ldn.regates.model;

import java.util.Scanner;

public class Proprietaire {

	private String nomProp;
	private String adresse;
	
	public Proprietaire(String nomProp, String adresse) {
		super();
		this.nomProp = nomProp;
		this.adresse = adresse;
	}
	
	public static String telProprio() {
		final String telProp;
		
		Scanner telKeyb = new Scanner(System.in);
		System.out.println("Saissisez votre num�ro de t�l�phone:");
		telProp = telKeyb.nextLine();
//		nomKeyb.close();
		System.out.println(telProp);
		return telProp;
	}

	public static String adresseProp() {
		final String adresse;
		
		Scanner nomKeyb = new Scanner(System.in);
		System.out.println("Saissisez votre adresse:");
		adresse = nomKeyb.nextLine();
//		nomKeyb.close();
		System.out.println(adresse);
		return adresse;
	}
	
	public String getNomProp() {
		return nomProp;
	}
	public void setNomProp(String nomProp) {
		this.nomProp = nomProp;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
