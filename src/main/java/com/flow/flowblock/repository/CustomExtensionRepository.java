package com.flow.flowblock.repository;

import com.flow.flowblock.domain.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomExtensionRepository  extends JpaRepository<CustomExtension,Long> {
    Optional<CustomExtension> findByName(String name);
}
