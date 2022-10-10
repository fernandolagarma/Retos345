package com.example.retos345.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retos345.entities.Score;
import com.example.retos345.services.ScoreService;

@Service
@RestController
@RequestMapping("api/Score")
public class ScoreController {    

    @Autowired
    ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Score>> getScores(){
        return new ResponseEntity<List<Score>>(this.scoreService.getListScores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScore(@PathVariable("id") int id){
        return new ResponseEntity<Score>(this.scoreService.getScore(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearScore(@RequestBody Score score){
        this.scoreService.crearScore(score);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarScore(@PathVariable("id") int id){
        this.scoreService.eliminarScore(id);
        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarScore(@RequestBody Score score){
        this.scoreService.actualizarScore(score.getIdScore(), score);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    

}
