package com.ldn.regates.model;

import java.util.Date;

public class Licencie {
	private int numLicence;
	private double pointsFFV;
	private Date dateNaiss;
	private int anneeLic;

	public Licencie(int numLicence, double pointsFFV, Date dateNaiss,
			int anneeLic) {
		super();
		this.numLicence = numLicence;
		this.pointsFFV = pointsFFV;
		this.dateNaiss = dateNaiss;
		this.anneeLic = anneeLic;
	}

}
