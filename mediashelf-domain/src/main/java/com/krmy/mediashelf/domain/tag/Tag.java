package com.krmy.mediashelf.domain.tag;

import com.krmy.mediashelf.domain.exception.DomainException;

/**
 * タグ
 * TODO 作成日・更新日等を実装する。
 * @author Ituki Kuromiya
 *
 */
public final class Tag {
	private TagId tagId;
	private TagName tagName;

	private Tag(TagId tagId, TagName tagName) {
		if (tagId == null) throw new DomainException("タグIDは必須です。");
		if (tagName == null) throw new DomainException("タグ名は必須です。");

		this.tagId = tagId;
		this.tagName = tagName;
	}

	protected static Tag create(TagId tagId, TagName tagName) {
		return new Tag(tagId, tagName);
	}

	public String getTagId() {
		return this.tagId.getValue();
	}

	public String getTagName() {
		return this.tagName.getValue();
	}
}
