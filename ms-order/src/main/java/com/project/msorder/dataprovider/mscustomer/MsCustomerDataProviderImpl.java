package com.project.msorder.dataprovider.mscustomer;

import com.project.msorder.dataprovider.mscustomer.feign.MsCustomerFeignClient;
import com.project.msorder.dataprovider.mscustomer.feign.response.CustomerResponse;
import com.project.msorder.domain.dataprovider.mscustomer.MsCustomerDataProvider;
import com.project.msorder.domain.exception.CustomerNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MsCustomerDataProviderImpl implements MsCustomerDataProvider {

    private final MsCustomerFeignClient msCustomerFeignClient;

    @Override
    public void retrieveById(Long customerId) {
        ResponseEntity<CustomerResponse> responseEntity = null;

        try {
            responseEntity = msCustomerFeignClient.retrieveById(customerId);

        } catch (FeignException.NotFound e) {
            throw new CustomerNotFoundException("customer not found");
        }
    }
}
