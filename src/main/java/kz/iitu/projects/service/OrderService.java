package kz.iitu.projects.service;

import kz.iitu.projects.model.Order;
import org.springframework.dao.DataAccessException;

import java.util.Collection;


public interface OrderService{

    Order getById(Integer id) throws DataAccessException;

    void save(Order order) throws DataAccessException;

    void delete(Order order) throws DataAccessException;

    Collection<Order> getAllOrders() throws DataAccessException;

}
