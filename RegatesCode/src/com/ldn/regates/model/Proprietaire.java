package com.ldn.regates.model;



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
