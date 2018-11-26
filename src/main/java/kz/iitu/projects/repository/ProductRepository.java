package kz.iitu.projects.repository;


import kz.iitu.projects.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.Collection;

@Profile("spring-data-jpa")
public interface ProductRepository  extends Repository<Product, Integer> {

    Product findById(int id) throws DataAccessException;

    void save(Product product) throws DataAccessException;

    Collection<Product> findAll() throws DataAccessException;

    void delete(Product product) throws DataAccessException;

}
