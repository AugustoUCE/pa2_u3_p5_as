package com.example.demo.ventas.service;

import java.util.concurrent.TimeUnit;

import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.ventas.repository.IClienteRepository;
import com.example.demo.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	@Async
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		try {
			this.clienteRepository.insertar(cliente);
		/*	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("ERROR");
		}
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("este es un metodo supports");
		System.out.println("prueba supoorts: " + TransactionSynchronizationManager.isActualTransactionActive());
	}

	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("este es un metodo NEVER");
		System.out.println("prueba NEVER: " + TransactionSynchronizationManager.isActualTransactionActive());
	}

}
