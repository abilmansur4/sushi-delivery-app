package kz.iitu.projects.rest;

import kz.iitu.projects.model.Order;
import kz.iitu.projects.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer orderId){

        if(orderId == null){
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }

        Order order = this.orderService.getById(orderId);

        if(order == null){
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> saveOrder(@RequestBody @Valid Order order, UriComponentsBuilder ucBuilder){
        HttpHeaders headers = new HttpHeaders();

        if(order == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.orderService.save(order);
        headers.setLocation(ucBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri());
        return new ResponseEntity<Order>(order, headers, HttpStatus.CREATED);
    }

    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> updateOrder(@RequestBody @Valid Order order, UriComponentsBuilder builder){
        HttpHeaders headers = new HttpHeaders();
        if(order == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.orderService.save(order);

        return new ResponseEntity<>(order, headers, HttpStatus.OK);
    }

    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") Integer id){
        Order order = this.orderService.getById(id);

        if(order == null){
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

        this.orderService.delete(order);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Order>> getOrders(){

        Collection<Order> orders = this.orderService.getAllOrders();

        if(orders.isEmpty()){
            return new ResponseEntity<Collection<Order>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Collection<Order>>(orders, HttpStatus.OK);

    }

}
