package com.example.demo.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.ventas.repository.modelo.Factura;

public interface IFacturaService {
	
	public Factura buscarPorNumero(String numero);
	public void guardar(Factura factura);
	
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

}
