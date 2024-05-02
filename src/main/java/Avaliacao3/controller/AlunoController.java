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

import Avaliacao3.entities.Aluno;
import Avaliacao3.service.AlunoService;   

@RestController  
@RequestMapping("/aluno")  
public class AlunoController {   
	private final AlunoService alunoService;   
	@Autowired   
	public AlunoController(AlunoService alunoService) {   
		this.alunoService = alunoService;   
	}   
	@GetMapping("/{id}")   
	public ResponseEntity<Aluno> buscaAlunosControlId(@PathVariable Long id){   
		Aluno aluno = alunoService.buscaAlunoId(id);  
		if (aluno != null) {   
			return ResponseEntity.ok(aluno);   
		}   
		else {   
			return ResponseEntity.notFound().build();   
		}   
	}   
	@GetMapping("/")   
	public ResponseEntity<List<Aluno>> buscaTodasAlunosControl(){   
		List<Aluno> aluno = alunoService.buscaTodosAlunos();   
		return ResponseEntity.ok(aluno);   
	}   
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorCidade(@PathVariable String cidade){
		List<Aluno> alunos = alunoService.buscarAlunosPorCidade(cidade);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/renda/{renda}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorRenda(@PathVariable double renda){
		List<Aluno> alunos = alunoService.buscarAlunosPorRenda(renda);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/ra/{ra}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorRa(@PathVariable String ra){
		List<Aluno> alunos = alunoService.buscarAlunosPorRa(ra);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/cidade/{cidade}/renda/{renda}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorCidadeRenda(@PathVariable String cidade, @PathVariable double renda){
		List<Aluno> alunos = alunoService.buscarAlunosPorCidadeRenda(cidade, renda);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/nome-completo/{nomeCompleto}")
	public List<Aluno> findAlunosPorNomeCompletoLike(@PathVariable String nomeCompleto){
		return alunoService.findByNomeCompletoLike(nomeCompleto);
	}
	//query
	@GetMapping("/turma/{turmaId}")
	public List<Aluno> findAlunosPorTurma(@PathVariable Long turmaId) {
		return alunoService.findByTurmaId(turmaId);
	}
	
	@PostMapping("/")   
	public ResponseEntity<Aluno> salvaAlunosControl(@RequestBody Aluno aluno){   
		Aluno salvaAluno = alunoService.salvaAluno(aluno);   
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);   
	}   
	@PutMapping("/{id}")   
	public ResponseEntity<Aluno> alteraAlunosControl(@PathVariable Long id, @RequestBody Aluno aluno){   
		Aluno alteraAluno = alunoService.alterarAluno(id, aluno);   
		if (alteraAluno != null) {   
			return ResponseEntity.ok(aluno);   
		}   
		else {   
			return ResponseEntity.notFound().build();   
		}   
	}   
	@DeleteMapping("/{id}")   
	public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){   
		boolean apagar = alunoService.apagarAluno(id);   
		if(apagar) {   
			return ResponseEntity.ok().body("O aluno foi excluido!");   
		}   
		else {   
			return ResponseEntity.notFound().build();   
		}   
	}   
} 