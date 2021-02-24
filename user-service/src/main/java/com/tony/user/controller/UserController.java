package com.tony.user.controller;

import com.tony.user.entity.UserEntity;
import com.tony.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/{userId}/info", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> userInfo(@PathVariable("userId") Integer userId) {
		LOGGER.info("Get user info userId={}", userId);
//		final org.apache.commons.lang3.time.StopWatch sw = new StopWatch();

		UserEntity user = userService.getUserInfo(userId);

		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("Hello from user-service");
	}

	@GetMapping("/all")
	public ResponseEntity<List<UserEntity>> all() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

}
