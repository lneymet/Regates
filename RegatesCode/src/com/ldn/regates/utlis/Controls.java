package com.ldn.regates.utlis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
// import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ldn.regates.RegatesApp;
import com.ldn.regates.dao.veutContinuer2;

public class Controls {

	static final String emailRegex = "^[a-zA-Z0-9._-]{2,}+@[a-zA-Z0-9._-]{2,}\\.[a-z]{2,4}$";
	static Pattern patternEmail = Pattern.compile(emailRegex);
	static final String dateRegex = "^(\\d{4})/(\\d{2})/(\\d{2})$";
	static Pattern patternDate = Pattern.compile(dateRegex);
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	
	public static boolean isValidEMail(String email){
		
		Matcher matcher = patternEmail.matcher(email);
		return matcher.find();
		
	}
	

	public static boolean isValidDate(String date){
		Matcher matcher = patternDate.matcher(date);
		return matcher.find();
	}
	
	public static String age(Date datene) {
		// Obtention de la date actuelle
		DateFormat dateformat = new SimpleDateFormat ("yyyy/MM/dd");
		Date date = new Date();
		// Transformation de la date pour obtenir l'année actuelle en format int
		String actyear = dateformat.format(date).substring(0, 4);
 		int todayint = Integer.parseInt(actyear);
		// Transformation de la date pour obtenir le mois actuel en format int
		String actmonth = dateformat.format(date).substring(5, 7);
		int todaymonth = Integer.parseInt(actmonth);
		
		// Obtention de la date d'entrée
		DateFormat dateformat2 = new SimpleDateFormat ("yyyy/MM/dd");
		Date date2 = datene;
		// Transformation de la date pour obtenir l'année d'entrée
		String birthyear = dateformat2.format(date2).substring(0, 4);
		int birthint = Integer.parseInt(birthyear);
		// Transformation de la date pour obtenir le mois d'entrée
		String birmonth = dateformat2.format(date2).substring(5, 7);
		int birthmonth = Integer.parseInt(birmonth);

		int ageyear = (todayint - birthint);
		int ageres = 0;
		if (todaymonth < birthmonth) {
			ageres = (((ageyear * 12) - (birthmonth - todaymonth))/12);
		}
		else if (todaymonth > birthmonth) {
			ageres = (((ageyear * 12) + (birthmonth - todaymonth))/12);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ageres);
		String age = sb.toString();

		return age;	
	}
	
	public static double anneeLic(int anneelic, double pffv){
		double pffvo = 0;
		DateFormat dateformat = new SimpleDateFormat ("yyyy/MM/dd");
		Date date = new Date();
		String dform = dateformat.format(date).substring(0, 4);
		StringBuilder sb = new StringBuilder();
		sb.append(anneelic);
		String ancomp = sb.toString();
		
		if (!dform.equals(ancomp)) {
			pffvo = pffv;
			System.out.println("La date de la licence est perimée. Les points FFV n'ont pas pu être actualisés");
		} 
//		else {
//			pffvo = (pffv + 50.5);
//			}
		pffvo = pffv;
		
		return pffvo;
	}
	
	
//	public static String mailing(){
//		String eMail;
//		
//		do {
//			Scanner eMailKeyb = new Scanner(System.in);
//			System.out.println("Saissisez votre courriel:");
//			eMail = eMailKeyb.nextLine();
////			eMailKeyb.close();
//
//			// Vérification des contraints adresse mail.
//				// La @ doit se retrouver au moins à 2 places du premier char
////			String addmail = "lik@fikerinopertinence.com";
//		String recherche = "@";
//		int position;
//		position = eMail.indexOf(recherche);
//			// Le point doit se retrouver au moins à 2 places de la @.
//		if (position > 1) {
//			String recherche1 = ".";
//			int position2;
//			position2 = eMail.lastIndexOf(recherche1);
//				// Il doit y avoir au moins deux chars après le point
//			if (position2 > (position + 2)) {
//				int len = eMail.length();
//				char lastChar = eMail.charAt(len -1);
//				int lastIndex = eMail.lastIndexOf(lastChar);				
//				if (lastIndex > (position2 + 1)) {
//					System.out.println(eMail);
//				}
//				else {
//					System.out.println("Error: Extension non valable");
//				}	
//			}
//			else {
//				System.out.println("Error: Il doit y avoir au moins deux caractères entre @ et le point");
//			}
//		}
//		else {
//			System.out.println("Error: Il doit y avoir au moins deux caractères avant @");
//		}
//		}
//		while (veutContinuer2.vC());
//		
//		return (eMail);
//	}
}
