package co.proyecto4.proyecto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.proyecto4.proyecto4.model.Fragance;
import co.proyecto4.proyecto4.repository.FraganceRepository;

@Service
public class FraganceService {
    @Autowired
    private FraganceRepository fraganceRepository;

    public List<Fragance> getAll() {
        return fraganceRepository.getAll();
    }

   public Optional<Fragance> getFragance(String reference) {
        return fraganceRepository.getFragance(reference);
    }

    public Fragance create(Fragance fragance) {
        if (fragance.getReference() == null) {
            return fragance;
        } else {
            return fraganceRepository.create(fragance);
        }
    }
    
    public Fragance update(Fragance fragance) {

        if (fragance.getReference() != null) {
            Optional<Fragance> fraganceDb = fraganceRepository.getFragance(fragance.getReference());
            if (!fraganceDb.isEmpty()) {
                
                if (fragance.getBrand()!= null) {
                    fraganceDb.get().setBrand(fragance.getBrand());
                }
                
                if (fragance.getCategory() != null) {
                    fraganceDb.get().setCategory(fragance.getCategory());
                }

                if (fragance.getPresentation() != null) {
                    fraganceDb.get().setPresentation(fragance.getPresentation());
                }

                if (fragance.getDescription() != null) {
                    fraganceDb.get().setDescription(fragance.getDescription());
                }
                if (fragance.getPrice() != 0.0) {
                    fraganceDb.get().setPrice(fragance.getPrice());
                }
                if (fragance.getQuantity() != 0) {
                    fraganceDb.get().setQuantity(fragance.getQuantity());
                }
                if (fragance.getPhotography() != null) {
                    fraganceDb.get().setPhotography(fragance.getPhotography());
                }
                fraganceDb.get().setAvailability(fragance.isAvailability());
                fraganceRepository.update(fraganceDb.get());
                return fraganceDb.get();
            } else {
                return fragance;
            }
        } else {
            return fragance;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getFragance(reference).map(fragance -> {
            fraganceRepository.delete(fragance);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}

