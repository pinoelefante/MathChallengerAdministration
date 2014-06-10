package it.mathchallenger.admin.gui;

import it.mathchallenger.admin.communication.Communication;
import it.mathchallenger.admin.communication.CommunicationMessageCreator;
import it.mathchallenger.admin.communication.CommunicationParser;
import it.mathchallenger.admin.communication.Messaggio;
import it.mathchallenger.admin.communication.beans.UtentiOnline;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.UIManager;

public class AdministrationFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField regUsernameText;
	private JTextField regPassText;
	private JTextField regEmailText;
	private JTextField deleteUsernameText;
	private JTextField textField_3;
	private JTextField rankingNewUsername;
	private JTextField rankingNewPassword;
	private JTextField rankingNewUserAgent;
	private JTextField rankingNewURLPublish;
	private JTextField rankingNewSleepTime;
	private JTextField rankingNewURLRanking;
	private JTextField rankingNewSleepTimeError;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	private Communication comm=Communication.getInstance();
	private JButton btnCaricaUtenti;
	private JLabel lblNumClientConnessi;
	private JLabel lblNumUtentiLoggati;
	private JPanel listUtentiLoggatiPanel;
	private JTextField modificaIDUtente;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNomeutenteselezionato;
	private JTextField banID;
	private JTextField banUsername;
	private JTextField deleteID;
	private JButton btnCaricaVersioni;
	private JComboBox<Integer> versioniAbilitateChk;
	private JButton btnForzaAggiornamentoClassifica;
	private JButton btnRicaricaRankingProperties;
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
		panel_5.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12);
		
		JLabel lblUtentiLoggati = new JLabel("Utenti loggati: ");
		panel_12.add(lblUtentiLoggati);
		
		lblNumUtentiLoggati = new JLabel("0");
		panel_12.add(lblNumUtentiLoggati);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		JLabel lblClientConnessi = new JLabel("Client connessi: ");
		panel_13.add(lblClientConnessi);
		
		lblNumClientConnessi = new JLabel("0");
		panel_13.add(lblNumClientConnessi);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		listUtentiLoggatiPanel = new JPanel();
		scrollPane.setViewportView(listUtentiLoggatiPanel);
		listUtentiLoggatiPanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		btnCaricaUtenti = new JButton("Carica utenti");
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
		
		regPassText = new JTextField();
		panel_6.add(regPassText);
		regPassText.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		panel_6.add(lblEmail);
		
		regEmailText = new JTextField();
		panel_6.add(regEmailText);
		regEmailText.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		panel_6.add(btnOk);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Cancella Account", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_7.setBounds(199, 61, 470, 80);
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_7.add(panel_23);
		
		JLabel lblId_1 = new JLabel("ID");
		panel_23.add(lblId_1);
		
		deleteID = new JTextField();
		panel_23.add(deleteID);
		deleteID.setColumns(20);
		
		JButton btnOk_21 = new JButton("OK");
		panel_23.add(btnOk_21);
		
		JPanel panel_22 = new JPanel();
		panel_7.add(panel_22);
		
		JLabel lblUsername_1 = new JLabel("Username");
		panel_22.add(lblUsername_1);
		
		deleteUsernameText = new JTextField();
		panel_22.add(deleteUsernameText);
		deleteUsernameText.setColumns(20);
		
		JButton btnOk_1 = new JButton("OK");
		panel_22.add(btnOk_1);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modifica Utente", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_14.setBounds(199, 147, 470, 89);
		panel.add(panel_14);
		panel_14.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16);
		
		JLabel lblUsername_2 = new JLabel("ID");
		panel_16.add(lblUsername_2);
		
		modificaIDUtente = new JTextField();
		panel_16.add(modificaIDUtente);
		modificaIDUtente.setColumns(10);
		
		JPanel panel_15 = new JPanel();
		panel_14.add(panel_15);
		
		JLabel lblPassword_1 = new JLabel("Password");
		panel_15.add(lblPassword_1);
		
		textField_1 = new JTextField();
		panel_15.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnOk_18 = new JButton("OK");
		panel_15.add(btnOk_18);
		
		JPanel panel_17 = new JPanel();
		panel_14.add(panel_17);
		
		lblNomeutenteselezionato = new JLabel("");
		panel_17.add(lblNomeutenteselezionato);
		
		JPanel panel_18 = new JPanel();
		panel_14.add(panel_18);
		
		JLabel lblEmail_1 = new JLabel("Email");
		panel_18.add(lblEmail_1);
		
		textField_2 = new JTextField();
		panel_18.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnOk_19 = new JButton("OK");
		panel_18.add(btnOk_19);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new TitledBorder(null, "Banna Utente", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_19.setBounds(199, 234, 460, 89);
		panel.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_21 = new JPanel();
		panel_19.add(panel_21);
		
		JLabel lblId = new JLabel("ID");
		panel_21.add(lblId);
		
		banID = new JTextField();
		panel_21.add(banID);
		banID.setColumns(10);
		
		JButton btnOk_17 = new JButton("OK");
		panel_21.add(btnOk_17);
		
		JPanel panel_20 = new JPanel();
		panel_19.add(panel_20);
		
		JLabel lblUsername_3 = new JLabel("Username");
		panel_20.add(lblUsername_3);
		
		banUsername = new JTextField();
		panel_20.add(banUsername);
		banUsername.setColumns(10);
		
		JButton btnOk_20 = new JButton("OK");
		panel_20.add(btnOk_20);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ranking", null, panel_1, null);
		panel_1.setLayout(null);
		
		btnRicaricaRankingProperties = new JButton("Ricarica ranking.properties");
		btnRicaricaRankingProperties.setBounds(111, 289, 161, 23);
		panel_1.add(btnRicaricaRankingProperties);
		
		JLabel lblNuovoUsername = new JLabel("Nuovo Username");
		lblNuovoUsername.setBounds(10, 20, 100, 14);
		panel_1.add(lblNuovoUsername);
		
		rankingNewUsername = new JTextField();
		rankingNewUsername.setBounds(111, 17, 140, 20);
		panel_1.add(rankingNewUsername);
		rankingNewUsername.setColumns(10);
		
		JButton btnOk_2 = new JButton("OK");
		btnOk_2.setBounds(265, 16, 89, 23);
		panel_1.add(btnOk_2);
		
		JLabel lblNuovaPassword = new JLabel("Nuova Password");
		lblNuovaPassword.setBounds(10, 50, 100, 14);
		panel_1.add(lblNuovaPassword);
		
		rankingNewPassword = new JTextField();
		rankingNewPassword.setBounds(111, 47, 140, 20);
		panel_1.add(rankingNewPassword);
		rankingNewPassword.setColumns(10);
		
		JButton btnOk_3 = new JButton("OK");
		btnOk_3.setBounds(265, 46, 89, 23);
		panel_1.add(btnOk_3);
		
		JLabel lblNuovoUseragebt = new JLabel("Nuovo User-Agent");
		lblNuovoUseragebt.setBounds(10, 80, 100, 14);
		panel_1.add(lblNuovoUseragebt);
		
		rankingNewUserAgent = new JTextField();
		rankingNewUserAgent.setBounds(111, 77, 140, 20);
		panel_1.add(rankingNewUserAgent);
		rankingNewUserAgent.setColumns(10);
		
		JButton btnOk_4 = new JButton("OK");
		btnOk_4.setBounds(265, 76, 89, 23);
		panel_1.add(btnOk_4);
		
		JLabel lblNuovoUrlRanking = new JLabel("Nuovo URL Publish");
		lblNuovoUrlRanking.setBounds(10, 110, 100, 14);
		panel_1.add(lblNuovoUrlRanking);
		
		rankingNewURLPublish = new JTextField();
		rankingNewURLPublish.setBounds(111, 107, 140, 20);
		panel_1.add(rankingNewURLPublish);
		rankingNewURLPublish.setColumns(10);
		
		JButton btnOk_5 = new JButton("OK");
		btnOk_5.setBounds(265, 106, 89, 23);
		panel_1.add(btnOk_5);
		
		JLabel lblNuovoTimesleep = new JLabel("Nuovo TIME_SLEEP");
		lblNuovoTimesleep.setBounds(10, 140, 100, 14);
		panel_1.add(lblNuovoTimesleep);
		
		rankingNewSleepTime = new JTextField();
		rankingNewSleepTime.setBounds(111, 137, 140, 20);
		panel_1.add(rankingNewSleepTime);
		rankingNewSleepTime.setColumns(10);
		
		JButton btnOk_6 = new JButton("OK");
		btnOk_6.setBounds(265, 136, 89, 23);
		panel_1.add(btnOk_6);
		
		btnForzaAggiornamentoClassifica = new JButton("Forza aggiornamento classifica");
		btnForzaAggiornamentoClassifica.setBounds(282, 289, 179, 23);
		panel_1.add(btnForzaAggiornamentoClassifica);
		
		JLabel lblNuovoUrlRanking_1 = new JLabel("Nuovo URL Ranking");
		lblNuovoUrlRanking_1.setBounds(10, 200, 100, 14);
		panel_1.add(lblNuovoUrlRanking_1);
		
		rankingNewURLRanking = new JTextField();
		rankingNewURLRanking.setBounds(111, 197, 140, 20);
		panel_1.add(rankingNewURLRanking);
		rankingNewURLRanking.setColumns(10);
		
		JButton btnOk_7 = new JButton("OK");
		btnOk_7.setBounds(265, 196, 89, 23);
		panel_1.add(btnOk_7);
		
		JLabel lblTimesleeperror = new JLabel("TIME_SLEEP_ERROR");
		lblTimesleeperror.setBounds(10, 170, 100, 14);
		panel_1.add(lblTimesleeperror);
		
		rankingNewSleepTimeError = new JTextField();
		rankingNewSleepTimeError.setBounds(111, 167, 140, 20);
		panel_1.add(rankingNewSleepTimeError);
		rankingNewSleepTimeError.setColumns(10);
		
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
		btnRiavviaServer.setBounds(10, 27, 103, 23);
		panel_8.add(btnRiavviaServer);
		
		JButton btnBloccaConnessioni = new JButton("Blocca connessioni");
		btnBloccaConnessioni.setBounds(123, 11, 127, 23);
		panel_8.add(btnBloccaConnessioni);
		
		JButton btnSbloccaConnessioni = new JButton("Sblocca connessioni");
		btnSbloccaConnessioni.setBounds(123, 45, 127, 23);
		panel_8.add(btnSbloccaConnessioni);
		
		JButton btnTerminaTutteLe = new JButton("<html><center>Termina tutte<br>le connessioni admin</center></html>");
		btnTerminaTutteLe.setBounds(260, 26, 139, 39);
		panel_8.add(btnTerminaTutteLe);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Versioni client abilitati - rimuovi", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_9.setBounds(0, 94, 669, 65);
		panel_2.add(panel_9);
		FlowLayout fl_panel_9 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_9.setLayout(fl_panel_9);
		
		JLabel lblVersioniAbilitate = new JLabel("Versioni abilitate");
		panel_9.add(lblVersioniAbilitate);
		
		versioniAbilitateChk = new JComboBox();
		panel_9.add(versioniAbilitateChk);
		
		JButton btnRimuovi = new JButton("Rimuovi");
		panel_9.add(btnRimuovi);
		
		btnCaricaVersioni = new JButton("Carica Versioni");
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
		
		addWindowListener();
		addListener();
	}
	private void addWindowListener(){
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				Messaggio m=CommunicationMessageCreator.getInstance().createLogoutMessage();
				try {
					comm.send(m);
				} 
				catch (IOException e1) {}
				super.windowClosing(e);
			}
		});
	}
	private void addListener(){
		btnCaricaUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Messaggio m=CommunicationMessageCreator.getInstance().createUserListOnline();
					comm.send(m);
					UtentiOnline uo=CommunicationParser.getInstance().parseUserListOnline(m);
					lblNumClientConnessi.setText("0");
					lblNumUtentiLoggati.setText("0");
					listUtentiLoggatiPanel.removeAll();
					if(uo!=null){
						lblNumClientConnessi.setText(""+uo.getClientConnessi());
						lblNumUtentiLoggati.setText(""+uo.getUtentiLoggati());
						GridLayout lay=(GridLayout) listUtentiLoggatiPanel.getLayout();
						lay.setRows(uo.getUtentiLoggati()<10?10:uo.getUtentiLoggati());
						for(String u:uo.getListaUtenti()){
							final String[] u_i=u.split(",");
							JButton lab=new JButton(u);
							lab.setBorderPainted(false);
							listUtentiLoggatiPanel.add(lab);
							lab.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									lblNomeutenteselezionato.setText(u_i[0]);
									banUsername.setText(u_i[0]);
									deleteUsernameText.setText(u_i[0]);
									deleteID.setText(u_i[1]);
									modificaIDUtente.setText(u_i[1]);
									banID.setText(u_i[1]);
								}
							});
						}
					}
					listUtentiLoggatiPanel.revalidate();
					listUtentiLoggatiPanel.repaint();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		modificaIDUtente.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				lblNomeutenteselezionato.setText("");
			}
		});
		btnCaricaVersioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messaggio m=CommunicationMessageCreator.getInstance().createVersioniAbilitate();
				try {
					comm.send(m);
					System.out.println(m.getResponse());
					ArrayList<Integer> l=CommunicationParser.getInstance().parseVersioniAbilitate(m);
					versioniAbilitateChk.removeAllItems();
					for(Integer i:l){
						versioniAbilitateChk.addItem(i);
					}
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRicaricaRankingProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messaggio m=CommunicationMessageCreator.getInstance().createRankingReload();
				try {
					comm.send(m);
					System.out.println(m.getResponse());
					boolean r=CommunicationParser.getInstance().parseRankingReload(m);
					JOptionPane.showMessageDialog(AdministrationFrame.this, r?"Ranking.properties caricato":m.getErrorMessage());
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
