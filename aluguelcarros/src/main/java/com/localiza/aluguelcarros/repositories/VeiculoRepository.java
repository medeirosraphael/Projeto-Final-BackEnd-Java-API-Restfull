package com.localiza.aluguelcarros.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.localiza.aluguelcarros.entities.Veiculo;

public interface VeiculoRepository extends JpaRepositoryImplementation<Veiculo, Long> {

}
