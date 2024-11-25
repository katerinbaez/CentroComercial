package com.CComercial.app.variables;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Compra")
public class Compra {

	@Id
	private String id;
	private String nombre_Cliente;
	private String producto;
	private String cantidad;
	private String precio_unidad;
	private String total;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre_Cliente() {
		return nombre_Cliente;
	}
	public void setNombre_Cliente(String nombre_Cliente) {
		this.nombre_Cliente = nombre_Cliente;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio_unidad() {
		return precio_unidad;
	}
	public void setPrecio_unidad(String precio_unidad) {
		this.precio_unidad = precio_unidad;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
}
