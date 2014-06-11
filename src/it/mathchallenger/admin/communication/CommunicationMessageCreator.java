package it.mathchallenger.admin.communication;

import java.util.ArrayList;

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
	public Messaggio createUserDeleteByUsername(String u){
		return new Messaggio("user_delete_username "+u);
	}
	public Messaggio createUserDeleteByID(int id){
		return new Messaggio("user_delete_id "+id);
	}
	public Messaggio createVersioniAbilitate(){
		return new Messaggio("version_get_client_enabled");
	}
	public Messaggio createVersionAdd(int v){
		return new Messaggio("version_add_client_enabled "+v);
	}
	public Messaggio createVersionRemove(int v){
		return new Messaggio("version_remove_client_enabled "+v);
	}
	public Messaggio createVersionReload(){
		return new Messaggio("version_reload_client_enabled");
	}
	public Messaggio createRankingReload(){
		return new Messaggio("ranking_reload");
	}
	public Messaggio createRankingChangeValues(ArrayList<String> v){
		StringBuilder str=new StringBuilder("ranking_change_all_values");
		for(String s:v){
			str.append(" "+s);
		}
		return new Messaggio(str.toString());
	}
	public Messaggio createRankingForceUpdate(){
		return new Messaggio("ranking_force_update");
	}
	public Messaggio createEmailReload(){
		return new Messaggio("email_reload_properties");
	}
	public Messaggio createEmailChangeValues(ArrayList<String> v){
		StringBuilder str=new StringBuilder("email_change_all_values");
		for(String s:v){
			str.append(" "+s);
		}
		return new Messaggio(str.toString());
	}
}
