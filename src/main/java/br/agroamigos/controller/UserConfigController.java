package br.agroamigos.controller;


import br.agroamigos.model.UserConfig;
import br.agroamigos.repository.UserConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
public class UserConfigController {
    @Autowired
    private UserConfigRepository userConfigRepository;

    @PostMapping("/config")
    public List<UserConfig> postConfig(@RequestBody List<UserConfig> userConfig) {
        return userConfigRepository.saveAll(userConfig);
    }
}
