package com.ituniversity.horoscopo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumeroSuerteServlet
 */
//@WebServlet("/suerte")
public class NumeroSuerteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contador=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumeroSuerteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String signo = request.getParameter("signo");
		PrintWriter out = response.getWriter();
		LocalDateTime localocal = LocalDateTime.now();
		Date fecha = new  Date();
		SimpleDateFormat formato = new SimpleDateFormat(" 'dia' EEE 'de' dd-MM-YYYY 'a' hh:mm a");
		//Date fecha = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
		// casteo para mostrar un tipo entero ya la funciomn math  mostrara un double
		int numeroDeLaSuerte = (int)(Math.random()*100);
		out.println("<!DOCTYPE html>");
		out.println("<DIV style = 'font-size:46px;background-color:gray;color:white'>"+ "Hola " + signo + " Tu numero de la suerte es "  + numeroDeLaSuerte + "</DIV>");
		out.println("<div class='alert alert-info'>La fecha es :"+ formato.format(fecha)+ " </div>");
		out.println("<div>"+ localocal.format(DateTimeFormatter.ofPattern(" 'dia' EEE 'de' dd-MM-YYYY 'a' hh:mm a"))+ " </div>");
		out.println("<div class='jumbotron text-info'> Se ha visitado esta pagina :"+ ++contador +" veces</div>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
