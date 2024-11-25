package com.CComercial.app.variables;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "tiendas")
public class Tienda {

	 	@Id
	    private String id;
	 	
	 	private String nombre;
	    private int numeroLocal;
	    private String seguridad;
	    private LocalTime horaApertura;
	    private LocalTime horaCerrado;
	    private String ubicacionZona;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getNumeroLocal() {
			return numeroLocal;
		}
		public void setNumeroLocal(int numeroLocal) {
			this.numeroLocal = numeroLocal;
		}
		public String getSeguridad() {
			return seguridad;
		}
		public void setSeguridad(String seguridad) {
			this.seguridad = seguridad;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public LocalTime getHoraApertura() {
			return horaApertura;
		}
		public void setHoraApertura(LocalTime horaApertura) {
			this.horaApertura = horaApertura;
		}
		public LocalTime getHoraCerrado() {
			return horaCerrado;
		}
		public void setHoraCerrado(LocalTime horaCerrado) {
			this.horaCerrado = horaCerrado;
		}
		public String getUbicacionZona() {
			return ubicacionZona;
		}
		public void setUbicacionZona(String ubicacionZona) {
			this.ubicacionZona = ubicacionZona;
		}
	    
}
