package br.agroamigos.controller;


import br.agroamigos.model.UserConfig;
import br.agroamigos.repository.UserConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserConfigController {
    @Autowired
    private UserConfigRepository userConfigRepository;

    @PostMapping("/config")
    public UserConfig postConfig(@RequestBody UserConfig userConfig) {
            return userConfigRepository.save(userConfig);
    }
}
