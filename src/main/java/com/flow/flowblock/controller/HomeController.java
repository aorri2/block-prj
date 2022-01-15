package com.flow.flowblock.controller;

import com.flow.flowblock.domain.CustomExtension;
import com.flow.flowblock.domain.FixExtension;
import com.flow.flowblock.repository.CustomExtensionRepository;
import com.flow.flowblock.repository.FixExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final FixExtensionRepository fixExtensionRepository;
    private final CustomExtensionRepository customExtensionRepository;

    @GetMapping("/")
    public String home(Model model){
        List<FixExtension> fixExtensions = fixExtensionRepository.findAll();
        model.addAttribute("fixExtensions", fixExtensions);

        List<CustomExtension> customExtensions = customExtensionRepository.findAll();
        model.addAttribute("customExtensions", customExtensions);

        long countCustomExtensions = customExtensionRepository.count();
        model.addAttribute("countCustomExtensions", countCustomExtensions);

        return "index";
    }
}
