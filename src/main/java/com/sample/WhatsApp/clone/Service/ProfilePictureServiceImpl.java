package com.sample.WhatsApp.clone.Service;

import com.sample.WhatsApp.clone.Entity.User;
import com.sample.WhatsApp.clone.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProfilePictureServiceImpl implements ProfilePictureService{
    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository

    @Override
    public void saveProfilePicture(Long userId, MultipartFile file) throws IOException {
        User user = userRepository.findById(userId).get();
        user.setBlobData(file.getBytes());
        userRepository.save(user);
    }

    @Override
    public byte[] getProfilePicture(Long userId) {
        User user = userRepository.findById(userId).get();
        return user.getBlobData();
    }
}
