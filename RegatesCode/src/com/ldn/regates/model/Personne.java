package com.ldn.regates.model;

import java.util.Scanner;

import com.ldn.regates.utlis.Controls;

public class Personne {

	private String nomPers;
	private String prenPers;
	private String eMail;
	
//	List<String> persoInfo = new ArrayList<>();
	
	public Personne(String nomPers, String prenPers, String eMail) {
		super();
		this.nomPers = nomPers;
		this.prenPers = prenPers;
		this.eMail = eMail;
	}
	
	public static String persNom() {
		String nomPers;
		// Saisie clavier du nom
		@SuppressWarnings("resource")
		Scanner nomKeyb = new Scanner(System.in);
		System.out.println("Nom:");
		nomPers = nomKeyb.nextLine();
//		persoInfo.add(nomPers);
//		if (persoInfo == null) {
//			for (persoInfo v: nomPers) {
//				v.affDesc();
//			}
//		}
//		nomKeyb.close();
		System.out.println(nomPers);
		return nomPers;	
	}
	
	public static String persPren(){
		String prenPers;
		// Saisie clavier du prénom
		@SuppressWarnings("resource")
		Scanner prenKeyb = new Scanner(System.in);
		System.out.println("Prénom:");
		prenPers = prenKeyb.nextLine();
//		persoInfo.add(prenPers);
		System.out.println(prenPers);
		return prenPers;	
	}
	
	public static String eMail(){
		String eMail;
		Scanner eMailKeyb = new Scanner(System.in);
		System.out.println("Courriel:");
		eMail = eMailKeyb.nextLine();
		boolean resu = Controls.isValidEMail(eMail);
		
		if (resu == false) {
			System.out.println("Ceci n'est pas un courriel valable");
		}
		else {
			System.out.println(eMail);
		}
//		eMailKeyb.close();
//		persoInfo.add(eMail);

		return eMail;
	}
//	public static void getNom(Personne p) {
//	String nomPers = Saisie.persNom();
//	}
//	
//	public static void getPren() {
//	String perPren = Saisie.persPren();
//	}
//	
//	public static void getMail() {
//	String courr = Saisie.eMail();
//	}

	
	public String getNomPers() {
		return nomPers;
	}
	public void setNomPers(String nomPers) {
		this.nomPers = nomPers;
	}
	public String getPrenPers() {
		return prenPers;
	}
	public void setPrenPers(String prenPers) {
		this.prenPers = prenPers;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
}
