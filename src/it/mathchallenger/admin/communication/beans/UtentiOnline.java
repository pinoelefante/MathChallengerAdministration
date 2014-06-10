package it.mathchallenger.admin.communication.beans;

import java.util.ArrayList;

public class UtentiOnline {
	ArrayList<String> utenti;
	private int client_online;
	private int loggati;
	
	public UtentiOnline(){
		utenti=new ArrayList<>();
	}
	public void addUser(String u){
		if(utenti!=null)
			utenti.add(u);
	}
	public int getClientConnessi(){
		return client_online;
	}
	public int getUtentiLoggati(){
		return loggati;
	}
	public void setClientConnessi(int i){
		client_online=i;
	}
	public void setUtentiLoggati(int i){
		loggati=i;
	}
	public ArrayList<String> getListaUtenti(){
		return utenti;
	}
	public void cleanAll(){
		utenti.clear();
		utenti.trimToSize();
		utenti=null;
		client_online=0;
		loggati=0;
	}
}
