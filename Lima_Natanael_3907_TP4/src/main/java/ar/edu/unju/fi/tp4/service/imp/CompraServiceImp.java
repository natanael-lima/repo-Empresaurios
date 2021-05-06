package ar.edu.unju.fi.tp4.service.imp;

import java.util.List;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.service.ICompraService;

public class CompraServiceImp implements ICompraService{
    
	private List<Compra> compraList;
	
	@Override
	public void generarListaCompras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarCompra(Compra compra) {
		// TODO Auto-generated method stub
		if(compraList==null) 
			generarListaCompras();
		
		compraList.add(compra);
			
		
	}

	@Override
	public List<Compra> obtenerCompras() {
		// TODO Auto-generated method stub
		return compraList;
	}
	

}
