package com.flow.flowblock.repository;

import com.flow.flowblock.domain.CustomExtension;
import com.flow.flowblock.domain.FixExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FixExtensionRepository extends JpaRepository<FixExtension,Long> {

}
