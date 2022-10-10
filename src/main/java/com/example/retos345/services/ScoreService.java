package com.example.retos345.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos345.entities.Score;
import com.example.retos345.repositories.ScoreRepository;


@Service
public class ScoreService {
    
        @Autowired
        private ScoreRepository scoreRepository;

        public ScoreService(ScoreRepository scoreRepository) {
            this.scoreRepository = scoreRepository;
        }

        // METODOS CRUD
        public List<Score> getListScores(){
            return this.scoreRepository.findAll();
        }

        public Score getScore(int id){
            if(!this.scoreRepository.findById(id).isEmpty()){
                return this.scoreRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Score crearScore(Score score){
            return this.scoreRepository.save(score);
        }

        public void eliminarScore(int id){
            if(!this.scoreRepository.findById(id).isEmpty()){
                this.scoreRepository.deleteById(id);
            }
        }

        public void actualizarScore(int id, Score score){
            if(!this.scoreRepository.findById(id).isEmpty()){
                Score scoreDB = this.scoreRepository.findById(id).get();
                
                if(score.getMessageText() != null){
                    scoreDB.setMessageText(score.getMessageText());
                }
                if(score.getStars() != null){
                    scoreDB.setStars(score.getStars());
                }
                this.scoreRepository.save(scoreDB);
            }
        }
}
