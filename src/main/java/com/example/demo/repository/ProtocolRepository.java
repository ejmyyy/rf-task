package com.example.demo.repository;

import com.example.demo.model.Protocol;
import com.example.demo.model.ProtocolState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
    Protocol findByProtocolState(ProtocolState protocolState);
}
