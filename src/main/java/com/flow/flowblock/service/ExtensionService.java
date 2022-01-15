package com.flow.flowblock.service;

import com.flow.flowblock.domain.CustomExtension;
import com.flow.flowblock.domain.FixExtension;
import com.flow.flowblock.repository.CustomExtensionRepository;
import com.flow.flowblock.repository.FixExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExtensionService {
    private final CustomExtensionRepository customExtensionRepository;
    private final FixExtensionRepository fixExtensionRepository;

    @Transactional
    public FixExtension updateFixExtensionActivation(Long id) {
        FixExtension fixExtension = fixExtensionRepository.findById(id)
                .orElseThrow(NoSuchFieldError::new);
        fixExtension.setActivation(!fixExtension.isActivation());
        return fixExtension;
    }

    @Transactional
    public boolean saveCustomExtension(CustomExtension extension) {
        log.info("saveCustomExtension");
        long count = customExtensionRepository.count();
        if (count >= 200) {
            return false;
        }
        validateDuplicateCustomExtension(extension);
        customExtensionRepository.save(extension);
        return true;
    }

    private void validateDuplicateCustomExtension(CustomExtension customExtension) {
        log.info("validateDuplicateCustomExtension");
        customExtensionRepository.findByName(customExtension.getName())
                .ifPresent(e -> {
                    throw new IllegalStateException("이미 존재하는 확장자입니다.");
                });
    }

    @Transactional
    public boolean deleteCustomExtension(Long id) {
        Optional<CustomExtension> extension = customExtensionRepository.findById(id);
        if (extension.isPresent()) {
            customExtensionRepository.delete(extension.get());
            return true;
        }
        return false;
    }


}
