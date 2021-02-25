package com.web.repository;

import com.web.model.PessoaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaUserRepository extends JpaRepository<PessoaUser, Long> {
}
