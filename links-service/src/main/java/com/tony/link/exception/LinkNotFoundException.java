package com.tony.link.exception;

import com.tony.link.commons.context.support.JsonSerializable;

public class LinkNotFoundException extends RuntimeException implements JsonSerializable {

	public LinkNotFoundException(final String message) {
		super(message);
	}

	@Override
	public String toString() {
		return this.toLoggableJson();
	}
}
