package com.tavant;

import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<LoanRecord, String> {

}
