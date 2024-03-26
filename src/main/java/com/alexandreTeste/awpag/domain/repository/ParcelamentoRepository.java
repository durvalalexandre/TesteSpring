package com.alexandreTeste.awpag.domain.repository;

import com.alexandreTeste.awpag.domain.model.Parcelamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelamentoRepository extends JpaRepository<Parcelamento, Long> {

}
