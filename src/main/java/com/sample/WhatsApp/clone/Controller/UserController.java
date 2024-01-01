package com.sample.WhatsApp.clone.Controller;

import com.sample.WhatsApp.clone.Entity.Contact;
import com.sample.WhatsApp.clone.Entity.User;
import com.sample.WhatsApp.clone.Repository.ContactRepository;
import com.sample.WhatsApp.clone.Service.ContactService;
import com.sample.WhatsApp.clone.Service.ProfilePictureService;
import com.sample.WhatsApp.clone.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

//    findContact
//--------------------------------------------------
//    POST /api/login: Authenticate and log in a user, returning a JWT token.
// ---------------------
//    MessageService: Service class for message-related operations.
//    MessageRepository: Repository interface for database operations related to messages.

//    API Endpoints:
//    POST /api/messages/send: Send a message (supports various message types).
//    GET /api/messages/{messageId}: Retrieve a specific message.
//    GET /api/conversations/{conversationId}/messages: Retrieve messages in a conversation (real-time via WebSocket for incoming messages).



    @Autowired
    private UserService userService;

    @Autowired
    private ProfilePictureService profilePictureService;
    //private Object MediaType;

//    @Autowired
//    private ContactService contactService;

    @PostMapping("/registerUser")  //http://localhost:3000/registerUser (pass JSON data)
    public User registerUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/getAllUser")  //http://localhost:3000/getAllUser
    public List<User> retreiveUser()
    {
        return userService.getAllUser();
    }

    @GetMapping("/getUserById/{id}") //http://localhost:3000/getUserById/1
    public Optional<User> getUserDetails(@PathVariable("id") Long user_id){
        return userService.getUserById(user_id);
    }

    @PutMapping("/updateUser/{id}")  //http://localhost:3000/updateUser/1 (pass JSON data)
    public User updateUser(@PathVariable("id") Long user_id, @RequestBody User user)
    {
        return userService.updateUser(user_id,user);
    }

//    @PutMapping("/addContact/{UserId}/{contactUserId}")
//    public String addContact(@PathVariable("UserId") Long UserId, @PathVariable("contactUserId") Long contactUserId)
//    {
//        return userService.addContact(UserId,contactUserId);
//    }

    @PutMapping("/addContact/{UserId}/{contactUserId}")  //http://localhost:3000/addContact/1/3
    public String addContact(@PathVariable("UserId") Long UserId, @PathVariable("contactUserId") Long contactUserId) {
        return userService.addContact(UserId, contactUserId);
    }
//
//    @PostMapping("/registerContact")  //http://localhost:3000/registerUser (pass JSON data)
//    public Contact registerContact(@RequestBody Contact contact)
//    {
//        return contactService.saveContact(contact);
//    }

    @GetMapping("/getContactsByUserId/{id}") //http://localhost:3000/getContactsByUserId/1
    public List<Contact> getContactsByUserId(@PathVariable("id") Long user_id){
        return userService.getContactsByUserId(user_id);
    }



    @PostMapping("/uploadUserImage/{userId}")
    public ResponseEntity<String> uploadProfilePicture(
            @PathVariable Long userId,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            profilePictureService.saveProfilePicture(userId, file);
            return ResponseEntity.ok("Profile picture uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile picture.");
        }
    }

    @GetMapping("/downloadUserImage/{userId}")
    public ResponseEntity<byte[]> downloadProfilePicture(@PathVariable Long userId) {
        byte[] picture = profilePictureService.getProfilePicture(userId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.IMAGE_JPEG_VALUE));
        return new ResponseEntity<>(picture, headers, HttpStatus.OK);
    }



}
