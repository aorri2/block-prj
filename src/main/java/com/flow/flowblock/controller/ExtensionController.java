package com.flow.flowblock.controller;

import com.flow.flowblock.domain.CustomExtension;
import com.flow.flowblock.domain.FixExtension;
import com.flow.flowblock.message.Message;
import com.flow.flowblock.message.StatusEnum;
import com.flow.flowblock.repository.CustomExtensionRepository;
import com.flow.flowblock.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ExtensionController {
    private final ExtensionService extensionService;
    private final CustomExtensionRepository customExtensionRepository;

    @PostMapping("/fix-extension/update")
    @ResponseBody
    public ResponseEntity<Message> editFixExtensionActivation(@RequestParam Long id) {
        FixExtension fixExtension = extensionService.updateFixExtensionActivation(id);

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        message.setStatus(StatusEnum.OK);
        message.setMessage("true");
        message.setData(fixExtension);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @PostMapping("/custom-extension/isDuplicated")
    @ResponseBody
    public String checkDuplicatedCustomExtension(@RequestParam String name) {
        log.info("checkDuplicatedCustomExtension");
        Optional<CustomExtension> customExtension = customExtensionRepository.findByName(name);
        if (customExtension.isEmpty()) {
            return "true";
        }
        return "false";
    }

    @PostMapping("/custom-extension/add")
    public String addCustomExtension(@RequestParam("custom-extension") @Length(min = 1, max = 20) String name) {
        log.info("addCustomExtension");
        CustomExtension extension = new CustomExtension();
        extension.setName(name);
        extensionService.saveCustomExtension(extension);
        return "redirect:/";
    }

    @PostMapping("/custom-extension/delete/{id}")
    public String deleteCustomExtension(@PathVariable Long id) {
        extensionService.deleteCustomExtension(id);
        return "redirect:/";
    }
}
