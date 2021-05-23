package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<Alumno>> lista() {
		System.out.println(">>>Inicio >>>Lista");
		List<Alumno> lista = service.listaAlumno();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<Alumno> registra(@RequestBody Alumno obj) {
		System.out.println(">>> inicio >>> registra " + obj.getNombre());
		Alumno objAlumno = service.insertaActualizaAlumno(obj);
		return ResponseEntity.ok(objAlumno);
	}

	@PutMapping
	public ResponseEntity<Alumno> actualiza(@RequestBody Alumno obj) {
		System.out.println(">>> inicio >>> actualizar " + obj.getNombre());
		Optional<Alumno> optAlumno = service.obtienePorId(obj.getIdAlumno());
		if (optAlumno.isPresent()) {
			Alumno objAlumno = service.insertaActualizaAlumno(obj);
			return ResponseEntity.ok(objAlumno);
		} else {
			System.out.println(obj.getIdAlumno());
			return ResponseEntity.ok(optAlumno.get());
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Alumno> elimina(@PathVariable("id") int id) {
		System.out.println(">>> inicio >>> eliminar " + id);
		Optional<Alumno> optAlumno = service.obtienePorId(id);
		if (optAlumno.isPresent()) {
			service.eliminaAlumno(id);
			return ResponseEntity.ok(optAlumno.get());
		} else {
			System.out.println("No existe el alumno con Id " + id);
			return ResponseEntity.ok(optAlumno.get());
		}
	}

}