package com.ldn.regates.model;


import java.util.Date;



public class Licencie extends Personne {
	
	private int idLic;
	private String addrLic;
	private int numLicence;
	private double pointsFFV;
	private Date anneeLic;
	private Date dateNaiss;


	public Licencie(int idLic, String nomPers, String prenPers, String eMail, String addrLic, int numLicence, 
			double pointsFFV, Date licDateEquip, Date dateNaiss) {
		super(nomPers, prenPers, eMail);
		
		this.idLic = idLic;
		this.addrLic = addrLic;
		this.numLicence = numLicence;
		this.pointsFFV = pointsFFV;
		this.anneeLic = licDateEquip;
		this.dateNaiss = dateNaiss;
	
	}
	
	public int getIdLic() {
		return idLic;
	}

	public void setIdLic(int idLic) {
		this.idLic = idLic;
	}

	public String getAddrLic() {
		return addrLic;
	}

	public void setAddrLic(String addrLic) {
		this.addrLic = addrLic;
	}

	public int getNumLicence() {
		return numLicence;
	}

	public void setNumLicence(int numLicence) {
		this.numLicence = numLicence;
	}

	public double getPointsFFV() {
		return pointsFFV;
	}

	public void setPointsFFV(double pointsFFV) {
		this.pointsFFV = pointsFFV;
	}

	public Date getAnneeLic() {
		return anneeLic;
	}

	public void setAnneeLic(Date anneeLic) {
		this.anneeLic = anneeLic;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

}
