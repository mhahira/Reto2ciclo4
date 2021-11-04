/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_5.Repositorio;

import Reto_5.Interface.InterfaceCliente;
import Reto_5.Modelo.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class ClienteRepositorio {
      @Autowired
    private InterfaceCliente crud1;
    

    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();       
    }
    
    public Optional <Cliente> getCliente(int id){
        return crud1.findById(id);
    }
    
    public Cliente save(Cliente cliente){
        return crud1.save(cliente);
    }
     public void delete(Cliente cliente){
        crud1.delete(cliente);
    } 
}
