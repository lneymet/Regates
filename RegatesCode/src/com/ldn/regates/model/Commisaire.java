package com.ldn.regates.model;




public class Commisaire extends Personne {
	private String comite;

	public Commisaire(String nomPers, String prenPers, String eMail, String comite) {
		super(nomPers, prenPers, eMail);
		this.comite = comite;
	}
	

	public String getComite() {
		return comite;
	}

	public void setComite(String comite) {
		this.comite = comite;
	}

}
