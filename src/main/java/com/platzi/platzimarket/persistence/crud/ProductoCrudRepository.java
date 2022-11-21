package com.platzi.platzimarket.persistence.crud;

import com.platzi.platzimarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

    //Con Query Nativo
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoria(Long idCategoria);

    //Con query Methods
    List<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Long cantidadStock, Boolean estado);

}
