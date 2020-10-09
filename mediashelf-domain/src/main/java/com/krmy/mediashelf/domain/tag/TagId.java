package com.krmy.mediashelf.domain.tag;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.Getter;

/**
 * タグID
 * TODO 同一性等のValueObjectとしてのメソッドを実装する。
 * @author Ituki Kuromiya
 *
 */
public final class TagId {
	@Getter
	private String value;

	public TagId(String value) {
		if (value == null) throw new DomainException("タグIDの値は必須です。");
		if (value.length() < 0) throw new DomainException("タグIDの値は0字以上です。");

		this.value = value;
	}
}
