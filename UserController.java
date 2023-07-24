package com.springboot.app;

import javax.swing.text.PasswordView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.AuditLog.AuditLogRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordView passwordEncoder1; // Use an appropriate password encoder

    @PostMapping("/register")
    public <UserRegistrationRequest> ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        // Validate the request payload and create a new user
        User newUser = new User();
        newUser.setUsername(((User) request).getUsername());
        newUser.setPassword(((Object) passwordEncoder1).equals(((User) request).getPassword()));
        newUser.setEmail(((User) request).getEmail());
        newUser.setContactNumber(((User) request).getContactNumber());
        newUser.setFullName(((User) request).getFullName());

        userRepository.save(newUser);

        return ResponseEntity.ok("Registration successful!");
    }

    @Autowired
    private PasswordView passwordEncoder;

    @PostMapping("/login")
    public <LoginRequest> ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest request) {
        // Find the user by username
        User user = AuditLogRepository.findByUsername(((User) request).getUsername());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // Validate the password
        if (!passwordEncoder1.equals(((User) request).getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // Generate JWT token and return it as part of AuthResponse
        String token = generateJwtToken(user.getUsername());
        AuthResponse authResponse = new AuthResponse(token);

        return ResponseEntity.ok(authResponse);
    }

	private String generateJwtToken(String username) {
		// TODO Auto-generated method stub
		return null;
	}

   @ApiOperation(value = "Register a new user")
    @PostMapping("/register")
   public void registerUser(@RequestBody UserRegistrationRequest request) {
	
   }

    @ApiOperation(value = "Authenticate a user and get JWT token")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest request) {
		return null;
        // Existing code
    }
}
