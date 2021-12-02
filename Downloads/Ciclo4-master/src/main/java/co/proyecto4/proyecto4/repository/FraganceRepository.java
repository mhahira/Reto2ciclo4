package co.proyecto4.proyecto4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.proyecto4.proyecto4.model.Fragance;
import co.proyecto4.proyecto4.repository.crud.FraganceCrudRepository;

@Repository
public class FraganceRepository {
    @Autowired
    private FraganceCrudRepository fraganceCrudRepository;

    public List<Fragance> getAll() {
        return fraganceCrudRepository.findAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return fraganceCrudRepository.findById(reference);
    }
    public Fragance create(Fragance fragance) {
        return fraganceCrudRepository.save(fragance);
    }

    public void update(Fragance fragance) {
        fraganceCrudRepository.save(fragance);
    }
    
    public void delete(Fragance fragance) {
        fraganceCrudRepository.delete(fragance);
    }
    
}
