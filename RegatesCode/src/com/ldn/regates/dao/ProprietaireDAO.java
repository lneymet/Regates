package com.ldn.regates.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ldn.regates.model.Proprietaire;
import com.ldn.regates.ui.UIvoilier;




public class ProprietaireDAO {
	
	public static List<Proprietaire> getProprietaire(){
		
		 Connection c = Connect.cConnect();
		 
		 
		 List<Proprietaire> ps = new ArrayList<>();
       // test avec select
       Statement stm;
		try {
			stm = c.createStatement();
			
			String sql = "select * from proprietaire";
	        ResultSet rs = stm.executeQuery(sql);

	      
	        
	        while (rs.next()){
	        	
	        	int propid = rs.getInt("id_proprio");
	        	String propnom = rs.getString("nom_proprio");
	        	String proppre = rs.getString("prenom_proprio");
	        	String propmail = rs.getString("email_proprio");
	        	String proptel = rs.getString("tel_proprio");
	        	String propcoor = rs.getString("coordonnees_proprio");
	        	String propclub = rs.getString("nom_club");
	        		        	
	        	Proprietaire prop = new Proprietaire(propid, propnom, proppre, propmail, proptel, propcoor, propclub);
	        	ps.add(prop);
	        }
	        rs.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return ps;
		 
	 }
	
	 public static void createProprietaire(Proprietaire p) {
		 int idprop = ProprietaireDAO.getID();
		 
		 Connection c = Connect.cConnect();
		 PreparedStatement stm;
		try {
			stm = c.prepareStatement("INSERT INTO proprietaire (id_proprio, nom_proprio, prenom_proprio, email_proprio, tel_proprio, coordonnees_proprio, nom_club) VALUES (?,?,?,?,?,?,?)");
			stm.setInt(1, idprop);
			stm.setString(2, p.getNomPers());
			stm.setString(3, p.getPrenPers());
			stm.setString(4, p.geteMail());
			stm.setString(5, p.getTelProp());
			stm.setString(6, p.getAdresse());
			stm.setString(7, p.getNomClub());
			
			stm.execute();
			
			stm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}	
		 
		 
	 }
	 
	 @SuppressWarnings("null")
	public static ProprietaireDAO getProprietaire(int idprop){
		 
		 List<ProprietaireDAO> ps = new ArrayList<>();
		 
		 ProprietaireDAO p = null;
		 Connection c = Connect.cConnect();
		  Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select * from proprietaire WHERE id_proprio=" + idprop;
		        ResultSet rs = stm.executeQuery(sql);
		      
		        
		        while (rs.next()){
		        	int propid = rs.getInt("id_proprio");
		        	String propnom = rs.getString("nom_proprio");
		        	String proppre = rs.getString("prenom_proprio");
		        	String propmail = rs.getString("email_proprio");
		        	String proptel = rs.getString("tel_proprio");
		        	String propcoor = rs.getString("coordonnees_proprio");
		        	String propclub = rs.getString("nom_club");

		        		        	
		        	ProprietaireDAO prop = new ProprietaireDAO(propid, propnom, proppre, propmail, proptel, propcoor, propclub);
		        	ps.add(prop);
		        	
		        	
		        	p.setIdProp(propid);
		        	p.setNomProp(propnom);
		        	p.setPrenProp(proppre);
		        	p.seteMailProp(propmail);
		        	p.setTelProp(proptel);
		        	p.setAdrProp(propcoor);
		        	p.setNomClub(propclub);
		        			        	
		        }
		        rs.close();
				
				
			} catch (SQLException e) {
				throw new RuntimeException();
			}
			
			return p;
	 }

	 
	 public static int getID(){
			int autoinc = 0;
			Connection c = Connect.cConnect();
			
			  Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select id_proprio from proprietaire order by id_proprio desc limit 1;";
				ResultSet rs = stm.executeQuery(sql);
			
				while(rs.next()) {
				    // ... get column values from this record
					int autoinc2 = rs.getInt("id_proprio");
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
	
	 
	 public static int getIDpropBox(String nomprop){
			int propid = 0;
			Connection c = Connect.cConnect();
			
			  Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select id_proprio, nom_proprio from proprietaire where nom_proprio="+"'"+nomprop+"'";
				ResultSet rs = stm.executeQuery(sql);
			
		        while (rs.next()){
				    // ... get column values from this record
					int propidsql = rs.getInt("id_proprio");
					propid = propidsql;
//					System.out.println(propid);
		        }
				stm.close();
			} 

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return propid;
	 }
	 
	 
		public static List<String> showProp(){
			
			 List<String> ps = new ArrayList<>();
			 Connection c = Connect.cConnect();

	       // test avec select
	       Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select * from proprietaire";
		        ResultSet rs = stm.executeQuery(sql);

		      
		        
		        while (rs.next()){

		        	
		        	String propnom = rs.getString("nom_proprio");
		        	String proppre = rs.getString("prenom_proprio");
		        	
		            List<String> strings = new LinkedList<>();
		            strings.add(proppre);
		            strings.add(propnom);
		            String message = String.join(" ", strings);
		        		        	
		        	ps.add(message);
		        }
		        rs.close();
				
				
			} catch (SQLException e) {
				throw new RuntimeException();
			}
			
			return ps;
			 
		 }
		
		
		 public static void rempliProp(int numprop)
		 {
		  Connection c = Connect.cConnect();
		  Statement stmt;
		  String sql = "select Nom_proprio from proprietaire";
		  
		  try 
		  { 
		   ResultSet rs = null ;  
		   stmt = c.createStatement(); 
		   rs = stmt.executeQuery(sql); 

		   while (rs.next()) 
		   { 
		    String nomserie = rs.getString("Nom_proprio");
		    UIvoilier.cBoxProp.addItem(nomserie); 
		   } 
		  }
		  catch (Exception ex) 
		  { 
		   JOptionPane.showMessageDialog(null, "erreur");
		  }
		 }

	
	int idProp;
	String nomProp;
	String prenProp;
	String eMailProp;
	String telProp;
	String adrProp;
	String nomClub;
	
	public ProprietaireDAO(int idProp, String nomProp, String prenProp,
			String eMailProp, String telProp, String adrProp, String nomClub) {
		super();
		this.idProp = idProp;
		this.nomProp = nomProp;
		this.prenProp = prenProp;
		this.eMailProp = eMailProp;
		this.telProp = telProp;
		this.adrProp = adrProp;
		this.nomClub = nomClub;
	}

	public int getIdProp() {
		return idProp;
	}

	public void setIdProp(int idProp) {
		this.idProp = idProp;
	}

	public String getNomProp() {
		return nomProp;
	}

	public void setNomProp(String nomProp) {
		this.nomProp = nomProp;
	}

	public String getPrenProp() {
		return prenProp;
	}

	public void setPrenProp(String prenProp) {
		this.prenProp = prenProp;
	}

	public String geteMailProp() {
		return eMailProp;
	}

	public void seteMailProp(String eMailProp) {
		this.eMailProp = eMailProp;
	}

	public String getTelProp() {
		return telProp;
	}

	public void setTelProp(String telProp) {
		this.telProp = telProp;
	}

	public String getAdrProp() {
		return adrProp;
	}

	public void setAdrProp(String adrProp) {
		this.adrProp = adrProp;
	}

	public String getNomClub() {
		return nomClub;
	}

	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}
	
	

}
