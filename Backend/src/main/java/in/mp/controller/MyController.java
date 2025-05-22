package in.mp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mp.MusicEntity.Music;
import in.mp.apiResponse.ApiResponse;
import in.mp.service.MusicService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {
	@Autowired
	private MusicService musicservice;
	
	@PostMapping("/save")
	public ResponseEntity<?> addnewMusic(@RequestBody Music music){
		Music newMusic=musicservice.newMusic(music);
		ApiResponse<Music> response = new  ApiResponse<Music>("Successfully added", newMusic);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	
	}
      @GetMapping("/music")
      public ResponseEntity<?> getAllMusic(){
List<Music> musicList=musicservice.getAllMusic();
ApiResponse<List<Music>> reponse = new ApiResponse<>("Successfully fetched", musicList);
return new ResponseEntity<>(reponse,HttpStatus.OK);
      }
      
      
      @GetMapping("music/{id}")
      public ResponseEntity<?> getByid(@PathVariable int id ){
        Music musicByid=musicservice.getById(id);
        ApiResponse<Music> reponse=new ApiResponse<Music>("music by id "+id, musicByid);
        return new ResponseEntity<>(reponse,HttpStatus.OK);
      }
      
      
      @DeleteMapping("delete/{id}")
      public ResponseEntity<?> deleteByid(@PathVariable int id ){
    	  musicservice.deleteByid(id);
    	  ApiResponse<String> reponse = new ApiResponse<String>("Deleted id:"+id,null);
    	  return new ResponseEntity<>(reponse, HttpStatus.OK);
      }
      
      @PutMapping("Update/{id}")
      public ResponseEntity<?> updateMusic(@PathVariable int id ,@RequestBody Music music){
    	  Music newMusic = musicservice.updateMusic(id, music);
    	  ApiResponse<Music> reponse = new ApiResponse<Music>("Music Updated", newMusic);
    	  return new ResponseEntity<>(reponse, HttpStatus.OK);
    	  
      }
      
}
