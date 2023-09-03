package com.apicomsqlite.aula003.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Paciente;
import com.apicomsqlite.aula003.repository.PacienteRespository;
import jakarta.transaction.Transactional;

@Service
public class PacienteService {

    @Autowired(required = false)
    private PacienteRespository pacienteRespository;

    @Transactional
    public String createpaciente(Paciente paciente) {
        try {
            if (!pacienteRespository.existsByEmail(paciente.getEmail())) {
                paciente.setId(null == pacienteRespository.findMaxId() ? 0 : pacienteRespository.findMaxId() + 1);
                pacienteRespository.save(paciente);
                return "paciente cadastrado com sucesso.";
            } else {
                return "paciente já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Paciente> readpacientes() {
        return pacienteRespository.findAll();
    }

    @Transactional
    public String updatepaciente(Paciente paciente) {
        if (pacienteRespository.existsByEmail(paciente.getEmail())) {
            try {
                List<Paciente> pacientes = pacienteRespository.findByEmail(paciente.getEmail());
                pacientes.stream().forEach(s -> {
                    Paciente pacienteToBeUpdate = pacienteRespository.findById(s.getId()).get();
                    pacienteToBeUpdate.setnome(paciente.getnome());
                    pacienteToBeUpdate.setEmail(paciente.getEmail());
                    pacienteToBeUpdate.settelefone(paciente.gettelefone());
                    pacienteToBeUpdate.setendereco(paciente.getendereco());
                    pacienteToBeUpdate.setcomorbidade(paciente.getcomorbidade());
                    pacienteRespository.save(pacienteToBeUpdate);
                });
                return "paciente atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "paciente não existe no banco.";
        }
    }

    @Transactional
    public String deletepaciente(Paciente paciente) {
        if (pacienteRespository.existsByEmail(paciente.getEmail())) {
            try {
                List<Paciente> pacientes = pacienteRespository.findByEmail(paciente.getEmail());
                pacientes.stream().forEach(s -> {
                    pacienteRespository.delete(s);
                });
                return "paciente deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "paciente n\u00E3o existe no banco.";
        }
    }
}