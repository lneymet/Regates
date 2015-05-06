package com.ldn.regates.model;


public class Voilier {
	private int idVoili;
	private int idProp;
	private int idClasse;
	private String nomVoili;
	private int numVoile;
	private String serie;
	
	
	
	
	public Voilier(int idVoili, int idProp, int idClasse, String nomVoili,
			int numVoile, String serie) {
		super();
		this.idVoili = idVoili;
		this.idProp = idProp;
		this.idClasse = idClasse;
		this.nomVoili = nomVoili;
		this.numVoile = numVoile;
		this.serie = serie;
	}


	public int getIdVoili() {
		return idVoili;
	}


	public void setIdVoili(int idVoili) {
		this.idVoili = idVoili;
	}


	public int getIdProp() {
		return idProp;
	}


	public void setIdProp(int idProp) {
		this.idProp = idProp;
	}


	public int getIdClasse() {
		return idClasse;
	}


	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}


	public String getNomVoili() {
		return nomVoili;
	}


	public void setNomVoili(String nomVoili) {
		this.nomVoili = nomVoili;
	}


	public int getNumVoile() {
		return numVoile;
	}


	public void setNumVoile(int numVoile) {
		this.numVoile = numVoile;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}

	
	
}
