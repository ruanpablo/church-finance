
package com.meva.finance.controller;

import com.meva.finance.dto.ValueDto;
import com.meva.finance.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/value")
public class ValueController {

	@Autowired
	private ValueService valueService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody ValueDto valueDto) {
		return valueService.register(valueDto);
	}

}
