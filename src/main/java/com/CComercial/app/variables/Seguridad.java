package com.CComercial.app.variables;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seguridad")
public class Seguridad {
	 @Id
	    private String id;
	 	private String cedula;
	    private String nombre;
	    private String apellido;
	    private String telefono;
	    private LocalTime horaEntrada;
	    private LocalTime horaSalida;
	    private String zona;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public LocalTime getHoraEntrada() {
			return horaEntrada;
		}
		public void setHoraEntrada(LocalTime horaEntrada) {
			this.horaEntrada = horaEntrada;
		}
		public LocalTime getHoraSalida() {
			return horaSalida;
		}
		public void setHoraSalida(LocalTime horaSalida) {
			this.horaSalida = horaSalida;
		}
		public String getZona() {
			return zona;
		}
		public void setZona(String zona) {
			this.zona = zona;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
	    
}
