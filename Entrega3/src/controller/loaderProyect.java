package controller;
import model.*;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.io.BufferedReader;
/*import java.io.BufferedWriter;*/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class loaderProyect {
	
	// La clase loaderProyect solo posee un atributo:
	//
	// Un HashMap con los usuarios de un proyecto dado.
	
	private static HashMap<String, integrante> usuarios= new HashMap<String, integrante>();
	
	// Se carga un archivo en base al nombre del proyecto que se desee cargar.
	
	public static controladorProyecto cargarArchivo(String archivo) throws FileNotFoundException, IOException{
		
		String proName = "";
		String LiName= "";
		String dateString = "";
		String timeString= "";

		
		BufferedReader br =  new BufferedReader(new FileReader("./data/proyectos.txt"));
		String linea = br.readLine();
		boolean continuar = true;
		System.out.println("BUSCANDO SU PROYECTO...");
		
		while (linea != null && continuar == true) {
			String[] partes= linea.split(";");
			if (partes[0].equals(archivo) ) {
				continuar = false;
				
				
				proName = partes[0].strip();
				LiName =  partes[1].strip();
				dateString = partes[3].strip();
				timeString= partes[4].strip();
			}	
			linea = br.readLine();
			
		}
		
		br.close();
		
		if (continuar ) {
			System.out.println("PROYECTO NO ENCONTRADO.");
			return null;
		}
		
		integrante Lider = usuarios.get(LiName);
		
		BufferedReader brIntegrantes =  new BufferedReader(new FileReader("./data/" + proName + "_integrantes.txt"));
		String persona = brIntegrantes.readLine(); 
		HashMap<String, integrante> integrantes = new HashMap<String, integrante>();
		System.out.println("INICIANDO CARGA DE INTEGRANTES\n");
		while (persona != null) {
			integrante amigo = usuarios.get(persona);
			if (amigo != null) {
				integrantes.put(persona, amigo);
			
			}
			persona = brIntegrantes.readLine();
		}
		
		brIntegrantes.close();
		
		proyecto Proy = new proyecto(Lider, proName);
		Proy.putIntegrantes(integrantes);
		dateString = dateString.replace("T"," ").substring(0,19);
		Proy.putStartdate(Lider.getName(), dateString);
		Proy.putCurrentTime(timeString);
		
		BufferedReader brActividades =  new BufferedReader(new FileReader("./data/" + proName + "_actividades.txt"));
		String actividad = brActividades.readLine();
		
		System.out.println("INICIANDO CARGA DE ACTIVIDADES\n");
		
		while (actividad != null) {
			String[] actParts = actividad.split(";");
			
			integrante principal =  usuarios.get(actParts[2].strip());
			actividad nuevAct = new actividad(actParts[0].strip(),actParts[1].strip() , principal);
			nuevAct.setTiempo(Integer.parseInt(actParts[3].strip()));
			
			if (actParts[4].strip().equals("true")) {
				Proy.agregarActividad(nuevAct);
				principal.setActivities(nuevAct);}
				
			
			else if (actParts[4].strip().equals( "false")) {
				Proy.finalizarActividad(nuevAct);
				principal.setActivitiesFinal(nuevAct);
			
			
			}
			actividad = brActividades.readLine();
			
		}
		brActividades.close();
		
		
		
		BufferedReader rg =  new BufferedReader(new FileReader("./data/"+ proName+"_registro.txt"));
		linea = rg.readLine();
		continuar = true;
		System.out.println("CARGANDO EL REGISTRO DE ACTIVIDAD");
		
		while (linea != null && continuar == true && linea.strip() != "" ) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") ;
			String[] partes= linea.split(";");
			
			String act = partes[0].strip();
			String aCargoDe = partes[1].strip();
			String fecha1 = partes[2].strip().replace("T"," ").substring(0,19);
			String fecha2 = partes[3].strip().replace("T"," ").substring(0,19);
			String comentario = partes[4].strip();
			
			LocalDateTime tiempo1 = LocalDateTime.parse(fecha1, format);
			LocalDateTime tiempo2 = LocalDateTime.parse(fecha2, format);
			long time = SECONDS.between(tiempo1, tiempo2);
			
			
			actividad acTemp = new actividad(act,"Temporal", usuarios.get(aCargoDe)) ;
			registro temp = new registro(usuarios.get(aCargoDe), acTemp);
			
			temp.putAll(tiempo1, tiempo2, (int)time, comentario);
			Proy.addLog(temp);

			linea = rg.readLine();
			
		}
		
		rg.close();
		controladorProyecto controlador = new controladorProyecto();
		controlador.agregarProyecto(Proy);
		return controlador;
			
		
	}
	
	// Se retorna los usuarios dentro del HashMap del loaderProyect.
	
	public static HashMap<String, integrante> getUserList() throws FileNotFoundException, IOException {
		
		getUsuarios();
		return usuarios;
	}
	
	// Se a�ade los proyectos segun el archivo de usuarios a un usuario dado.
	
	private static void getUsuarios() throws FileNotFoundException, IOException {
		BufferedReader brUsuarios =  new BufferedReader(new FileReader("./data/usuarios.txt"));
		String linea = brUsuarios.readLine();
		
		while (linea != null) {
			
			String[] partes = linea.split(";");
			String name =  partes[0];
			String correo = partes[1];
			String password = partes[2];
			
			integrante nuevo = new integrante(name, correo, password);
			
			
			if (partes.length==4) {
				String [] grupos = partes[3].split(",");
				for ( int i = 0 ; i< grupos.length ; i++){
					String[] pryData = grupos[i].split(":");
					
					nuevo.addProyect(pryData[0].strip(), pryData[1].strip());
					
					}
				}
			usuarios.put(name, nuevo);
			
			linea = brUsuarios.readLine();
		}
		brUsuarios.close();		
		
	}
	
	
	
}
