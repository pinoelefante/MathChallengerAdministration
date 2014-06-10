package it.mathchallenger.admin.gui;

import it.mathchallenger.admin.communication.Communication;
import it.mathchallenger.admin.communication.CommunicationMessageCreator;
import it.mathchallenger.admin.communication.CommunicationParser;
import it.mathchallenger.admin.communication.Messaggio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;

	private JButton btnLogin;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private static Communication comm;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		comm=Communication.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txt_username = new JTextField();
		txt_username.setBounds(94, 11, 170, 20);
		panel.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 14, 74, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 49, 74, 14);
		panel.add(lblPassword);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(94, 42, 170, 20);
		panel.add(txt_password);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(94, 73, 89, 23);
		panel.add(btnLogin);
		
		addListener();
	}
	private void addListener(){
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=txt_username.getText().trim();
				String pass=new String(txt_password.getPassword()).trim();
				if(username.length()>0 && pass.length()>0){
					Messaggio m=CommunicationMessageCreator.getInstance().createLoginMessage(username, pass);
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseLogin(m)){
							JFrame frame_app=new AdministrationFrame();
							frame_app.setVisible(true);
							LoginFrame.this.dispose();
						}
						else 
							JOptionPane.showMessageDialog(LoginFrame.this, m);
					} 
					catch (IOException e) {
						JOptionPane.showMessageDialog(LoginFrame.this, "Si è verificato un errore durante la trasmissione dei dati");
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(LoginFrame.this, "Devi compilare tutti i campi");
				}
			}
		});
	}
}
