/**
 * 
 */
package br.ufpb.dcx.poo.sisclinica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.dcx.poo.sisclinica.models.Medico;
import br.ufpb.dcx.poo.sisclinica.services.Clinica;

@RestController
public class MedicoController {
	
	
	@Autowired
	private Clinica service;

	@RequestMapping(value = "/medicos", method = RequestMethod.GET)
	public ResponseEntity<List<Medico>> listar() {
		List<Medico> resultado = service.getMedicos();
		return new ResponseEntity<List<Medico>>(resultado, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/medicos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Medico> buscarMedico(@PathVariable("id") int id) throws Exception{
		Medico retorno = this.service.buscarMedico(id);
		return new ResponseEntity<Medico>(retorno, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/medicos",  method = RequestMethod.POST)
	public ResponseEntity<Medico> adicionar(@RequestBody Medico medico) throws Exception{
		Medico resultado = this.service.adicionarMedico(medico);
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/medicos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Medico> atualizarMedico(@PathVariable("id") int id, @RequestBody Medico medico) throws Exception{
		Medico resultado = this.service.atualizarMedico(medico, id);
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/medicos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletaMedico(@PathVariable("id") int id) throws Exception{
		this.service.deletarMedico(id);
		return new ResponseEntity<>("{ \"status\" : \" sucess\"}", HttpStatus.OK);
	}
}