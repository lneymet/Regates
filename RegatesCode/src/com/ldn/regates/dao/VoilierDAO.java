package com.ldn.regates.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import com.ldn.regates.model.Voilier;
import com.ldn.regates.ui.UIvoilier;



public class VoilierDAO {
	
	public static List<Voilier> getVoilier(){
		
		 Connection c = Connect.cConnect();
		 
		 
		 List<Voilier> vs = new ArrayList<>();
     // test avec select
     Statement stm;
		try {
			stm = c.createStatement();
			
			String sql = "select * from voilier";
	        ResultSet rs = stm.executeQuery(sql);

	      
	        
	        while (rs.next()){
	        	
	        	int voilid = rs.getInt("id_voilier");
//	        	System.out.println("ID propri�taire: "+propid);
	        	
	        	int propid = rs.getInt("id_proprio");
//	        	System.out.println("Nom Proprietaire: "+propnom);
	        	
	        	int classeid = rs.getInt("id_classe");
//	        	System.out.println("Pr�nom propri�taire: "+proppre);
	        	
	        	String voilinom = rs.getString("nom_voilier");
//	        	System.out.println("eMail propri�taire: "+propmail);
	        	
	        	int voilenum = rs.getInt("num_voile");
//	        	System.out.println("T�l�phone propri�taire: "+proptel);
	        		        	
	        	Voilier voile = new Voilier(voilid, propid, classeid, voilinom, voilenum);
	        	vs.add(voile);
	        }
	        rs.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return vs;
		 
	 }
	
	
	
	 public static void createVoilier(Voilier v) {
		 int idvoil = VoilierDAO.getIDvoilier();
//		 int idprop = Proprietaire.
		 
		 Connection c = Connect.cConnect();
		 PreparedStatement stm;
		try {
			stm = c.prepareStatement("INSERT INTO voilier (id_voilier, id_proprio, id_classe, nom_voilier, numero_voile) VALUES (?,?,?,?,?)");
			stm.setInt(1, idvoil);
			stm.setInt(2, v.getIdProp());
			stm.setInt(3, v.getIdClasse());
			stm.setString(4, v.getNomVoili());
			stm.setInt(5, v.getNumVoile());
			
			stm.execute();
			
			stm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}	
		 
		 
	 }
	
	
	 public static int getIDvoilier(){
			int autoinc = 0;
			Connection c = Connect.cConnect();
			
			  Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select id_voilier from voilier order by id_voilier desc limit 1;";
				ResultSet rs = stm.executeQuery(sql);
			
				while(rs.next()) {
				    // ... get column values from this record
					int autoinc2 = rs.getInt("id_voilier");
					autoinc = (autoinc2+1);
				}
	   
				stm.close();
			} 

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return autoinc;
	 }
	 
	 
	 // Obtention de l'identifiant de la classe necessaire � l'inscription du voilier.
	 public static int getIDclasse(String nomClasse) {
		 
		 	int classeid = 0;
		 
			Connection c = Connect.cConnect();
			
			  Statement stm;
			try {
				stm = c.createStatement();
				
				
				String sql = "select id_classe, nom_classe from classe where nom_classe ="+"'"+nomClasse+"'";
				ResultSet rs = stm.executeQuery(sql);
				
		        while (rs.next()){
				    // ... get column values from this record
					int classeidsql = rs.getInt("id_classe");
					classeid = classeidsql;
				
		        }
				stm.close();
			} 

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return classeid;
	 }
	 
	 
//	 public static List<Voilier> getVoilier(int idVoilier){
//		 
//		 Voilier v = ProprietaireDAO.getProprietaire();
//		 
//		 
//		 String sql = "SELECT * from ville where num_pays =" + numPays;
//		 
//		 Connection c = Connect.cConnect();
//		 
//		 List<Ville> villes = new ArrayList<>();
//		   Statement stm;
//			try {
//				stm = c.createStatement();
//				
//		        ResultSet rs = stm.executeQuery(sql);
//		      
//		        
//		        while (rs.next()){
//		        	int nbhabitant = rs.getInt("nbhabitants");
//		        	String nomVille = rs.getString("nom");
//		        	int numVille = rs.getInt("num");
//		        	
//		        	Ville v = new Ville();
//		        	v.setNom(nomVille);
//		        	v.setNbHabitants(nbhabitant);
//		        	v.setNumVille(numVille);
//		        	v.setPays(p);
//		        	
//		        	
//		        	villes.add(v);
//		        }
//		        rs.close();
//				
//				
//			} catch (SQLException e) {
//				throw new RuntimeException();
//			}
//			
//			return villes;
//	 }

