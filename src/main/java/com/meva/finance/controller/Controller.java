
package com.meva.finance.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

	@PostMapping("/teste")
	private void teste() throws Exception {
	}

}
