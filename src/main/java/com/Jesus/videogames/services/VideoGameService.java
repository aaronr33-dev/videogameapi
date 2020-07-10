package com.Jesus.videogames.services;

import com.Jesus.videogames.model.VideoGame;
import com.Jesus.videogames.repo.VideoGameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepo videoGameRepo;

    public List<VideoGame> getGames(){
        List<VideoGame> games = new ArrayList<>();
        videoGameRepo.findAll().forEach(games::add);
        return games;
    }

    public Optional<VideoGame> getVideoGameById(Long id){
        return videoGameRepo.findById(id);
    }

    public void addVideoGame(VideoGame videoGame) { videoGameRepo.save(videoGame);}

    public void updateVideoGame(VideoGame videoGame, Long id){
        for (VideoGame videoGame1: videoGameRepo.findAll()){
            if(videoGame1.getId().equals(id)){
                videoGameRepo.save(videoGame);
            }
        }
    }
    public void deleteVideoGame(Long id) {
        videoGameRepo.deleteById(id);
    }


}
