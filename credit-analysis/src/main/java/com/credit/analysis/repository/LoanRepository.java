package com.credit.analysis.repository;

import com.credit.analysis.dto.ListLoanDTO;
import com.credit.analysis.dto.LoanDetailDTO;
import com.credit.analysis.model.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel, Long> {

	@Query(" SELECT new com.credit.analysis.dto.ListLoanDTO(l.loanId, l.amountLoan, l.amountPortion) FROM LoanEntity l INNER JOIN l.customer cl WHERE cl.cpf = :cpf")
	public List<ListLoanDTO> listLoan(@Param("cpf") String cpf);

	@Query(" SELECT new  com.credit.analysis.dto.LoanDetailDTO(l.loanId, l.amountLoan, l.datePortion, l.amountPortion, cl.email, cl.income) FROM LoanEntity l INNER JOIN l.customer cl WHERE cl.cpf = :cpf")
	public List<LoanDetailDTO> loanDetail(@Param("cpf") String cpf);
}