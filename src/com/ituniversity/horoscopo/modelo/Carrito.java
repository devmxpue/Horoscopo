package com.ituniversity.horoscopo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List<Articulo> listaArticulos = new ArrayList<>() ;
	private double subtotal;
	private double impuesto;
	private double total; 
	public Carrito() {
		// TODO Auto-generated constructor stub
	}
	public Carrito(List<Articulo> listaArticulos, double subtotal, double impuesto, double total) {
		super();
		this.listaArticulos = listaArticulos;
		this.subtotal = subtotal;
		this.impuesto = impuesto;
		this.total = total;
	}
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}
	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
