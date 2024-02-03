package com.example.demo.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.ventas.repository.modelo.Cliente;
import com.example.demo.ventas.repository.modelo.Factura;
import com.example.demo.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {
	
	public Factura buscarPorNumero(String numero);
	public void guardar(Factura factura,Cliente cliente);
	
	public List<Factura> buscarInnerJoin();
	
	//outr join
	public List<Factura> buscarRightJoin();
	public List<Factura> buscarLeftJoin();
	
	//con parametros
	
	//inner join
	public  Factura buscarInnerJoin(String numero);
	
	public Factura  buscarRightJoin(String cedula);
	public Factura  buscarLeftJoin(String cedula);
	public List<Factura>  buscarFullJoin(LocalDateTime fecha);
	//
	
	public List<Factura>  buscarFacturaWhereJoin();
	public List<Factura>  buscarFacturasFetchJoin(); 
	
	//
	
	public void actualizar(Factura factura);
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	public int eliminarPorNumero(String numero);
	
	//dto
	public List<FacturaDTO> buscarFacturasDTO();

}
