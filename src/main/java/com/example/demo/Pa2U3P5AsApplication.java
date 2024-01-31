package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.ventas.repository.modelo.DetalleFactura;
import com.example.demo.ventas.repository.modelo.Factura;
import com.example.demo.ventas.repository.modelo.dto.FacturaDTO;
import com.example.demo.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5AsApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
/*
		int cantidad =this.facturaService.actualizarFechas(
				LocalDateTime.of(2020, 1, 15, 12, 50),
				LocalDateTime.of(2024, 1, 25, 23, 59)
				);
		System.out.println("Cantidad de registros/filas actulizados: "+cantidad);
		*/
	/*	
		int cantidad =this.facturaService.eliminarPorNumero("0001-02571");
		System.out.println("Cantidad de registros/filas actulizados: "+cantidad);
*/
		
		System.out.println("DTO");
		List<FacturaDTO> list = this.facturaService.buscarFacturasDTO();
		for (FacturaDTO facturaDTO : list) {
			System.out.println(facturaDTO);
		}
		
		
		
		
		
	}

}
