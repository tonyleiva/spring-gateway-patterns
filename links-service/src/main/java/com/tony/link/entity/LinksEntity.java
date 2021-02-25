package com.tony.link.entity;

import com.tony.link.commons.context.support.JsonSerializable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "links")
public class LinksEntity implements JsonSerializable {
	private static final long serialVersionUID = 4706303902013524247L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "text")
	private String text;

	@Column(name = "link")
	private String link;

	@Column(name = "position")
	private Integer position;

	@Column(name = "active")
	private Boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return hashCode() == obj.getClass().cast(LinksEntity.class).hashCode();
	}

	@Override
	public String toString() {
		return this.toLoggableJson();
	}
}
