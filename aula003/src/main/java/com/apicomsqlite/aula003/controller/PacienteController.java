package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.Paciente;
import com.apicomsqlite.aula003.service.PacienteService;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createpaciente", method = RequestMethod.POST)
    public String createpaciente(@RequestBody Paciente paciente) {
        return pacienteService.createpaciente(paciente);
    }

    @RequestMapping(value = "readpaciente", method = RequestMethod.GET)
    public List<Paciente> readpaciente() {
        return pacienteService.readpacientes();
    }

    @RequestMapping(value = "updatepaciente", method = RequestMethod.PUT)
    public String updatepaciente(@RequestBody Paciente paciente) {
        return pacienteService.updatepaciente(paciente);
    }

    @RequestMapping(value = "deletepaciente", method = RequestMethod.DELETE)
    public String deletepaciente(@RequestBody Paciente paciente) {
        return pacienteService.deletepaciente(paciente);
    }
}
