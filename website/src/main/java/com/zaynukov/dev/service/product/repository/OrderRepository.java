package com.zaynukov.dev.service.product.repository;

import com.zaynukov.dev.dbmodel.CreatedOrderEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<CreatedOrderEntity, Integer> {
}
