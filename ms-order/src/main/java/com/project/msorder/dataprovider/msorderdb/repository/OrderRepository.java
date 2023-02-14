package com.project.msorder.dataprovider.msorderdb.repository;

import com.project.msorder.dataprovider.msorderdb.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByCustomerId(Long id);

    @Query(value = "SELECT count(id) FROM `ms-order_db`.solicitation s where s.customer_id= :customerId", nativeQuery = true)
    Integer findAmountOfOrdersByCustomerId(Long customerId);

}
