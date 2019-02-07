package br.pucminas.simpleapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "examples", description = "Recurso de exemplo responsável por retornar uma string simples ao ser requisitado.", tags={ "examples"})
public class ExemploController {
	
	private static final Logger log = LoggerFactory.getLogger(ExemploController.class);
	
	@ApiOperation(value = "Retorna uma string simples", nickname = "returnSimpleText", notes = "", tags={ "examples"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!")})
	@GetMapping(value = "/examples", produces = "application/json")
	public ResponseEntity<String> returnSimpleText()
	{
		log.info("Aplicação esta funcionado!!!");
		return ResponseEntity.ok().body("Aplicação esta funcionado!!!");
	}
}
