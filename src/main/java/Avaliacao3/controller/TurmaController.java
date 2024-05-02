package Avaliacao3.controller;   
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Avaliacao3.entities.Turma;
import Avaliacao3.service.TurmaService;   
  
@RestController   
@RequestMapping("/turma")   
public class TurmaController {   
	private final TurmaService turmaService;   
	@Autowired   
	public TurmaController(TurmaService turmaService) {   
		this.turmaService = turmaService;   
	}   
	@GetMapping("/{id}")   
	public ResponseEntity<Turma> buscaTurmasControlId(@PathVariable Long id){   
		Turma turma = turmaService.buscaTurmaId(id);  
		if (turma != null) {   
			return ResponseEntity.ok(turma);   
		}   
		else {   
			return ResponseEntity.notFound().build();   
		}   
	}   
	@GetMapping("/")   
	public ResponseEntity<List<Turma>> buscaTodasTurmasControl(){   
		List<Turma> turma = turmaService.buscaTodosTurmas();   
		return ResponseEntity.ok(turma);   
	}  

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Turma>> buscarTurmaPorNome(@PathVariable String nome){
		List<Turma> turmas = turmaService.buscarTurmaPorNome(nome);
		return ResponseEntity.ok(turmas);
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Turma>> buscarTurmaPorDescricao(@PathVariable String descricao){
		List<Turma> turmas = turmaService.buscarTurmaPorDescricao(descricao);
		return ResponseEntity.ok(turmas);
	}
	@GetMapping("/nome/{nome}/descricao/{descricao}")
	public ResponseEntity<List<Turma>> buscarTurmaPorNomeDescricao(@PathVariable String nome, @PathVariable String descricao){
		List<Turma> turmas = turmaService.buscarTurmaPorNomeDescricao(nome, descricao);
		return ResponseEntity.ok(turmas);
	}
	@PostMapping("/")   
	public ResponseEntity<Turma> salvaTurmasControl(@RequestBody Turma turma){   
		Turma salvaTurma = turmaService.salvaTurma(turma);   
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);   
	}   
	@PutMapping("/{id}")   
	public ResponseEntity<Turma> alteraTurmasControl(@PathVariable Long id, @RequestBody Turma turma){   
		Turma alteraTurma = turmaService.alterarTurma(id, turma);   
		if (alteraTurma != null) {   
			return ResponseEntity.ok(turma);   
		}   
		else {   
			return ResponseEntity.notFound().build();   
		}  
	}   
	@DeleteMapping("/{id}")   
	public ResponseEntity<String> apagaTurmaControl(@PathVariable Long id){   
		boolean apagar = turmaService.apagarTurma(id);   
		if(apagar) {   
			return ResponseEntity.ok().body("O turma foi excluido!");   
		}   
		else {   
			return ResponseEntity.notFound().build();   
		}   
	}   
} 