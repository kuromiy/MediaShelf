package com.krmy.mediashelf.domain.tag;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.Getter;

/**
 * タグ名
 * TODO 同一性等のValueObjectとしてのメソッドを実装する。
 * @author Ituki Kuromiya
 *
 */
public final class TagName {
	@Getter
	private String value;

	public TagName(String value) {
		if (value == null) throw new DomainException("タグ名の値は必須です。");
		if (value.length() < 0) throw new DomainException("タグ名の値は0字以上です。");

		this.value = value;
	}
}
