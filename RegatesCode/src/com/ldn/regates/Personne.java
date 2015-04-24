package com.ldn.regates;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




import com.ldn.regates.model.Proprietaire;
import com.ldn.regates.utlis.Email;
import com.ldn.regates.dao.Connect;



public class Personne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//check if database connection is Ok
		try {
			Connect.cConnect();		
			
		} catch (Exception e) {
//			 JOptionPane.showMessageDialog(mainUI,"was unable to connect to database, please check that your dabase server is started, error is displayed in console ","Error",
//		              JOptionPane.INFORMATION_MESSAGE);
			 e.printStackTrace();
			 
		}
		
		
		String nomPers;
		String prenPers;
		String eMail;
		
		List<String> persoInfo = new ArrayList<>();
		
		// Saisie clavier du nom
		Scanner nomKeyb = new Scanner(System.in);
		System.out.println("Saissisez votre nom:");
		nomPers = nomKeyb.nextLine();
		persoInfo.add(nomPers);
//		if (persoInfo == null) {
//			for (persoInfo v: nomPers) {
//				v.affDesc();
//			}
//		}
//		nomKeyb.close();
		System.out.println(nomPers);
		
		// Saisie clavier du prénom
		@SuppressWarnings("resource")
		Scanner prenKeyb = new Scanner(System.in);
		System.out.println("Saissisez votre prénom:");
		prenPers = prenKeyb.nextLine();
		persoInfo.add(prenPers);
		System.out.println(prenPers);

		// Fait appel à la classe Email (Ou l'on fait également le test de cohérence).
		eMail = Email.mailing();
		persoInfo.add(eMail);
		
		String propTel = Proprietaire.telProprio();
		String propAdr = Proprietaire.adresseProp();
		
		prenKeyb.close();
		nomKeyb.close();
		
		System.out.println("The End");
		
//		public static boolean isValidDate(String date) {
//			static final String dateRegex = "^\\d{4})-(\\d{2})-(\\d{2}";
//			boolean isOk = true;
//				try {
//					Date dt = dateFormat.parse(date);
//				} catch (ParseException e) {
//					
//				}
//		}
	}

}
