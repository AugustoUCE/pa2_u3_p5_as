package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
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
	
		/*System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		for (int i = 0; i <= 10; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			this.clienteService.guardar(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		System.out.println("Tiempo Transcurrido[s]: "+tiempoTranscurrido);
		*/
		
		//programacion en paralelo
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		List<Cliente >listCliente = new ArrayList<>();
		for(int i=1;i<=50;i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			listCliente.add(cliente);
		}
		listCliente.parallelStream().forEach(cliente -> this.clienteService.guardar(cliente));
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoFinal-tiempoInicial;
		System.out.println("Tiempo Transcurrido[s]: "+tiempoTranscurrido);
	}

}
