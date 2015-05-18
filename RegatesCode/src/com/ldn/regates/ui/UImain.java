package com.ldn.regates.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import com.ldn.regates.RegatesApp;



public class UImain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -184198042259276957L;
	@SuppressWarnings("unused")
	private RegatesApp controller;
	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public UImain(RegatesApp controller) {
		this.controller = controller;
		
		setTitle("Régates de Dahouët - Baie de St Brieuc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 680, 21);
		contentPane.add(menuBar);
		
		JMenu mnInscriptions = new JMenu("Inscriptions");
		menuBar.add(mnInscriptions);
		
		JMenuItem mntmCreateProp = new JMenuItem("Propriétaire");
		mntmCreateProp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   UIproprio anotherFrame = new UIproprio();
				   anotherFrame.pack();
				   anotherFrame.setVisible(true);
			}
		});
		mnInscriptions.add(mntmCreateProp);
		
		JMenuItem mntmCreationVoilier = new JMenuItem("Voilier");
		mntmCreationVoilier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   UIvoilier anotherFrame = new UIvoilier();
				   anotherFrame.pack();
				   anotherFrame.setVisible(true);
			}
		});
		mnInscriptions.add(mntmCreationVoilier);
		
		JMenuItem mntmquipier = new JMenuItem("Équipier");
		mntmquipier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIlicencie anotherFrame = new UIlicencie();
			   anotherFrame.pack();
			   anotherFrame.setVisible(true);
			}
		});
		mnInscriptions.add(mntmquipier);
		
		JPanel panel = new JPanel();
		panel.setBounds(433, 21, -431, 241);
		contentPane.add(panel);
		
 
		JLabel lblBackgimage = new JLabel("BackgImage");
		lblBackgimage.setIcon(new ImageIcon(UImain.class.getResource("/images/port.jpg")));
		lblBackgimage.setBounds(0, 21, 680, 488);
		contentPane.add(lblBackgimage);
	}
}
