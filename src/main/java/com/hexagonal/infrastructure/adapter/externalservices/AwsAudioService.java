package com.hexagonal.infrastructure.adapter.externalservices;

import org.springframework.stereotype.Service;

import com.hexagonal.domain.port.TaskAudioPort;
import com.hexagonal.infrastructure.adapter.entity.AudioEntity;
import com.hexagonal.infrastructure.adapter.repository.AudioRepository;

@Service
public class AwsAudioService implements TaskAudioPort {

	private final AudioRepository audioRepository;
	
	public AwsAudioService(AudioRepository audioRepository){
		this.audioRepository = audioRepository;
		
	}
	
	
    @Override
    public String saveAudio() {
    	AudioEntity audio = new AudioEntity();
    	audio.setUrl("url");
    	audioRepository.save(audio);
        return audio.getId();

    }
}
