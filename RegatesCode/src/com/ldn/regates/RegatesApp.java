package com.ldn.regates;

import java.awt.EventQueue;
import java.awt.Toolkit;

import com.ldn.regates.ui.UImain;






public class RegatesApp {
	
	private UImain mainUI;
//	private UIproprio proprioUI;
//	private UIvoilier voilierUI;
//	private UIlicencie licencieUI;


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					RegatesApp app = new RegatesApp();
					//catch RuntimeExceptions during execution
					@SuppressWarnings("unused")
					EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
					
					
					
					app.mainUI.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public RegatesApp() {
		initialize();
	}

	private void initialize() {

		//main window
		mainUI = new UImain(this);
		mainUI.setVisible(false);


	}
}