		public static String[] getSerie(){
					
			 List<String> ps = new ArrayList<>();
			 Connection c = Connect.cConnect();

	       // test avec select
	       Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select * from serie";
		        ResultSet rs = stm.executeQuery(sql);

		      
		        
		        while (rs.next()){

		        	String propnom = rs.getString("nom_serie");
//		        	System.out.println("Nom Proprietaire: "+propnom);
		        		        	
		        	ps.add(propnom);
		        }
		        rs.close();
				
				
			} catch (SQLException e) {
				throw new RuntimeException();
			}
			
			String[] sa = new String[ ps.size() ];
			
			return sa;
			 
		 }

		public static String[] getClasse(){
			
			 List<String> ps = new ArrayList<String>();
			 Connection c = Connect.cConnect();

	       // test avec select
	       Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select * from classe";
		        ResultSet rs = stm.executeQuery(sql);

		      
		        
		        while (rs.next()){

		        	String classnom = rs.getString("nom_classe");
//		        	System.out.println("Nom Proprietaire: "+propnom);
		        		        	
		        	ps.add(classnom);
		        	

		        }
		        rs.close();
				
				
			} catch (SQLException e) {
				throw new RuntimeException();
			}
        	String[] sa = new String[ ps.size() ];
			
			return sa;
			 
		 }
		
		public static List<String> getHabitables(){
			
			 List<String> ps = new ArrayList<>();
			 Connection c = Connect.cConnect();

	      // test avec select
	      Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select serie.NOM_SERIE, classe.NOM_CLASSE from serie inner join classe on serie.ID_SERIE = classe.ID_SERIE where nom_serie = \"Habitables\";";
		        ResultSet rs = stm.executeQuery(sql);

		      
		        
		        while (rs.next()){
//		        	int serieid = rs.getInt("id_serie");
//		        	String
//		        	String serienom = rs.getString("nom_serie");
//		        	int classid = rs.getInt("id_classe");
		        	String classnom = rs.getString("nom_classe");
//		        	System.out.println("Nom Proprietaire: "+propnom);
		        		        	
		        	ps.add(classnom);
		        }
		        rs.close();
				
//		        System.out.println(ps);
				
			} catch (SQLException e) {
				throw new RuntimeException();
			}
			
			return ps;
			 
		 }
	
		
		 public static int fillSerie(int numserie)
		 {
		  Connection c = Connect.cConnect();
		  Statement stmt;
		  String sql = "select Nom_serie from serie";
		  
		  try 
		  { 
		   ResultSet rs = null ;  
		   stmt = c.createStatement(); 
		   rs = stmt.executeQuery(sql); 

		   while (rs.next()) 
		   { 
		    String nomserie = rs.getString("Nom_serie");
		    UIvoilier.cBoxSerie.addItem(nomserie); 
		   } 
		  }
		  catch (Exception ex) 
		  { 
		   JOptionPane.showMessageDialog(null, "Erreur de connection");
		  }
		  
		  return numserie;
		 }
		
		 
		 public static int fillClasse(int numclasse)
		 {
		  Connection c = Connect.cConnect();
		  Statement stmt;
		  String sql = "select Nom_classe from classe where id_serie ="+numclasse;
		  
		  try 
		  { 
		   ResultSet rs = null ;  
		   stmt = c.createStatement(); 
		   rs = stmt.executeQuery(sql); 

		   while (rs.next()) 
		   { 
		    String nomclasse = rs.getString("Nom_classe");
		    UIvoilier.cBoxClasse.addItem(nomclasse); 
		   } 
		  }
		  catch (Exception ex) 
		  { 
		   JOptionPane.showMessageDialog(null, "Erreur de connection");
		  }
		  
		  return numclasse;
		 }
		 
		 public static List<Integer> getNumVoile() {
			 
			 List<Integer> numvoileAR = new ArrayList<Integer>();
			 
			  Connection c = Connect.cConnect();
			  Statement stmt;
			  String sql = "select numero_voile from voilier";
			  
			  try 
			  { 
			   ResultSet rs = null ;  
			   stmt = c.createStatement(); 
			   rs = stmt.executeQuery(sql); 

			   while (rs.next()) 
			   { 
			    int numvoile = rs.getInt("numero_voile");
			    numvoileAR.add(numvoile); 
			   } 
			  }
			  catch (Exception ex) 
			  { 
			   JOptionPane.showMessageDialog(null, "Erreur de connection");
			  }
			  
			return numvoileAR;
			 
		 }
}
