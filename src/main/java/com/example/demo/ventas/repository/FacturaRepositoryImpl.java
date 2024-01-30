package com.example.demo.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f WHERE f.numero=:var";
		TypedQuery<Factura> myQuery= this.entityManager.createQuery(jpql,Factura.class);
		myQuery.setParameter("var", numero);
		//Lazy inicializar 
		Factura fact=myQuery.getSingleResult();
		fact.getDetalleFacturas().size(); //le digo que cargue el detalle bajo demanda y con el size 
		
		
		return fact;
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
		
	}

	@Override
	public List<Factura> seleccionarInnerJoin() {
		// TODO Auto-generated method stub
		//SQL:select * from factura f inner join detalle_factura d 
		//on f.fact_id=d.defa_id_factura
		String jpql="SELECT f FROM Factura f JOIN f.detalleFacturas d";
		
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(jpql,Factura.class);
		
		//inicializamos el lazy para una list
		List<Factura> lista = myQuery.getResultList();
		for (Factura factura : lista) {
			factura.getDetalleFacturas().size();
		}
		
				
		
		return lista ;
	}

	@Override
	public List<Factura> seleccionarRightJoin() {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f RIGHT JOIN f.detalleFacturas d";
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(jpql,Factura.class);
		
		List<Factura> list1=myQuery.getResultList();
		for (Factura factura1 : list1) {
			factura1.getDetalleFacturas().size();
		}
		
		return list1;
	}

	@Override
	public List<Factura> seleccionarLeftJoin() {
		// TODO Auto-generated method stub
		
		String jpql="SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d";
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(jpql,Factura.class);
		
		List<Factura> list2=myQuery.getResultList();
		for (Factura factura2 : list2) {
			factura2.getDetalleFacturas().size();
			
		}
		return list2;
	}

	@Override
	public List<Factura> seleccionarFullJoin() {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f FULL JOIN f.detalleFacturas d";
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(jpql,Factura.class);
		List<Factura> list3=myQuery.getResultList();
		for (Factura factura3 : list3) {
			factura3.getDetalleFacturas().size();
			
		}
		
		return list3;
	}

	@Override
	public Factura seleccionarInnerJoin(String numero) {
		// TODO Auto-generated method stub
		
		String jpql="SELECT f FROM Factura f JOIN f.detalleFacturas d WHERE f.numero = :var";
		
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql,Factura.class);
		myQuery.setParameter("var", numero);
		Factura factura4 = myQuery.getSingleResult();
		
		factura4.getDetalleFacturas().size();
		
		return factura4;
	}

	@Override
	public Factura seleccionarRightJoin(String cedula) {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f RIGHT JOIN f.detalleFacturas d WHERE f.cedula = :var";
		
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql,Factura.class);
		myQuery.setParameter("var", cedula);
		Factura factura4 = myQuery.getSingleResult();
		
		factura4.getDetalleFacturas().size();
		
		return factura4;
	}

	@Override
	public Factura seleccionarLeftJoin(String cedula) {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d WHERE f.cedula = :var";
		
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql,Factura.class);
		myQuery.setParameter("var", cedula);
		Factura factura4 = myQuery.getSingleResult();
		
		factura4.getDetalleFacturas().size();
		
		return factura4;
	}

	@Override
	public List<Factura> seleccionarFullJoin(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f FULL JOIN f.detalleFacturas d WHERE f.fecha >=:var";
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(jpql,Factura.class);
		myQuery.setParameter("var", fecha);
		List<Factura> list6=myQuery.getResultList();
		for (Factura factura6 : list6) {
			factura6.getDetalleFacturas().size();
			
		}
		
		return list6;
	}

	@Override
	public List<Factura> seleccionarFacturaWhereJoin() {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f ,DetalleFactura d WHERE f = d.factura";
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(jpql,Factura.class);
		List<Factura> lista7 = myQuery.getResultList();
		for (Factura factura7 : lista7) {
			factura7.getDetalleFacturas().size();
		}
		
		return lista7;
	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		//cuanto tengo varias consultas y muchos select's
		String jpql="SELECT f FROM Factura f JOIN FETCH f.detalleFacturas d ";
		TypedQuery<Factura> myQuery= this.entityManager.createQuery(jpql,Factura.class);
		
		return myQuery.getResultList();
	}


}
