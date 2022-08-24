package se.magnus.api.core.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerService {
    @GetMapping(value    = "/customer",produces = "application/json")
    List<Customer> getCustomers(@RequestParam(value = "productId", required = true) int productId);

}
