package model;
import java.util.*;

public class integrante {
	private String name;
	private String correo;
	private String password;
	private HashMap<String, actividad> actividades = new HashMap<String, actividad>();
	private HashMap<String, actividad>actividadesHechas = new HashMap<String, actividad>();
	private HashMap<String, String> proyectos;
	
	public integrante(String name, String correo, String password) {
		this.name = name;
		this.correo =  correo;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	
	public void setActivities(actividad activity) {
		
		actividades.put(activity.getName(), activity);
	}
	public String hasAct(String activity) {
		if (actividades.containsKey(activity)) {
			return "Si se logro";
		}
		return "No se logro";
	}
	
	
	public void setActivitiesFinal(actividad activity) {
		
		actividadesHechas.put(activity.getName(), activity);
		
	}
	
	public actividad getActividad(String nameAct) {
		actividad act = actividades.get(nameAct.strip());
		return act ;
	}
	
	public String[] mostrarPendientes()
	{
		String[] toUse = actividades.keySet().toString().replace("[", "").replace("]", "").split(",");
		return toUse;
	}
	
	public String getCorreo() {
		return correo;
	}
	public boolean comparePass(String pass) {
		if(pass.equals( password)) {
			return true;
		}
		else {
			return false;
		}
			
	}
	public void addProyect(String nameProy , String isLider) {
		if (proyectos == null) {
			proyectos = new HashMap<String, String>();
		}
		proyectos.put(nameProy, isLider);
	}
	
	public String getProyect() {
		if (proyectos == null) {
			return null;
		}
		else {
			String Names = proyectos.keySet().toString().replace("[","").replace("]","").strip();
			return Names;
		}
	}
	public String[] getProyListAmi() {
		
		String temp =  getProyect( );
		String[] list = temp.split(",");
		
		return list;	
	}
	
	public boolean isLider(String proyecto) {
		boolean Lider =  false;
		if (proyectos.get(proyecto).equals("true")) {
			Lider = true;
		}
		return Lider;
	}
}
