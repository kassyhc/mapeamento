package Avaliacao3.service; 
  
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Avaliacao3.entities.Turma;
import Avaliacao3.repository.TurmaRepository;   
   
@Service   
public class TurmaService {   
	private final TurmaRepository turmaRepository;     
	@Autowired     
	public TurmaService(TurmaRepository turmaRepository) {     
		this.turmaRepository = turmaRepository;     
	}    
	public List<Turma> buscaTodosTurmas() {     
		return turmaRepository.findAll();    
	}    
	public Turma buscaTurmaId(Long id) {     
		Optional <Turma> turma = turmaRepository.findById(id);    
		return turma.orElse(null);    
	}    
	public List<Turma> buscarTurmaPorNome(String nome){
		return turmaRepository.findByNome(nome);
	}
	public List<Turma> buscarTurmaPorDescricao(String descricao){
		return turmaRepository.findByDescricao(descricao);
	}
	public List<Turma> buscarTurmaPorNomeDescricao(String nome, String descricao){
		return turmaRepository.findByNomeAndDescricao(nome, descricao);
	}
	
	public Turma salvaTurma(Turma turma) {     
		return turmaRepository.save(turma);     
	}    
	public Turma alterarTurma(Long id, Turma alterarUser) {     
		Optional <Turma> existeTurma = turmaRepository.findById(id);     
		if (existeTurma.isPresent()) {     
			alterarUser.setId(id);     
			return turmaRepository.save(alterarUser);     
		}    
		return null;     
	}    
	public boolean apagarTurma(Long id) {    
		Optional <Turma> existeTurma = turmaRepository.findById(id);     
		if (existeTurma.isPresent()) {     
			turmaRepository.deleteById(id);     
			return true;     
		}    
		return false;     
	}   
} 