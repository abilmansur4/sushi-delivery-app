package kz.iitu.projects.service;

import kz.iitu.projects.model.Product;
import org.springframework.dao.DataAccessException;

import java.util.Collection;


public interface ProductService{

    Product getById(Integer id) throws DataAccessException;

    void save(Product product) throws DataAccessException;

    void delete(Product product) throws DataAccessException;

    Collection<Product> getAllProducts() throws DataAccessException;

}
