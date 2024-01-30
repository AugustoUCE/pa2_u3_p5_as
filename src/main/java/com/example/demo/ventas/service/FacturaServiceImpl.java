package com.example.demo.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ventas.repository.IFacturaRepository;
import com.example.demo.ventas.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void guardar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.insertar(factura);
	}

	@Override
	public List<Factura> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Factura> buscarRightJoin() {
		// TODO Auto-generated method stub
		return  this.facturaRepository.seleccionarRightJoin();
	}

	@Override
	public List<Factura> buscarLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarLeftJoin();
	}

	@Override
	public  Factura buscarInnerJoin(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarInnerJoin(numero);
	}

	@Override
	public Factura buscarRightJoin(String cedula) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarRightJoin(cedula);
	}

	@Override
	public Factura buscarLeftJoin(String cedula) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarLeftJoin(cedula);
	}

	@Override
	public List<Factura> buscarFullJoin(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFullJoin(fecha);
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturaWhereJoin();
	}

	@Override
	public List<Factura> buscarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasFetchJoin();
	}

}
