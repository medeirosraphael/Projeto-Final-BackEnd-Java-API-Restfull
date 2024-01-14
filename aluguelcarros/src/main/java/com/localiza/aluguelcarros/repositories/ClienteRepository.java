package com.localiza.aluguelcarros.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.localiza.aluguelcarros.entities.Cliente;

public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Long>{

}
