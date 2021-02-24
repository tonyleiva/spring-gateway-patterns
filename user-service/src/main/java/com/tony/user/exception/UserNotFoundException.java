package com.tony.user.exception;

import com.tony.user.commons.context.support.JsonSerializable;

public class UserNotFoundException extends RuntimeException implements JsonSerializable {

	public UserNotFoundException(final String message) {
		super(message);
	}

	@Override
	public String toString() {
		return this.toLoggableJson();
	}
}
