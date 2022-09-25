package knightly.testgateway.controller;

import knightly.testgateway.client.ProductService;
import knightly.testgateway.client.dto.ComponentDTO;
import knightly.testgateway.client.dto.ProductDTO;
import knightly.testgateway.enums.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    ProductService productService;

    @GetMapping("/components")
    public List<ComponentDTO> getComponents() {
        return this.productService.getComponentDTOs(Currency.gold);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return this.productService.getProductDTOs(Currency.donkey);
    }

    @GetMapping("/createProduct")
    public void createProduct() {
        this.productService.createProductStub(List.of(0L, 4L, 9L, 2L), "floomp");
    }
}
