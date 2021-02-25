package com.tony.link.commons.context.support;

import com.tony.link.commons.util.JsonUtil;

import java.io.Serializable;
import java.text.MessageFormat;

public interface JsonSerializable extends Serializable {
	default String toJson() {
		return JsonUtil.toJson(this);
	}

	default String toLoggableJson() {
		String simpleName = this.getClass().getSimpleName();
		return MessageFormat.format("{0} -> [{1}]", simpleName, JsonUtil.toJson(this));
	}
}
