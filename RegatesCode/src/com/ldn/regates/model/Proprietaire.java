package com.ldn.regates.model;

import java.util.Scanner;

public class Proprietaire extends Personne {

	private int idProp;
	private String telProp;
	private String adresse;
	private String nomClub;
	
	public Proprietaire(int idProp, String nomPers, String prenPers, String eMail, String telProp, String adresse, String nomClub) {
		super(nomPers, prenPers, eMail);
		this.idProp = idProp;
		this.telProp = telProp;
		this.adresse = adresse;
		this.nomClub = nomClub;
	}
	
	public static int idProp() {
		final int idProp = 0;
		
		
		return idProp;
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
	
	
	public int getIdProp() {
		return idProp;
	}

	public void setIdProp(int idProp) {
		this.idProp = idProp;
	}

	public String getTelProp() {
		return telProp;
	}
	public void setTelProp(String nomProp) {
		this.telProp = nomProp;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNomClub() {
		return nomClub;
	}

	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}
	
}
