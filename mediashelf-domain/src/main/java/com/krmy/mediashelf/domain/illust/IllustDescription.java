package com.krmy.mediashelf.domain.illust;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * イラスト説明
 * @author Ituki Kuromiya
 *
 */
@EqualsAndHashCode(of= {"value"})
@ToString
public final class IllustDescription {
	@Getter
	private String value;

	public IllustDescription(String value) {
		if (value == null) throw new DomainException("イラスト説明の値は必須です。");

		this.value = value;
	}
}
