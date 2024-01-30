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

		System.out.println("JOIN WHERE");
		
		List<Factura> lista = this.facturaService.buscarFacturaWhereJoin();
		for (Factura factura : lista) {
			System.out.println(factura.getNumero());
			for (DetalleFactura df : factura.getDetalleFacturas()) {
				System.out.println(df.getNombreProducto());
			}
		}
		
System.out.println("JOIN FETCH ");
		
		List<Factura> lista2 = this.facturaService.buscarFacturasFetchJoin();
		for (Factura factura2 : lista2) {
			System.out.println(factura2.getNumero());
			for (DetalleFactura d : factura2.getDetalleFacturas()) {
				System.out.println(d.getNombreProducto());
				
			}
		}
		

	}

}
