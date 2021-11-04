/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_5.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto_5.Modelo.Ortopedia;
import Reto_5.Interface.InterfaceOrtopedia;

/**
 *
 * @author USUARIO
 */
@Repository
public class OrtopediaRepositorio {
      @Autowired
    private InterfaceOrtopedia crud;
    

    public List<Ortopedia> getAll(){
        return (List<Ortopedia>) crud.findAll();       
    }
    
    public Optional <Ortopedia> getOrtopedia(int id){
        return crud.findById(id);
    }
    
    public Ortopedia save(Ortopedia ortopedic){
        return crud.save(ortopedic);
    }
     public void delete(Ortopedia ortopedic){
        crud.delete(ortopedic);
    }
    
}
