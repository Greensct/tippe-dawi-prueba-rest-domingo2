package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService service;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> lista(){
		System.out.println(">>>Inicio >>>Lista");
		List<Alumno> lista = service.listaAlumno();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<Alumno> registra(@RequestBody Alumno obj){
		System.out.println(">>> inicio >>> registra " + obj.getNombre());
		Alumno objAlumno= service.insertaActualizaAlumno(obj);
		return ResponseEntity.ok(objAlumno);
	}
	
	@PutMapping
	public ResponseEntity<Alumno> actualiza(@RequestBody Alumno obj){
		System.out.println(">>> inicio >>> actualizar " + obj.getNombre());
		Alumno objAlumno= service.insertaActualizaAlumno(obj);
		return ResponseEntity.ok(objAlumno);
	}
	
}