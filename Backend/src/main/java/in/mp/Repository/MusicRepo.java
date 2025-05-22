package in.mp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mp.MusicEntity.Music;

public interface MusicRepo extends JpaRepository<Music, Integer> {
	
	// 

}
