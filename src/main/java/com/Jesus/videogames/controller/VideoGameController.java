package com.Jesus.videogames.controller;

import com.Jesus.videogames.model.VideoGame;
import com.Jesus.videogames.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @RequestMapping(method = RequestMethod.GET, value = "/videogames")
    public List<VideoGame> getGames(){
        List<VideoGame> videoGames= videoGameService.getGames();
        return  videoGames;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/videogames/{id}")
    public Optional<VideoGame> getVideoGameById(@PathVariable Long id){
        return videoGameService.getVideoGameById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/videogames")
    public void addVideoGame(@RequestBody VideoGame videoGame){videoGameService.addVideoGame(videoGame);}

    @RequestMapping(method = RequestMethod.PUT, value = "/videogames/{id}")
    public void updateVideoGame(@RequestBody VideoGame videoGame, @PathVariable Long id){videoGameService.updateVideoGame(videoGame, id);}

    @RequestMapping(method = RequestMethod.DELETE, value = "/videogames/{id}")
    public void deleteVideoGame(@PathVariable  Long id){videoGameService.deleteVideoGame(id);}




}
