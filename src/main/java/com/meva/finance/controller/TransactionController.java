
package com.meva.finance.controller;

import com.meva.finance.dto.TransactionDto;
import com.meva.finance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody TransactionDto valueDto) {
		return transactionService.register(valueDto);
	}

	@GetMapping("/totalBalance")
	public ResponseEntity<BigDecimal> totalBalanceChurch(){
		BigDecimal totalBalance = transactionService.totalBalance();
		return ResponseEntity.ok(totalBalance);
	}

}
