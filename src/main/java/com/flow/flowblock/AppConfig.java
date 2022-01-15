package com.flow.flowblock;

import com.flow.flowblock.domain.CustomExtension;
import com.flow.flowblock.domain.FixExtension;
import com.flow.flowblock.repository.CustomExtensionRepository;
import com.flow.flowblock.repository.FixExtensionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner demo(FixExtensionRepository fixExtensionRepository,
                                  CustomExtensionRepository customExtensionRepository){
        return args -> {
            FixExtension fixExtension1 = new FixExtension();
            fixExtension1.setName("bat");
            fixExtensionRepository.save(fixExtension1);
            FixExtension fixExtension2 = new FixExtension();
            fixExtension2.setName("cmd");
            fixExtensionRepository.save(fixExtension2);
            FixExtension fixExtension3 = new FixExtension();
            fixExtension3.setName("com");
            fixExtensionRepository.save(fixExtension3);
            FixExtension fixExtension4 = new FixExtension();
            fixExtension4.setName("cpl");
            fixExtensionRepository.save(fixExtension4);
            FixExtension fixExtension5 = new FixExtension();
            fixExtension5.setName("exe");
            fixExtensionRepository.save(fixExtension5);
            FixExtension fixExtension6 = new FixExtension();
            fixExtension6.setName("scr");
            fixExtensionRepository.save(fixExtension6);
            FixExtension fixExtension7 = new FixExtension();
            fixExtension7.setName("js");
            fixExtensionRepository.save(fixExtension7);

            CustomExtension customExtension1 = new CustomExtension();
            customExtension1.setName("sh");
            customExtensionRepository.save(customExtension1);
            CustomExtension customExtension2 = new CustomExtension();
            customExtension2.setName("ju");
            customExtensionRepository.save(customExtension2);
            CustomExtension customExtension3 = new CustomExtension();
            customExtension3.setName("ch");
            customExtensionRepository.save(customExtension3);
        };

    }
}
