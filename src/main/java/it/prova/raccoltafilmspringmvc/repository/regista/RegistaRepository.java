package it.prova.raccoltafilmspringmvc.repository.regista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.raccoltafilmspringmvc.model.Regista;

public interface RegistaRepository
		extends PagingAndSortingRepository<Regista, Long>, JpaSpecificationExecutor<Regista>, CustomRegistaRepository {
	
	public List<Regista> findByCognomeIgnoreCaseContainingOrNomeIgnoreCaseContainingOrderByNomeAsc(String cognome,
			String nome);
	
	@Query("from Regista r left join fetch r.films f where r.id=?1")
	public Regista findRegistaEager(Long id);
}
