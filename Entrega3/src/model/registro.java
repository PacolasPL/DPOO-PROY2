package model;
import java.time.*;
import static java.time.temporal.ChronoUnit.SECONDS;

public class registro {
	private LocalDateTime inicio;
	private String aCargoDe;
	private String actividadTrabajada;
	private String comentarios;
	private int segundosTranscurrido;
	private LocalDateTime tiempoFinalizado;

	
	public registro(integrante amigo, actividad act) {
		this.aCargoDe = amigo.getName();
		this.actividadTrabajada = act.getName();	
		this.inicio = LocalDateTime.now();
		}
	
	public String getAmigoName() {
		return aCargoDe;
	}
	
	public String getActivityName() {
		return actividadTrabajada;
	}
	
	public String getDateInicio() {
		return inicio.toString();
	}
	public String getDateFinal() {
		return tiempoFinalizado.toString();
	}
	public String getComments() {
		return this.comentarios;
	}
	
	public String createString() {
		String data = "";
		data += "\nActividad: " + actividadTrabajada +"\n";
		data += "Amigo: " + aCargoDe;
		data += "\nFecha de Inicio: " + inicio.toString() +"\n";
		data += "\nComentarios: "+ comentarios;
		data += "\nTiempo transcurrido: " +  Math.abs((segundosTranscurrido/3600)) + " horas, "+ Math.abs((segundosTranscurrido%3600)/60)  +" minutos y " +Integer.toString(Math.abs(segundosTranscurrido%60))+ " segundos." ;
		data += "\nFecha de finalizacion de turno: " + tiempoFinalizado.toString() +"\n";
		return data;	
	}
	
	public void putAll(LocalDateTime inicio, LocalDateTime finaL , int tiempoFinal , String comentario) {
		this.comentarios = "Hecho fuera de tiempo";
		this.inicio = inicio;
		this.tiempoFinalizado = finaL;
		this.segundosTranscurrido = tiempoFinal;
		this.comentarios = comentario;
	}
	
	public int terminarTurno(String comentario) {
		this.comentarios = comentario;
		tiempoFinalizado = LocalDateTime.now();
		long seconds = SECONDS.between(tiempoFinalizado, inicio);
		int sec =  (int)seconds;
		this.segundosTranscurrido = sec;
		return segundosTranscurrido ;
		
	}
	public String createInd() {
		String data = inicio.toString().replace("T", " ") + " --- " + actividadTrabajada + " trabajada por "+ aCargoDe;
		return data;
	}
	public int getTime() {
		return segundosTranscurrido;
	}
}
