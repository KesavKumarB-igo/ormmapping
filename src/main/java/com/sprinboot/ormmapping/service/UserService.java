package com.sprinboot.ormmapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.ormmapping.entity.User;
import com.sprinboot.ormmapping.mapper.UserMapper;
import com.sprinboot.ormmapping.model.UserDTO;
import com.sprinboot.ormmapping.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	@Autowired
    private UserRepository userRepository;
    
	@Autowired
	private UserMapper userMapper;

    // Create 
	public UserDTO createUser(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        return userMapper.toDto(userRepository.save(user));
    }

    // Get All
	public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    // Get by ID
	public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }
	
	//Update
	public UserDTO updateUser(Long id, UserDTO dto) {
		if(!userRepository.existsById(id))
		{
			throw new RuntimeException("User not found");
		}
        User user = userMapper.toEntity(dto);
        user.setId(id);
        return userMapper.toDto(userRepository.save(user));
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}