package kz.iitu.projects.service;

import kz.iitu.projects.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import kz.iitu.projects.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Product getById(Integer id){
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Product product) throws DataAccessException{
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void delete(Product product){
        productRepository.delete(product);
    }

    @Override
    public Collection<Product> getAllProducts() throws DataAccessException {
        return productRepository.findAll();
    }

}
