package com.ldn.regates;

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
		
		
		//check if database connection is Ok
		try {
			Connect.cConnect();		
			
		}
		catch (Exception e) {
//			 JOptionPane.showMessageDialog(mainUI,"was unable to connect to database, please check that your dabase server is started, error is displayed in console ","Error",
//		              JOptionPane.INFORMATION_MESSAGE);
			 e.printStackTrace();	 
		}
		
		List <Personne> persInfo = new ArrayList<>();		
		Personne per = null;
		List<Proprietaire> propInfo = new ArrayList<>();
		Proprietaire prop = null;
		List<Licencie> licInfo = new ArrayList<>();
		Licencie lic = null;

		// Capture des infos Personne
		String perNom = Personne.persNom();
		String preNom = Personne.persPren();
		String courr = Personne.eMail();	// Le test de cohérence est effectué à l'intérieur de Personne (on fait appel à une methode qui se trouve en Controls)
			// Insertion des données dans l'ArrayList Personne
		per = new Personne(perNom, preNom, courr);
		persInfo.add(per);
		
		// Capture des infos Propriétaire
		String tel = Proprietaire.telProprio();
		String adre = Proprietaire.adresseProp();
			// Insertion des données dans l'ArrayList Propriétaire
		prop = new Proprietaire(perNom, preNom, courr, tel, adre);
		propInfo.add(prop);
		
		// Capture des infos Licencie
		int numLic = Licencie.licNum();
		double pFFV = Licencie.ffvPoints();
		double addpoints = Licencie.addPoints();
		Date dateNe = Licencie.naissDate();
		String age = Controls.age(dateNe);	// Calcul de l'âge à partir de la date de naissance
		int anLic = Licencie.licAnnee();
		double anneeRes = Controls.anneeLic(anLic,pFFV);
		pFFV = anneeRes;
			// Insertion des données dans l'ArrayList Licencié
		lic = new Licencie(perNom, preNom, courr, numLic, pFFV, addpoints, dateNe, anLic);
		licInfo.add(lic);
		
		String comite = Commisaire.comiteNom();

		// Affichage de chaque entité
		Affichage.affichePersonne(perNom,preNom,courr);
		Affichage.afficheProprietaire(tel, adre);
		Affichage.afficheLicencie(numLic, pFFV, addpoints, dateNe, age, anLic);
		Affichage.afficheCommisaire(comite);


	}
}
