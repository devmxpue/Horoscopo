package com.ituniversity.horoscopo.modelo;

public class Articulo {
   //atributos
	private String nombreArticulo;
	private int cantidad = 0;
	private String tipo;
	private double precio;
	private double costo;
	//constructor default
	public Articulo() {
		// TODO Auto-generated constructor stub
	}
		//Contructor con valores
	public Articulo(String nombreArticulo, int cantidad, String tipo, double precio, double costo) {
		super();
		this.nombreArticulo = nombreArticulo;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.precio = precio;
		this.costo = costo;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
}
