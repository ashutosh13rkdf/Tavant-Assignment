package com.tavant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	@Autowired
	private LoanService loanService;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

	@RequestMapping("/loans")
	public List<LoanRecord> getAllLoans() {
		LOGGER.info("retrieving details of all loans");
		return loanService.getAllLoans();
	}

	@RequestMapping(value = "/loans", method = RequestMethod.POST)
	public void addAllLoans(@RequestBody List<LoanRecord> loanRecords) {
		LOGGER.info("saving details of all loans");
		loanService.addAllLoans(loanRecords);
	}

	@RequestMapping(value = "/loans/{actionType}", method = RequestMethod.POST)
	public void updateLoansStatus(@RequestBody List<LoanRecord> loanRecords, @PathVariable String actionType) {
		LOGGER.info("updating details of all loans");
		loanService.updateLoansStatus(loanRecords, actionType);
	}

}
