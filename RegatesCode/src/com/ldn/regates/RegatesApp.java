package com.ldn.regates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ldn.regates.model.Commisaire;
import com.ldn.regates.model.Licencie;
import com.ldn.regates.model.Personne;
import com.ldn.regates.model.Proprietaire;
import com.ldn.regates.utlis.Affichage;
import com.ldn.regates.utlis.Controls;
import com.ldn.regates.dao.Connect;




public class RegatesApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		//check if database connection is Ok
//		try {
//			 Connection c = Connect.cConnect();	
//			
//		}
//		catch (Exception e) {
////			 JOptionPane.showMessageDialog(mainUI,"was unable to connect to database, please check that your dabase server is started, error is displayed in console ","Error",
////		              JOptionPane.INFORMATION_MESSAGE);
//			 e.printStackTrace();	 
//		}
		
		
		 
//		 Connection c = Connect.cConnect();
//		 
//		 
//		 List<Proprietaire> ps = new ArrayList<>();
//        // test avec select
//        Statement stm;
//		try {
//			stm = c.createStatement();
//			
//			String sql = "select * from proprietaire ";
//	        ResultSet rs = stm.executeQuery(sql);
//
//	      
//	        
//	        while (rs.next()){
//	        	
//	        	int propid = rs.getInt("id_proprio");
////	        	System.out.println("ID propri�taire: "+propid);
//	        	
//	        	String propnom = rs.getString("nom_proprio");
////	        	System.out.println("Nom Proprietaire: "+propnom);
//	        	
//	        	String proppre = rs.getString("prenom_proprio");
////	        	System.out.println("Pr�nom propri�taire: "+proppre);
//	        	
//	        	String propmail = rs.getString("email_proprio");
////	        	System.out.println("eMail propri�taire: "+propmail);
//	        	
//	        	String proptel = rs.getString("tel_proprio");
////	        	System.out.println("T�l�phone propri�taire: "+proptel);
//	        	
//	        	String propcoor = rs.getString("coordonnees_proprio");
////	        	System.out.println("Coordonn�es propri�taire: "+propcoor);
//	        	
//	        	String propclub = rs.getString("nom_club");
////	        	System.out.println("Club propri�taire: "+propclub);
//	        		        	
//	        	Proprietaire prop = new Proprietaire(propid, propnom, proppre, propmail, proptel, propcoor,propclub);
//	        	ps.add(prop);
//	        }
//	        rs.close();
//			
//			
//		} catch (SQLException e) {
//			throw new RuntimeException();
//		}
		
		///////////////////////////////////////
		
		int autoinc = 0;
		Connection c = Connect.cConnect();
		
		  Statement stm;
		try {
			stm = c.createStatement();
			
			String sql = "select id_proprio from proprietaire order by id_proprio desc limit 1;";
			ResultSet rs = stm.executeQuery(sql);
		
			while(rs.next()) {
			    // ... get column values from this record
				autoinc = rs.getInt("id_proprio");
			}
   
			stm.close();
		} 

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Auto increment: "+autoinc);
//		return autoinc;
		
		
	////////////////////////////////////////////////////	
		
		
		
		// Cr�ation de tables pour chaque entit�
		List <Personne> persInfo = new ArrayList<>();		
		Personne per = null;
		List<Proprietaire> propInfo = new ArrayList<>();
		Proprietaire prop = null;
		List<Licencie> licInfo = new ArrayList<>();
		Licencie lic = null;

		// Capture des infos Personne
		String perNom = Personne.persNom();
		String preNom = Personne.persPren();
		String courr = Personne.eMail();	// Le test de coh�rence est effectu� � l'int�rieur de Personne (on fait appel � une methode qui se trouve en Controls)
			// Insertion des donn�es dans l'ArrayList Personne
		per = new Personne(perNom, preNom, courr);
		persInfo.add(per);
		
		// Capture des infos Propri�taire
		String tel = Proprietaire.telProprio();
		String adre = Proprietaire.adresseProp();
			// Insertion des donn�es dans l'ArrayList Propri�taire
//		prop = new Proprietaire(perNom, preNom, courr, tel, adre);
		propInfo.add(prop);
		
		// Capture des infos Licencie
		int numLic = Licencie.licNum();
		double pFFV = Licencie.ffvPoints();
		double addpoints = Licencie.addPoints();
		Date dateNe = Licencie.naissDate();
		String age = Controls.age(dateNe);	// Calcul de l'�ge � partir de la date de naissance
		int anLic = Licencie.licAnnee();
		double anneeRes = Controls.anneeLic(anLic,pFFV);
		pFFV = anneeRes;
			// Insertion des donn�es dans l'ArrayList Licenci�
		lic = new Licencie(perNom, preNom, courr, numLic, pFFV, addpoints, dateNe, anLic);
		licInfo.add(lic);
		// Capture des infos Commisaire
		String comite = Commisaire.comiteNom();

//		Connection c = Connect.cConnect();
//		
//		  Statement stm;
//		try {
//			stm = c.createStatement();
//			String sql = "select id_proprio from proprietaire order by id_proprio desc limit 1;";
//			ResultSet rs = stm.executeQuery(sql);
//			System.out.println("Auto increment: "+rs);
//	    
//			stm.close();
//		} 
//
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
				
		// Affichage de chaque entit�
		Affichage.affichePersonne(perNom,preNom,courr);
		Affichage.afficheProprietaire(tel, adre);
		Affichage.afficheLicencie(numLic, pFFV, addpoints, dateNe, age, anLic);
		Affichage.afficheCommisaire(comite);


	}
}
