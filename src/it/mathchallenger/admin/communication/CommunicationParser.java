package it.mathchallenger.admin.communication;

import java.util.ArrayList;

import it.mathchallenger.admin.communication.beans.UtentiOnline;

public class CommunicationParser {

	private static CommunicationParser sing;

	public static CommunicationParser getInstance() {
		if (sing == null)
			sing = new CommunicationParser();
		return sing;
	}

	private CommunicationParser() {}

	public boolean parseLogin(Messaggio res) {
		String[] properties = res.getResponse().split(";");
		boolean loginOK = false;
		
		for (int i = 0; i < properties.length; i++) {
			String[] kv = properties[i].split("=");
			switch (kv[0]) {
				case "login":
					if (kv[1].compareTo("OK") == 0)
						loginOK = true;
					break;
				case "message":
					res.setErrorMessage(kv[1]);
					break;
			}
		}
		return loginOK;
	}
	public UtentiOnline parseUserListOnline(Messaggio m){
		String [] prop=m.getResponse().split(";");
		UtentiOnline uo=null;
		for(int i=0;i<prop.length;i++){
			String[] kv=prop[i].split("=");
			switch(kv[0]){
				case "user_list_online":
					if(kv[1].compareTo("OK")==0)
						uo=new UtentiOnline();
					break;
				case "utente":
					uo.addUser(kv[1]);
					break;
				case "loggati":
					uo.setUtentiLoggati(Integer.parseInt(kv[1]));
					break;
				case "client_attivi":
					uo.setClientConnessi(Integer.parseInt(kv[1]));
					break;
				case "message":
					m.setErrorMessage(kv[1]);
					break;
			}
		}
		return uo;
	}
	public ArrayList<Integer> parseVersioniAbilitate(Messaggio m){
		ArrayList<Integer> versioni=new ArrayList<Integer>();
		String[] prop=m.getResponse().split(";");
		for(int i=0;i<prop.length;i++){
			String[] kv=prop[i].split("=");
			switch(kv[0]){	
				case "version_get_client_enabled":
					break;
				case "version":
					versioni.add(Integer.parseInt(kv[1]));
					break;
				case "message":
					m.setErrorMessage(kv[1]);
					break;
			}
		}
		return versioni;
	}
	public boolean parseRankingReload(Messaggio m){
		String[] prop=m.getResponse().split(";");
		for(int i=0;i<prop.length;i++){
			String[] kv=prop[i].split("=");
			switch(kv[0]){
				case "ranking_reload":
					if(kv[1].compareTo("OK")==0)
						return true;
					break;
				case "message":
					m.setErrorMessage(kv[1]);
					break;
			}
		}
		return false;
	}
}
