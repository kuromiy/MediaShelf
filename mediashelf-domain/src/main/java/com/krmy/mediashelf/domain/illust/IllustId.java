package com.krmy.mediashelf.domain.illust;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.Getter;

/**
 * イラストID
 * @author Ituki Kuromiya
 *
 */
public final class IllustId {
	@Getter
	private String value;

	public IllustId(String value) {
		if (value == null) throw new DomainException("イラストIDの値は必須です。");
		if (value.length() < 0) throw new DomainException("イラストIDの値は1字以上です。");

		this.value = value;
	}
}
