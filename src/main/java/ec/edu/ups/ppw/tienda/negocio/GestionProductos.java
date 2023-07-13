package ec.edu.ups.ppw.tienda.negocio;

import java.util.List;

import ec.edu.ups.ppw.tienda.dao.ProductosDAO;
import ec.edu.ups.ppw.tienda.modelo.Productos;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProductos {
	
	@Inject
	private ProductosDAO daoProductos;
	
	public void guardarProducto(Productos producto) throws Exception {
		
		//daoProductos.insert(producto);
		
		if(daoProductos.read(producto.getIdProducto()) == null) {
			try {
				daoProductos.insert(producto);
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoProductos.update(producto);
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
		
	}
	
	public List<Productos> getAll(){
		return daoProductos.getAll();
	}
	
}
