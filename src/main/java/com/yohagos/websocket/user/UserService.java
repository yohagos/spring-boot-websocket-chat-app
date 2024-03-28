package com.yohagos.websocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnectUser(User user) {
        var storedUser = userRepository.findById(user.getNickname());
        if (storedUser.isPresent()) {
            storedUser.get().setStatus(Status.OFFLINE);
            userRepository.save(storedUser.get());
        }
    }

    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }

}
