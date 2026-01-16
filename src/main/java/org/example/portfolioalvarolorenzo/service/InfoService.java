package org.example.portfolioalvarolorenzo.service;

import org.example.portfolioalvarolorenzo.model.Info;
import org.example.portfolioalvarolorenzo.repository.InfoRepository;

// Es la capa intermedia entre el Controller y el Repository
public class InfoService {
    // Referencia al repositorio
    private final InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }


    // Método para que devuelva la información personal (solo un registro)
    public Info getInfo(){
        return infoRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);
    }

    // Método para guardar la información personal
    public Info save(Info info){
        return infoRepository.save(info);
    }

    // Elimina la información personal por id
    public void delete(Long id){
        infoRepository.deleteById(id);
    }
}
