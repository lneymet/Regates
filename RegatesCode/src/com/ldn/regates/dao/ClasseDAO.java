package com.ldn.regates.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.ldn.regates.ui.UIvoilier;

public class ClasseDAO {

	
	 public static void fillClasse(int idserie)
	 {
	  Connection c = Connect.cConnect();
	  Statement stmt;
	  String sql = "select Nom_classe from classe where id_serie ="+idserie;
	  
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
	   JOptionPane.showMessageDialog(null, "Erreur");
	  }
	  
	 }

	 public static void rempliQuillards(int numclasse)
	 {
	  Connection c = Connect.cConnect();
	  Statement stmt;
	  String sql = "select Nom_classe from classe where id_serie = 2";
	  
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
	   JOptionPane.showMessageDialog(null, "erreur");
	  }
	  
	 }
	 
}
