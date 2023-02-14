package com.project.msorder.dataprovider.mscustomer.feign;

import com.project.msorder.dataprovider.mscustomer.feign.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "${ms-customer.name}", url = "${ms-customer.url}", path = "${ms-customer.path}")
public interface MsCustomerFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<CustomerResponse> retrieveById(@PathVariable Long id);

}
