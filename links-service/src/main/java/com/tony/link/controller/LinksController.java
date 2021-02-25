package com.tony.link.controller;

import com.tony.link.entity.LinksEntity;
import com.tony.link.service.LinksService;
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
@RequestMapping("/links")
public class LinksController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinksController.class);
	private final LinksService linksService;

	public LinksController(final LinksService userService) {
		this.linksService = userService;
	}

	@GetMapping(value = "/{linkId}/info", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinksEntity> linkInfo(@PathVariable("linkId") Integer linkId) {
		LOGGER.info("Get link info linkId={}", linkId);
//		final org.apache.commons.lang3.time.StopWatch sw = new StopWatch();

		final LinksEntity user = linksService.getLinkInfo(linkId);

		return ResponseEntity.ok().body(user);
	}

	@GetMapping(value = "/user/{userId}/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinksEntity>> userLinks(@PathVariable("userId") Integer userId) {
		LOGGER.info("Get links for userId={}", userId);

		return ResponseEntity.ok().body(linksService.getUserLinks(userId));
	}

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("Hello from links-service");
	}

	@GetMapping("/all")
	public ResponseEntity<List<LinksEntity>> all() {
		return ResponseEntity.ok(linksService.getAllLink());
	}

}
