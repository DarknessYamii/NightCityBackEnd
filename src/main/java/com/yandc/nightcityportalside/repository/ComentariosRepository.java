package com.yandc.nightcityportalside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yandc.nightcityportalside.models.Comentarios;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long>{

	
}
