package com.krmy.mediashelf.domain.tag;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * タグ名
 * @author Ituki Kuromiya
 *
 */
@EqualsAndHashCode(of= {"value"})
@ToString
public final class TagName {
	@Getter
	private String value;

	public TagName(String value) {
		if (value == null) throw new DomainException("タグ名の値は必須です。");
		if (value.length() < 1) throw new DomainException("タグ名の値は0字以上です。");

		this.value = value;
	}
}
