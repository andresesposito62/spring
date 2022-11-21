package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.persistence.crud.ProductoCrudRepository;
import com.platzi.platzimarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(Long idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(Long cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(Long idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(Long idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
