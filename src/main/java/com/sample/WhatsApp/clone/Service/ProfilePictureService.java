package com.sample.WhatsApp.clone.Service;

import com.sample.WhatsApp.clone.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface ProfilePictureService {
//    @PersistenceContext
//    private EntityManager em;
//
//    public byte[] getFileData(Long id) {
//        User file = em.find(User.class, id);
//        return file.getBlobData();
//    }
//
//    public void saveFile(String fileName, byte[] data) {
//        User file = new User();
//        file.setBlobData(data);
//
//        em.persist(file);
//    }
//
//
//    public void saveFileFromStream(String fileName, InputStream inputStream) throws IOException, IOException {
//
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        byte[] buffer = new byte[8192];
//        int bytesRead;
//
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            output.write(buffer, 0, bytesRead);
//        }
//
//        byte[] data = output.toByteArray();
//
//        User file = new User();
//        file.setBlobData(data);
//
//        em.persist(file);
//    }

    void saveProfilePicture(Long userId, MultipartFile file) throws IOException;
    public byte[] getProfilePicture(Long userId);
}
