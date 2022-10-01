package knightly.testgateway.controller;

import knightly.testgateway.client.ProductService;
import knightly.testgateway.client.dto.AgeReply;
import knightly.testgateway.client.dto.ComponentDTO;
import knightly.testgateway.api.CreateProductRequest;
import knightly.testgateway.client.dto.ProductDTO;
import knightly.testgateway.enums.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
public class TestController {

    @Autowired
    ProductService productService;

    @GetMapping("/components")
    public List<ComponentDTO> getComponents(@RequestParam String currency) {
        Currency currency1 = getCurrencyEnumFromString(currency);
        System.out.println("got param and created enum : " + getCurrencyEnumFromString(currency));
        return createTestComponents();
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts(@RequestParam String currency) {
        System.out.println("got param and created enum : " + getCurrencyEnumFromString(currency));
        return createTestProducts();
    }

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody CreateProductRequest createProductRequest) {
        System.out.println("createProduct called");
        System.out.println(createProductRequest);
        this.productService.createProductFromIDs(List.of(0L, 4L, 9L, 2L), "floomp");
    }

    @GetMapping("/age")
    public AgeReply getAge(@RequestParam String name){
        return new AgeReply(69, 1000, "josh");
    }

    private Currency getCurrencyEnumFromString(String string) throws IllegalStateException {
        return Currency.valueOf(string);
    }

    @GetMapping("/test")
    public String test2(){
        return "test";
    }

    private List<ComponentDTO> createTestComponents() {
        return List.of(
                new ComponentDTO(
                        1, "floomp" ,new BigDecimal("2.20"), "description1", 2, 3, "ead", 2, 4,5)
                ,new ComponentDTO(
                        2, "fleemp" ,new BigDecimal("5.30"), "description2", 2, 3, "foot", 2, 4,5)
                ,new ComponentDTO(
                        3, "flemp" ,new BigDecimal("2.20"), "description", 2, 3, "ead", 2, 4,5)
        );
    }

    private List<ProductDTO> createTestProducts () {
        return List.of(
                new ProductDTO(0, "Product1", new BigDecimal("400"), createTestComponents())
                ,new ProductDTO(1, "Product2", new BigDecimal("700"), createTestComponents())
        );
    }
}
