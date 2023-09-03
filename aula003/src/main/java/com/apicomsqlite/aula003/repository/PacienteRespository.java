package com.apicomsqlite.aula003.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.aula003.enity.Paciente;

@Repository
public interface PacienteRespository extends JpaRepository<Paciente, Integer> {

    public boolean existsByEmail(String email);

    public List<Paciente> findByEmail(String email);

    @Query("select max(s.id) from Paciente s")
    public Integer findMaxId();
}