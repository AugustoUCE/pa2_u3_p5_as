package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.ventas.repository.modelo.Cliente;
import com.example.demo.ventas.repository.modelo.DetalleFactura;
import com.example.demo.ventas.repository.modelo.Factura;
import com.example.demo.ventas.repository.modelo.dto.FacturaDTO;
import com.example.demo.ventas.service.IClienteService;
import com.example.demo.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5AsApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		
		Factura fact = new Factura();
		fact.setCedula("1478654578");
		fact.setFecha(LocalDateTime.now());
		fact.setNumero("0001-002");
		
		Cliente cl = new Cliente();
		cl.setApellido(null);
		cl.setNombre("augusto");
		
		//this.facturaService.guardar(fact,cl);

		//this.clienteService.guardar(null);
		
		System.out.println("Main:"+TransactionSynchronizationManager.isActualTransactionActive());
		this.facturaService.prueb();
		
		
	}

}
