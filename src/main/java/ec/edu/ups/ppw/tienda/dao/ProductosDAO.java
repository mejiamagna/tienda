package ec.edu.ups.ppw.tienda.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.tienda.modelo.Productos;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductosDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Productos producto) {
		em.persist(producto);
	}
	
	public void update(Productos producto) {
		em.merge(producto);
	}
	
	public Productos read(int codigo) {
		Productos p = em.find(Productos.class, codigo);
		return p;
	}
	
	public void delete(int codigo) {
		Productos p = em.find(Productos.class, codigo);
		em.remove(p);
	}
	
	public List<Productos> getAll(){
		String jpql = "SELECT p FROM Productos p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
}
