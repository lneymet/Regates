/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldn.regates.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author PATRICE FRANCOIS
 */
public  class Connect {

	private static Connection conn =null;

	 final static String URL = "jdbc:mysql://localhost/regates?noAccessToProcedureBodies=true";
    /**
     * 
     * @return RunTimeException() if any pb
     */
 public static Connection cConnect () 
 {
     if (conn==null) {

	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	        // 
	    	  conn=  DriverManager.getConnection(URL,"dahouet_user","devsujetado");
	      }
	        catch(SQLException sqlE)
	        {
	        	//TODO Logging
	            System.out.println("Sql Erreur " + sqlE.getMessage());
	            throw new RuntimeException();
	        }
	        catch(Exception e)
	        {
	           e.printStackTrace();
	           throw new RuntimeException();
	        }
     }
     
     return conn;
     
 }
}
