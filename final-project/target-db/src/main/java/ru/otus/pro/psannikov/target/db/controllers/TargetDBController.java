package ru.otus.pro.psannikov.target.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.target.db.entities.Auth;
import ru.otus.pro.psannikov.target.db.services.TargetDBService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/password")
public class TargetDBController {
    private final TargetDBService targetDBService;

    @Autowired
    public TargetDBController(TargetDBService targetDBService) {
        this.targetDBService = targetDBService;
    }

    @GetMapping("/{id}")
    public Optional<Auth> findById(@PathVariable Long id) {
        return targetDBService.findById(id);
    }

    @GetMapping("/change")
    public String changePassword(@RequestParam String login, @RequestParam String password) {
        return targetDBService.changePassword(login, password);
    }

    @GetMapping()
    public Optional<Auth> checkAuth(@RequestParam String login) {
        return targetDBService.checkAuth(login);
    }
}
