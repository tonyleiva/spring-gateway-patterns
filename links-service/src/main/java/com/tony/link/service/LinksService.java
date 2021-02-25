package com.tony.link.service;

import com.tony.link.entity.LinksEntity;
import com.tony.link.exception.LinkNotFoundException;
import com.tony.link.repository.LinksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinksService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinksService.class);

	private final LinksRepository linksRepository;

	public LinksService(final LinksRepository userRepository) {
		this.linksRepository = userRepository;
	}

	public List<LinksEntity> getAllLink() {
		return linksRepository.findAll();
	}

	public LinksEntity getLinkInfo(final Integer linkId) {
		return linksRepository.findById(linkId).orElseThrow(() -> new LinkNotFoundException("Link not found"));
	}

	public List<LinksEntity> getUserLinks(final Integer userId) {
		return linksRepository.findByUserId(userId);
	}

}
