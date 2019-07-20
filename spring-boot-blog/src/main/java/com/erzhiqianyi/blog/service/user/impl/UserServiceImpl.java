package com.erzhiqianyi.blog.service.user.impl;

import com.erzhiqianyi.blog.dao.reactor.user.UserRepository;
import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import com.erzhiqianyi.blog.model.enums.UserStatusEnum;
import com.erzhiqianyi.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserDto> addUser(UserDto addDto) {
        return userRepository.addUser(addDto);
    }

    @Override
    public Mono<UserDto> login(UserDto userDto) {
        return userRepository.findUserByEmail(userDto.getEmail())
                .filter(user -> user.getPassword().equalsIgnoreCase(userDto.getPassword()));
    }

    @Override
    public Mono<UserDto> deleteUser(Integer id) {
        return userRepository.findUserById(id)
                .doOnNext(userDto -> userRepository.deleteUser(userDto.getId()));

    }

    @Override
    public Mono<UserDto> updateUserStatus(Integer userId, UserStatusEnum status) {
        return userRepository
                .findUserById(userId)
                .doOnNext(userDto -> userRepository.updateUserStatus(userDto.getId(), status));
    }
}
