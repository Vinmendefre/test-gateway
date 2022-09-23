package knightly.testgateway.controller;

import knightly.testgateway.client.ProductClient;
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
    ProductClient productClient;

    @GetMapping("/components")
    public List<ComponentDTO> getComponents() {
        return this.productClient.makeComponentRequest(Currency.gold);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return this.productClient.makeProductRequest(Currency.donkey);
    }
}
