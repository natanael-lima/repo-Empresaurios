package ar.edu.unju.fi.tp4.service;

import ar.edu.unju.fi.tp4.model.Producto;

public interface IProductoService {
    
	/**
	 * Interface para agregar producto
	 * @param producto
	 */
	public void agregarList(Producto producto);
	
	/**
	 * Interface para obtener producto
	 * @param producto
	 */
	public Producto obtenerList();
}
