package com.example.demo.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.ventas.repository.modelo.Factura;

public interface IFacturaRepository {
	
	public Factura seleccionarPorNumero(String numero);
	public void insertar(Factura factura);
	
	//inner join
	public List<Factura> seleccionarInnerJoin();
	//outerjoin
	public List<Factura> seleccionarRightJoin();
	public List<Factura> seleccionarLeftJoin();
	public List<Factura> seleccionarFullJoin();
	
	//con parametros
	
	//inner join
	public Factura seleccionarInnerJoin(String numero);
	//outerjoin
	public Factura seleccionarRightJoin(String cedula);
	public Factura seleccionarLeftJoin(String cedula);
	public List<Factura> seleccionarFullJoin(LocalDateTime fecha);
	
	//
	
	public List<Factura> seleccionarFacturaWhereJoin();

	public List<Factura> seleccionarFacturasFetchJoin(); 

}
