package com.sprinboot.ormmapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.ormmapping.entity.Profile;
import com.sprinboot.ormmapping.mapper.ProfileMapper;
import com.sprinboot.ormmapping.model.ProfileDTO;
import com.sprinboot.ormmapping.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {

	@Autowired
    private ProfileRepository profileRepository;

	@Autowired
	private ProfileMapper profileMapper;

    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        Profile profile = profileMapper.toEntity(profileDTO);
        return profileMapper.toDto(profileRepository.save(profile));
    }

    public List<ProfileDTO> getAllProfiles() {
        return profileRepository.findAll()
                .stream().map(profileMapper::toDto).collect(Collectors.toList());
    }

    public ProfileDTO getProfileById(Long id) {
        return profileRepository.findById(id)
                .map(profileMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
    
    public ProfileDTO updateProfile(Long id, ProfileDTO dto) {
		if(!profileRepository.existsById(id))
		{
			throw new RuntimeException("Profile not found");
		}
        Profile profile = profileMapper.toEntity(dto);
        profile.setId(id);
        return profileMapper.toDto(profileRepository.save(profile));
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}