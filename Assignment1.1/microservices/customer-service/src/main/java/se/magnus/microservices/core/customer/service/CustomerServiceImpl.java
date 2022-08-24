package se.magnus.microservices.core.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.composite.product.CustomerSummary;
import se.magnus.api.core.customer.Customer;
import se.magnus.api.core.customer.CustomerService;
import se.magnus.api.core.recommendation.Recommendation;
import se.magnus.util.exceptions.InvalidInputException;
import se.magnus.util.exceptions.NotFoundException;
import se.magnus.util.http.ServiceUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public CustomerServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Customer> getCustomers(int productId) {
        LOG.debug("/product return the found product for productId={}", productId);

        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);

        if (productId == 313) {
            LOG.debug("No Customer found for productId: {}", productId);
            return  new ArrayList<>();
        }

        List<Customer> list = new ArrayList<>();
        list.add(new Customer( productId,1, "Bill",  "Murphy", "bill@murphy.com",serviceUtil.getServiceAddress()));
        list.add(new Customer( productId,2, "Tom",  "Robinson", "tom@robinson.com",serviceUtil.getServiceAddress()));
        list.add(new Customer( productId,3, "Doug", "Johnson", "doug@johnson.com",serviceUtil.getServiceAddress()));

        return list;
    }
}