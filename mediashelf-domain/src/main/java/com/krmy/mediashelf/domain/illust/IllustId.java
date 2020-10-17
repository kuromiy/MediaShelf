package com.krmy.mediashelf.domain.illust;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * イラストID
 * @author Ituki Kuromiya
 *
 */
@EqualsAndHashCode(of= {"value"})
@ToString
public final class IllustId {
	@Getter
	private String value;

	public IllustId(String value) {
		if (value == null) throw new DomainException("イラストIDの値は必須です。");
		if (value.length() < 1) throw new DomainException("イラストIDの値は1字以上です。");

		this.value = value;
	}
}
