package com.credit.analysis.repository;

import com.credit.analysis.dto.LoanDetailDTO;
import com.credit.analysis.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}