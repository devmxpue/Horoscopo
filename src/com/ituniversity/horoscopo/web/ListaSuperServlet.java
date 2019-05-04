package com.ituniversity.horoscopo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ituniversity.horoscopo.modelo.Articulo;
import com.ituniversity.horoscopo.modelo.Carrito;

/**
 * Servlet implementation class ListaSuperServlet
 */
@WebServlet("/listasuper")
public class ListaSuperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaSuperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		HttpSession session = request.getSession(true);
		Carrito cart =(Carrito) session.getAttribute("carrito");
		if(cart != null){
			out.println("<table>");
			for(Articulo art: cart.getListaArticulos()){
				out.println("<tr>");
				out.println("<td>"+art.getNombreArticulo()+"</td>");
				out.println("<td>"+art.getTipo()+"</td>");
				out.println("<td>"+art.getPrecio()+"</td>");
				out.println("<td>"+art.getCantidad()+"</td>");
				out.println("<td>"+art.getCosto()+"</td>");
				out.println("</tr>");
			}
				out.println("<tr>");
				out.println("<tr><td colspan='5'>Subtotal"+cart.getSubtotal()+"</td>");
				out.println("<tr><td colspan='5'>Impuesto"+cart.getImpuesto()+"</td>");
				out.println("<tr><td colspan='5'>Total"+cart.getTotal()+"</td>");
				out.println("</tr>");
				out.println("</table>");
				return;
		}
		out.println("<div>No hay articulos en el carrito</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		//Obteniendo datos del cliente al servidor carritoform.jsp
		String nombreArticulo = request.getParameter("inputArticulo");
		int cantidad = new Integer(request.getParameter("inputCantidad"));
		String tipo = request.getParameter("inputTipo");
		double precio = Math.random ()*50;
		double costo = precio * cantidad;
		// objeto articulo
		Articulo art = new Articulo(nombreArticulo,cantidad,tipo,precio, costo);
		
		// obtenemos la session
		HttpSession session = request.getSession(true);
		Carrito cart= null;
		if(session.getAttribute("carrito")== null){
			cart = new Carrito ();
			session.setAttribute("carrito", cart);
		}
		cart = (Carrito) session.getAttribute("carrito");
		double subt = cart.getSubtotal() + costo;
		double impuesto = cart.getImpuesto() + (costo * 0.10);
		double total = cart.getTotal()+ costo + (costo *0.10);
		cart.getListaArticulos().add(art);
		cart.setSubtotal(subt);
		cart.setImpuesto(impuesto);
		cart.setTotal(total);
		session.setAttribute("carrito", cart);
		out.println("<h1 class='alert alert-info'>Articulo"+nombreArticulo+"agregado correctamente</h1>");
		out.println("<a href='carritoform.jsp'> Agregar mas</a>");
		out.println("<a href ='listasuper'> ver carrito</a>");
			}

}
