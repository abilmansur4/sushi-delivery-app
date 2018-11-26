package kz.iitu.projects.repository;


import kz.iitu.projects.model.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.Collection;

@Profile("spring-data-jpa")
public interface OrderRepository  extends Repository<Order, Integer> {

    Order findById(int id) throws DataAccessException;

    void save(Order order) throws DataAccessException;

    Collection<Order> findAll() throws DataAccessException;

    void delete(Order order) throws DataAccessException;

}
