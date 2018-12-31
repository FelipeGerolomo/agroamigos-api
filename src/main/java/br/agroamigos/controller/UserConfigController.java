package br.agroamigos.controller;


import br.agroamigos.model.User;
import br.agroamigos.model.UserConfig;
import br.agroamigos.repository.UserConfigRepository;
import br.agroamigos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@Transactional
public class UserConfigController {
    @Autowired
    private UserConfigRepository userConfigRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/config/{userid}")
    public Page<UserConfig> getAllConfig(@PathVariable("userid") Long userId, Pageable pageable) {
        Optional<User> user = userRepository.findById(userId);

        return (Page<UserConfig>) userConfigRepository.findByIdUser(user, pageable);
    }

    @PostMapping("/config")
    public List<UserConfig> postConfig(@RequestBody List<UserConfig> userConfig) {
        return userConfigRepository.saveAll(userConfig);
    }
}
