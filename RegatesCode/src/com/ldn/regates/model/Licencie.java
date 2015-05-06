package com.ldn.regates.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.ldn.regates.utlis.Controls;


public class Licencie extends Personne {
	

	private int numLicence;
	private double pointsFFV;
	private double addpoints;
	private Date dateNaiss;
	private int anneeLic;

	public Licencie(String nomPers, String prenPers, String eMail, int numLicence, double pointsFFV, 
					double addpoints, Date dateNaiss, int anneeLic) {
		super(nomPers, prenPers, eMail);
		
		this.numLicence = numLicence;
		this.pointsFFV = pointsFFV;
		this.addpoints = addpoints;
		this.dateNaiss = dateNaiss;
		this.anneeLic = anneeLic;	
	}
	
	public static int licNum() {
		int numLicence;
		Scanner licKeyb = new Scanner(System.in);
		System.out.println("Saisissez votre numéro de licence:");
		numLicence = licKeyb.nextInt();
//		persoInfo.add(numLicence);
		System.out.println(numLicence);

		return numLicence;
	}
	
	public static double ffvPoints() {
		double pointsFFV;
		Scanner poinKeyb = new Scanner(System.in);
		System.out.println("Saisissez vos points FFV:");
		pointsFFV = poinKeyb.nextDouble();
//		persoInfo.add(pointsFFV);
		System.out.println(pointsFFV);

		return pointsFFV;
	}
	
	public static double addPoints() {
		double addpoints;
		Scanner addpKeyb = new Scanner(System.in);
		System.out.println("Points à additionner:");
		addpoints = addpKeyb.nextDouble();
//		persoInfo.add(pointsFFV);
		System.out.println(addpoints);

		return addpoints;
	}
	
	public static Date naissDate() {
		Date dateNaiss = null;
	     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
    df.setLenient(false);

    try {
        System.out.print("Saisissez votre date de naissance (yyyy/MM/dd): ");
        String dateString = reader.readLine();
        // Parse the date
		boolean resu = Controls.isValidDate(dateString);

		if (resu == false) {
			System.out.println("Ceci n'est pas une date valable");
		}
		else {
			System.out.println(dateString);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		dateNaiss = format.parse(dateString);
		
		return dateNaiss;
    }
    catch(Exception e) {

    }
		
//		Scanner naisKeyb = new Scanner(System.in);
//		System.out.println("Saissisez votre prénom:");
//		dateNaiss = naisKeyb.nextLine();
////		persoInfo.add(pointsFFV);
//		System.out.println(dateNaiss);
		
		return dateNaiss;
	}
	
	public static int licAnnee() {
		int anneeLic;
		Scanner annKeyb = new Scanner(System.in);
		System.out.println("Saisissez l'année de votre licence:");
		anneeLic = annKeyb.nextInt();
//		persoInfo.add(numLicence);
		System.out.println(anneeLic);
		
		return anneeLic;	
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

	public double getAddpoints() {
		return addpoints;
	}

	public void setAddpoints(double addpoints) {
		this.addpoints = addpoints;
	}
	
	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public int getAnneeLic() {
		return anneeLic;
	}

	public void setAnneeLic(int anneeLic) {
		this.anneeLic = anneeLic;
	}

}
