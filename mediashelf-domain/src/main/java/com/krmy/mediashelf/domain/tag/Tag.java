package com.krmy.mediashelf.domain.tag;

import java.time.LocalDateTime;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * タグ
 * @author Ituki Kuromiya
 *
 */
@Getter
@EqualsAndHashCode(of= {"tagId"})
@ToString
public final class Tag {
	private TagId tagId;
	private TagName tagName;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private Tag(TagName tagName) {
		this.tagName = tagName;
	}

	private Tag(TagId tagId, TagName tagName) {
		if (tagId == null) throw new DomainException("タグIDは必須です。");
		if (tagName == null) throw new DomainException("タグ名は必須です。");

		this.tagId = tagId;
		this.tagName = tagName;
	}

	public static Tag precreate(TagName tagName) {
		return new Tag(tagName);
	}

	protected static Tag create(TagId tagId, TagName tagName) {
		return new Tag(tagId, tagName);
	}
}
