package com.rollingstone.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.RealEstateProperty;



public interface RsMortgageRealEstatePropertyRepository extends PagingAndSortingRepository<RealEstateProperty, Long> {
    List<RealEstateProperty> findRealEstatePropertyByIsForeClosed(boolean idForeClosed);
    List<RealEstateProperty> findRealEstatePropertyByisDamaged(boolean isDamaged);
    List<RealEstateProperty> findRealEstatePropertyByCurrentPrice(double currentPrice);

    Page findAll(Pageable pageable);
}
