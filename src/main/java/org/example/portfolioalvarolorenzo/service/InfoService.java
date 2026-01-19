package org.example.portfolioalvarolorenzo.service;

import org.example.portfolioalvarolorenzo.model.Info;
import org.example.portfolioalvarolorenzo.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    /**
     * Devuelve la info existente.
     * Si no hay ninguna, devuelve null.
     */
    public Info getInfo() {
        List<Info> infos = infoRepository.findAll();
        return infos.isEmpty() ? null : infos.get(0);
    }

    /**
     * Guarda o actualiza la info.
     * Si tiene ID → UPDATE
     * Si no tiene ID → INSERT
     */
    public void save(Info info) {
        infoRepository.save(info);
    }


    /**
     * Elimina la info por id
     * (aunque solo debería haber una)
     */
    public void delete(long id) {
        infoRepository.deleteById(id);
    }

    /**
     * Verifica si existe info
     */
    public boolean existeInfo() {
        return infoRepository.count() > 0;
    }

    /**
     * Elimina toda la info (opcional)
     */
    public void deleteAll() {
        infoRepository.deleteAll();
    }
}
