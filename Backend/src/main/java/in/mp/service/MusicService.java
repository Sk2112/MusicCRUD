package in.mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import in.mp.MusicEntity.Music;
import in.mp.Repository.MusicRepo;

@Service
public class MusicService {
	@Autowired
	private MusicRepo musicrepo;

	// adding new music or post request
	public Music newMusic(Music music) {
		return musicrepo.save(music);
	}

	// getting all music

	public List<Music> getAllMusic() {
		return musicrepo.findAll();
	}

	public Music getById(int id) {
		return musicrepo.findById(id).get();
	}

	// delete music
	public void deleteByid(int id) {
		musicrepo.deleteById(id);
	}

	public Music updateMusic( @PathVariable  int id,  @RequestBody Music music) {

		Music existedMusic = musicrepo.findById(id).get();
		existedMusic.setSongName(music.getSongName());
		existedMusic.setSongDuration(music.getSongDuration());
		return musicrepo.save(existedMusic);

	}

}
