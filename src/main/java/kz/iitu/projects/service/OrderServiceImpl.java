package kz.iitu.projects.service;

import kz.iitu.projects.model.Order;
import kz.iitu.projects.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order getById(Integer id){
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Order order) throws DataAccessException{
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void delete(Order order){
        orderRepository.delete(order);
    }

    @Override
    public Collection<Order> getAllOrders() throws DataAccessException {
        return orderRepository.findAll();
    }

}
