package com.krmy.mediashelf.domain.illust;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * イラスト名
 * @author Ituki Kuromiya
 *
 */
@EqualsAndHashCode(of= {"value"})
@ToString
public final class IllustName {
	@Getter
	private String value;

	public IllustName(String value) {
		if (value == null) throw new DomainException("イラスト名の値は必須です。");
		if (value.length() < 0) throw new DomainException("イラスト名の値は1字以上です。");

		this.value = value;
	}
}
