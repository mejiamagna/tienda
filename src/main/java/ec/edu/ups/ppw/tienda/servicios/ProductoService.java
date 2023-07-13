package ec.edu.ups.ppw.tienda.servicios;

import java.util.List;

import ec.edu.ups.ppw.tienda.modelo.Productos;
import ec.edu.ups.ppw.tienda.negocio.GestionProductos;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("producto")
public class ProductoService {
	
	@Inject
	private GestionProductos gProductos;
	
	@GET
	@Path("datosproducto")
	@Produces("application/json")
	public Productos datosProducto() {
		Productos p = new Productos();
		p.setNombreProducto("tablet");
		p.setPrecioProducto(230);
		p.setStockProducto(10);

		return p;
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarProducto(Productos producto) {
		try {
			gProductos.guardarProducto(producto);
			return Response.status(Response.Status.OK).entity(producto).build();
					
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}	
	}
	
	@GET
	@Path("/listarProducto")
	@Produces("application/json")
	public List<Productos> getAll(){
		
		return gProductos.getAll();
	}
	
	
}
