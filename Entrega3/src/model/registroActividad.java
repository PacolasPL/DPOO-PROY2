package model;

import java.util.*;

public class registroActividad {
	
	private ArrayList<registro> registros = new ArrayList<registro>();
	
	public registroActividad(integrante Lider) {
		actividad creacion = new actividad("Creacion proyecto", "Administrativa" ,Lider);
		registro inicial = new registro(Lider, creacion);
		registros.add(inicial);
		
	}
	
	public void addLog(registro log ) {
		registros.add(log);
	}
	public void delLastLog(int pos ) {
		registros.remove(pos);
	}
	// Funci�n para traer una lista basada en arreglo con los registros
	// de un usuario dado
	
	public ArrayList<registro> getLogsFromUser(integrante usuario) {
		ListIterator<registro> regIt = registros.listIterator();
		ArrayList<registro> delUsuario = new ArrayList<registro>();
		int logs = 0;
		while(regIt.hasNext()) {
			registro reg = regIt.next();
			if(reg.getAmigoName().equals( usuario.getName())) {
				logs += 1;
				delUsuario.add(reg);
		}
		}
		System.out.println("Se consiguieron " + logs + " registros.");
		return delUsuario;
	}
	public String getStringLogsFromUser(integrante usuario) {
		ListIterator<registro> regIt = registros.listIterator();
		String delUsuario = "";
		int logs = 0;
		while(regIt.hasNext()) {
			registro reg = regIt.next();
			if( reg.getAmigoName().equals( usuario.getName())) {
				logs += 1;
				String temp = Integer.toString(logs) +"- "+ reg.createInd()+"\n" ;
				delUsuario+= temp;
			}
				
		}
		if (delUsuario.equals("")) {
			delUsuario = "\nEste usuario no ha hecho nada.\n";
		}
		System.out.println("Se consiguieron " + logs + " registros.");
		return delUsuario;
	}
	public ListIterator<registro> getRegistros(){
		return registros.listIterator();
	}
}
