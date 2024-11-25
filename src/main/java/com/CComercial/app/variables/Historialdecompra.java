package com.CComercial.app.variables;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Historial")
public class Historialdecompra {

	@Id
	private String id;
	private String nombre_ClienteH;
	private String productoH;
	private String cantidadH;
	private String total_compraH;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre_ClienteH() {
		return nombre_ClienteH;
	}
	public void setNombre_ClienteH(String nombre_ClienteH) {
		this.nombre_ClienteH = nombre_ClienteH;
	}
	public String getProductoH() {
		return productoH;
	}
	public void setProductoH(String productoH) {
		this.productoH = productoH;
	}
	public String getCantidadH() {
		return cantidadH;
	}
	public void setCantidadH(String cantidadH) {
		this.cantidadH = cantidadH;
	}
	public String getTotal_compraH() {
		return total_compraH;
	}
	public void setTotal_compraH(String total_compraH) {
		this.total_compraH = total_compraH;
	}
	
	
	
}
