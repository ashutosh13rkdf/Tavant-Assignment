package com.tavant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
	@Autowired
	private LoanRepository loanRepo;

	public List<LoanRecord> getAllLoans() {
		List<LoanRecord> loanRecords = new ArrayList<LoanRecord>();
		loanRepo.findAll().forEach(loanRecords::add);
		return loanRecords;
	}

	public void addAllLoans(List<LoanRecord> loanRecords) {
		loanRepo.saveAll(loanRecords);
	}

	public void updateLoansStatus(List<LoanRecord> loanRecords, String actionType) {
		for (LoanRecord loans : loanRecords) {
			loans.setLoanStatus(actionType);
			loans.setLastActionDate(new Date());
			if("D".equalsIgnoreCase(actionType)) {
				loans.setLoanStartDate(null);
			}
		}
		loanRepo.saveAll(loanRecords);
	}

}
