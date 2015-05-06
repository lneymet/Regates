package com.ldn.regates.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.ldn.regates.dao.Connect;
import com.ldn.regates.dao.ProprietaireDAO;
import com.ldn.regates.model.Proprietaire;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class UIproprio extends JFrame {

	private JPanel contentPane;
	private JTextField tFieldNomProp;
	private JTextField tFieldPrenProp;
	private JTextField tFieldEmail;
	private JTextField tFieldTelProp;
	private JTextField tFieldAdresseProp;
	private JTextField tFieldClubProp;
	private List<Proprietaire> prop = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIproprio frame = new UIproprio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIproprio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom.setBounds(52, 45, 79, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom:");
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setBounds(52, 73, 79, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblEmail = new JLabel("eMail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(52, 101, 79, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone:");
		lblTlphone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTlphone.setBounds(52, 129, 79, 14);
		contentPane.add(lblTlphone);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setBounds(52, 160, 79, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblClub = new JLabel("Club:");
		lblClub.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClub.setBounds(52, 191, 79, 14);
		contentPane.add(lblClub);
		
		tFieldNomProp = new JTextField();
		tFieldNomProp.setBounds(141, 42, 228, 20);
		contentPane.add(tFieldNomProp);
		tFieldNomProp.setColumns(10);

		
		tFieldPrenProp = new JTextField();
		tFieldPrenProp.setBounds(141, 70, 228, 20);
		contentPane.add(tFieldPrenProp);
		tFieldPrenProp.setColumns(10);

		
		tFieldEmail = new JTextField();
		tFieldEmail.setBounds(141, 98, 228, 20);
		contentPane.add(tFieldEmail);
		tFieldEmail.setColumns(10);

		
		tFieldTelProp = new JTextField();
		tFieldTelProp.setBounds(141, 126, 228, 20);
		contentPane.add(tFieldTelProp);
		tFieldTelProp.setColumns(10);

		
		tFieldAdresseProp = new JTextField();
		tFieldAdresseProp.setBounds(141, 157, 228, 20);
		contentPane.add(tFieldAdresseProp);
		tFieldAdresseProp.setColumns(10);

		
		tFieldClubProp = new JTextField();
		tFieldClubProp.setBounds(141, 188, 228, 20);
		contentPane.add(tFieldClubProp);
		tFieldClubProp.setColumns(10);

		
		JButton btnSaveProp = new JButton("Save");
		btnSaveProp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int propid = ProprietaireDAO.getID();
				String propnom = tFieldNomProp.getText();
				String proppre = tFieldPrenProp.getText();
				String propmail = tFieldEmail.getText();
				String proptel = tFieldTelProp.getText();
				String propcoor = tFieldAdresseProp.getText();
				String propclub = tFieldClubProp.getText();
			 
//				 List<Proprietaire> ps = new ArrayList<>();
	 
		        // test avec select

	        	Proprietaire prop = new Proprietaire(propid, propnom, proppre, propmail, proptel, propcoor, propclub);
//	        	ps.add(prop);
	        	
	        	ProprietaireDAO.createProprietaire(prop);
	        	dispose();

			}
		});
		btnSaveProp.setBounds(168, 227, 89, 23);
		contentPane.add(btnSaveProp);
		
		JButton btnCancelProp = new JButton("Cancel");
		btnCancelProp.setBounds(280, 227, 89, 23);
		contentPane.add(btnCancelProp);
	}
}
