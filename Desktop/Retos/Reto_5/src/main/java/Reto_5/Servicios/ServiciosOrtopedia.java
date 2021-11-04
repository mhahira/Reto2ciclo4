/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_5.Servicios;

import Reto_5.Modelo.Ortopedia;
import Reto_5.Repositorio.OrtopediaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosOrtopedia {
        @Autowired
    private OrtopediaRepositorio metodosCrud;
    
    public List<Ortopedia> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Ortopedia> getOrtopedia(int idOrtopedia){
        return metodosCrud.getOrtopedia(idOrtopedia);
    }
    
    public Ortopedia save(Ortopedia ortopedic){
     
        if(ortopedic.getId()==null){
            return metodosCrud.save(ortopedic);
        }else{
            Optional<Ortopedia> evt=metodosCrud.getOrtopedia(ortopedic.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(ortopedic);
            }else{
                return ortopedic;
            }
        }
    }
    public Ortopedia update(Ortopedia ortopedia){
        if(ortopedia.getId()!=null){
            Optional<Ortopedia> e=metodosCrud.getOrtopedia(ortopedia.getId());
            if(!e.isEmpty()){
                if(ortopedia.getName()!=null){
                    e.get().setName(ortopedia.getName());
                }
                if(ortopedia.getBrand()!=null){
                    e.get().setBrand(ortopedia.getBrand());
                }
                if(ortopedia.getYear()!=null){
                    e.get().setYear(ortopedia.getYear());
                }
                
                if(ortopedia.getModel()!=null){
                    e.get().setModel(ortopedia.getModel());
                }
                if(ortopedia.getDescription()!=null){
                    e.get().setDescription(ortopedia.getDescription());
                }
                if(ortopedia.getCategory()!=null){
                    e.get().setCategory(ortopedia.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return ortopedia;
            }
        }else{
            return ortopedia;
        }
    }


    public boolean deleteOrtopedia(int ortopediaId) {
        Boolean aBoolean = getOrtopedia(ortopediaId).map(ortopedic -> {
            metodosCrud.delete(ortopedic);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
