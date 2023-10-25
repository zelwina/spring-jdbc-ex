package com.zelwina.springjdbc.controller;

import com.zelwina.springjdbc.entity.MyStuff;
import com.zelwina.springjdbc.repo.MyStuffRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Controller
@RequestMapping("stuff")
public class MyStuffController {

    private final MyStuffRepo myStuffRepo;

    public MyStuffController(MyStuffRepo myStuffRepo) {
        this.myStuffRepo = myStuffRepo;
    }

    @GetMapping
    public ResponseEntity<MyStuff> get(@RequestParam("id") Long id) {
        return myStuffRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<MyStuff> post(@RequestBody MyStuff yourStuff) throws URISyntaxException {
        MyStuff save = myStuffRepo.save(yourStuff);
        return ResponseEntity.created(new URI(save.getId().toString())).body(save);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam("id") Long id) {
        Optional<MyStuff> byId = myStuffRepo.findById(id);

        if (byId.isPresent()) {
            myStuffRepo.delete(byId.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping
    public ResponseEntity<MyStuff> put(@RequestBody MyStuff myStuff, @RequestParam("id") Long id) throws URISyntaxException {
        var fromDb = myStuffRepo.findById(id);

        if(fromDb.isPresent()) {
            myStuff.setId(id);
            return post(myStuff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
