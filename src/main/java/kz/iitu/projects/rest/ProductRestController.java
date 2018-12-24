package kz.iitu.projects.rest;

import kz.iitu.projects.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import kz.iitu.projects.model.Product;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

//    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer productId){

        if(productId == null){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }

        Product product = this.productService.getById(productId);

        if(product == null){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

//    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product, UriComponentsBuilder ucBuilder){
        HttpHeaders headers = new HttpHeaders();

        if(product == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        System.out.println("Product name");
        System.out.println(product.getProductName());

        this.productService.save(product);
        headers.setLocation(ucBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Product>(product, headers, HttpStatus.CREATED);
    }

//    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "/{prodId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> updateProduct(@PathVariable("prodId") int prodId, @RequestBody @Valid Product product, UriComponentsBuilder builder){
        HttpHeaders headers = new HttpHeaders();

        Product prod = this.productService.getById(prodId);
        if(prod == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        prod.setProductName(product.getProductName());
        prod.setProductCategory(product.getProductCategory());
        prod.setProductPrice(product.getProductPrice());
        prod.setProductWeight(product.getProductWeight());
        prod.setProductAmount(product.getProductAmount());
        prod.setProductDescription(product.getProductDescription());
        this.productService.save(prod);

        return new ResponseEntity<>(prod, headers, HttpStatus.OK);
    }

//    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id){
        Product product = this.productService.getById(id);

        if(product == null){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        this.productService.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Product>> getProducts(){

        Collection<Product> products = this.productService.getAllProducts();

        if(products.isEmpty()){
            return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);

    }

}
