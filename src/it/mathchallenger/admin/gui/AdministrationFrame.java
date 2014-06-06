package it.mathchallenger.admin.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class AdministrationFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField regUsernameText;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrationFrame frame = new AdministrationFrame();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdministrationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Utenti", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 200, 323);
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblUtentiLoggati = new JLabel("Utenti loggati: ");
		panel_5.add(lblUtentiLoggati);
		
		JLabel lblNumUtentiLoggati = new JLabel("0");
		panel_5.add(lblNumUtentiLoggati);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		JPanel listUtentiLoggatiPanel = new JPanel();
		scrollPane.setViewportView(listUtentiLoggatiPanel);
		listUtentiLoggatiPanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnCaricaUtenti = new JButton("Carica utenti");
		panel_4.add(btnCaricaUtenti, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_6.setBorder(new TitledBorder(null, "Registra Utente", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_6.setBounds(199, 0, 470, 61);
		panel.add(panel_6);
		
		JLabel lblUsername = new JLabel("Username");
		panel_6.add(lblUsername);
		
		regUsernameText = new JTextField();
		panel_6.add(regUsernameText);
		regUsernameText.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		panel_6.add(lblPassword);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		panel_6.add(lblEmail);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		panel_6.add(btnOk);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Cancella Account", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_7.setBounds(199, 60, 470, 60);
		panel.add(panel_7);
		
		JLabel lblUsername_1 = new JLabel("Username");
		panel_7.add(lblUsername_1);
		
		textField_2 = new JTextField();
		panel_7.add(textField_2);
		textField_2.setColumns(20);
		
		JButton btnOk_1 = new JButton("OK");
		panel_7.add(btnOk_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ranking", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnRicaricaRankingproperties = new JButton("Ricarica ranking.properties");
		btnRicaricaRankingproperties.setBounds(111, 289, 161, 23);
		panel_1.add(btnRicaricaRankingproperties);
		
		JLabel lblNuovoUsername = new JLabel("Nuovo Username");
		lblNuovoUsername.setBounds(10, 20, 100, 14);
		panel_1.add(lblNuovoUsername);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 17, 140, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnOk_2 = new JButton("OK");
		btnOk_2.setBounds(265, 16, 89, 23);
		panel_1.add(btnOk_2);
		
		JLabel lblNuovaPassword = new JLabel("Nuova Password");
		lblNuovaPassword.setBounds(10, 50, 100, 14);
		panel_1.add(lblNuovaPassword);
		
		textField_5 = new JTextField();
		textField_5.setBounds(111, 47, 140, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnOk_3 = new JButton("OK");
		btnOk_3.setBounds(265, 46, 89, 23);
		panel_1.add(btnOk_3);
		
		JLabel lblNuovoUseragebt = new JLabel("Nuovo User-Agent");
		lblNuovoUseragebt.setBounds(10, 80, 100, 14);
		panel_1.add(lblNuovoUseragebt);
		
		textField_6 = new JTextField();
		textField_6.setBounds(111, 77, 140, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnOk_4 = new JButton("OK");
		btnOk_4.setBounds(265, 76, 89, 23);
		panel_1.add(btnOk_4);
		
		JLabel lblNuovoUrlRanking = new JLabel("Nuovo URL Publish");
		lblNuovoUrlRanking.setBounds(10, 110, 100, 14);
		panel_1.add(lblNuovoUrlRanking);
		
		textField_7 = new JTextField();
		textField_7.setBounds(111, 107, 140, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnOk_5 = new JButton("OK");
		btnOk_5.setBounds(265, 106, 89, 23);
		panel_1.add(btnOk_5);
		
		JLabel lblNuovoTimesleep = new JLabel("Nuovo TIME_SLEEP");
		lblNuovoTimesleep.setBounds(10, 140, 100, 14);
		panel_1.add(lblNuovoTimesleep);
		
		textField_8 = new JTextField();
		textField_8.setBounds(111, 137, 140, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnOk_6 = new JButton("OK");
		btnOk_6.setBounds(265, 136, 89, 23);
		panel_1.add(btnOk_6);
		
		JButton btnForzaAggiornamentoClassifica = new JButton("Forza aggiornamento classifica");
		btnForzaAggiornamentoClassifica.setBounds(282, 289, 179, 23);
		panel_1.add(btnForzaAggiornamentoClassifica);
		
		JLabel lblNuovoUrlRanking_1 = new JLabel("Nuovo URL Ranking");
		lblNuovoUrlRanking_1.setBounds(10, 200, 100, 14);
		panel_1.add(lblNuovoUrlRanking_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(111, 197, 140, 20);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnOk_7 = new JButton("OK");
		btnOk_7.setBounds(265, 196, 89, 23);
		panel_1.add(btnOk_7);
		
		JLabel lblTimesleeperror = new JLabel("TIME_SLEEP_ERROR");
		lblTimesleeperror.setBounds(10, 170, 100, 14);
		panel_1.add(lblTimesleeperror);
		
		textField_10 = new JTextField();
		textField_10.setBounds(111, 167, 140, 20);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnOk_8 = new JButton("OK");
		btnOk_8.setBounds(265, 166, 89, 23);
		panel_1.add(btnOk_8);
		
		JButton btnSalvaTutti = new JButton("Salva tutti");
		btnSalvaTutti.setBounds(265, 240, 89, 23);
		panel_1.add(btnSalvaTutti);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Server", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Funzioni server", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_8.setBounds(0, 0, 669, 94);
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnRiavviaServer = new JButton("Riavvia Server");
		btnRiavviaServer.setBounds(10, 11, 103, 23);
		panel_8.add(btnRiavviaServer);
		
		JButton btnBloccaConnessioni = new JButton("Blocca connessioni");
		btnBloccaConnessioni.setBounds(123, 11, 127, 23);
		panel_8.add(btnBloccaConnessioni);
		
		JButton btnSbloccaConnessioni = new JButton("Sblocca connessioni");
		btnSbloccaConnessioni.setBounds(123, 45, 127, 23);
		panel_8.add(btnSbloccaConnessioni);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Versioni client abilitati - rimuovi", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_9.setBounds(0, 94, 669, 65);
		panel_2.add(panel_9);
		FlowLayout fl_panel_9 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_9.setLayout(fl_panel_9);
		
		JLabel lblVersioniAbilitate = new JLabel("Versioni abilitate");
		panel_9.add(lblVersioniAbilitate);
		
		JComboBox comboBox = new JComboBox();
		panel_9.add(comboBox);
		
		JButton btnRimuovi = new JButton("Rimuovi");
		panel_9.add(btnRimuovi);
		
		JButton btnCaricaVersioni = new JButton("Carica Versioni");
		panel_9.add(btnCaricaVersioni);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "Versioni client abilitati - aggiungi", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_10.setBounds(0, 159, 669, 65);
		panel_2.add(panel_10);
		
		JLabel lblNuovaVersione = new JLabel("Nuova versione");
		panel_10.add(lblNuovaVersione);
		
		textField_3 = new JTextField();
		panel_10.add(textField_3);
		textField_3.setColumns(5);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		panel_10.add(btnAggiungi);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Cambia dati account amministratore", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_11.setBounds(0, 223, 669, 100);
		panel_2.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNuovoUsername_1 = new JLabel("Nuovo Username");
		panel_11.add(lblNuovoUsername_1);
		
		textField_11 = new JTextField();
		panel_11.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNuovaPassword_1 = new JLabel("Nuova Password");
		panel_11.add(lblNuovaPassword_1);
		
		textField_12 = new JTextField();
		panel_11.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnOk_9 = new JButton("OK");
		panel_11.add(btnOk_9);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Email", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnRicaricaEmailproperties = new JButton("Ricarica email.properties");
		btnRicaricaEmailproperties.setBounds(260, 289, 149, 23);
		panel_3.add(btnRicaricaEmailproperties);
		
		JLabel lblNuovoIndirizzoEmail = new JLabel("Nuovo indirizzo email");
		lblNuovoIndirizzoEmail.setBounds(10, 10, 120, 14);
		panel_3.add(lblNuovoIndirizzoEmail);
		
		JLabel lblNuovoUsername_2 = new JLabel("Nuovo username");
		lblNuovoUsername_2.setBounds(10, 40, 120, 14);
		panel_3.add(lblNuovoUsername_2);
		
		JLabel lblNuovaPassword_2 = new JLabel("Nuova password");
		lblNuovaPassword_2.setBounds(10, 70, 120, 14);
		panel_3.add(lblNuovaPassword_2);
		
		JLabel lblNomeVisualizzato = new JLabel("Nome visualizzato");
		lblNomeVisualizzato.setBounds(10, 100, 120, 14);
		panel_3.add(lblNomeVisualizzato);
		
		JLabel lblNuovoSmtpserver = new JLabel("Nuovo SMTP-Server");
		lblNuovoSmtpserver.setBounds(10, 130, 120, 14);
		panel_3.add(lblNuovoSmtpserver);
		
		JLabel lblNuovaPortaSmtp = new JLabel("Nuova porta SMTP");
		lblNuovaPortaSmtp.setBounds(10, 160, 120, 14);
		panel_3.add(lblNuovaPortaSmtp);
		
		JLabel lblUtilizzoSsl = new JLabel("Utilizzo SSL");
		lblUtilizzoSsl.setBounds(10, 190, 120, 14);
		panel_3.add(lblUtilizzoSsl);
		
		textField_13 = new JTextField();
		textField_13.setBounds(121, 7, 140, 20);
		panel_3.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(121, 37, 140, 20);
		panel_3.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(121, 67, 140, 20);
		panel_3.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(121, 97, 140, 20);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(121, 130, 140, 20);
		panel_3.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(121, 157, 140, 20);
		panel_3.add(textField_18);
		textField_18.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(121, 187, 140, 20);
		panel_3.add(comboBox_1);
		
		JButton btnOk_10 = new JButton("OK");
		btnOk_10.setBounds(268, 6, 89, 23);
		panel_3.add(btnOk_10);
		
		JButton btnOk_11 = new JButton("OK");
		btnOk_11.setBounds(268, 36, 89, 23);
		panel_3.add(btnOk_11);
		
		JButton btnOk_12 = new JButton("OK");
		btnOk_12.setBounds(268, 66, 89, 23);
		panel_3.add(btnOk_12);
		
		JButton btnOk_13 = new JButton("OK");
		btnOk_13.setBounds(268, 96, 89, 23);
		panel_3.add(btnOk_13);
		
		JButton btnOk_14 = new JButton("OK");
		btnOk_14.setBounds(268, 129, 89, 23);
		panel_3.add(btnOk_14);
		
		JButton btnOk_15 = new JButton("OK");
		btnOk_15.setBounds(268, 156, 89, 23);
		panel_3.add(btnOk_15);
		
		JButton btnOk_16 = new JButton("OK");
		btnOk_16.setBounds(268, 186, 89, 23);
		panel_3.add(btnOk_16);
		
		JButton btnSalvaTutti_1 = new JButton("Salva tutti");
		btnSalvaTutti_1.setBounds(268, 220, 89, 23);
		panel_3.add(btnSalvaTutti_1);
	}
}
