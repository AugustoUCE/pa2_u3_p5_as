package com.example.demo.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.ventas.repository.modelo.Factura;
import com.example.demo.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
	
	public Factura seleccionarPorNumero(String numero);
	public void insertar(Factura factura);
	public void actualizar(Factura factura);
	public Factura buscar(Integer id);
	public void eliminar(Integer id);
	public int eliminarPorNumero(String  numero);
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	
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
	
	//dto
	public List<FacturaDTO> seleccionarFacturasDTO();
	//
	public List<Factura> seleccionarTodos();

}
