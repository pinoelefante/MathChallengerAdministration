package it.mathchallenger.admin.communication;

public class CommunicationMessageCreator {
	private static CommunicationMessageCreator singleton;
	public static CommunicationMessageCreator getInstance() {
		if(singleton==null)
			singleton=new CommunicationMessageCreator();
		return singleton;
	}
	
	private CommunicationMessageCreator() {}

	public Messaggio createLogoutMessage() {
		return new Messaggio("logout");
	}
	public Messaggio createLoginMessage(String username, String pass){
		return new Messaggio("login "+username+" "+pass);
	}
	public Messaggio createUserListOnline(){
		return new Messaggio("user_list_online");
	}
	public Messaggio createVersioniAbilitate(){
		return new Messaggio("version_get_client_enabled");
	}
	public Messaggio createRankingReload(){
		return new Messaggio("ranking_reload");
	}
}
