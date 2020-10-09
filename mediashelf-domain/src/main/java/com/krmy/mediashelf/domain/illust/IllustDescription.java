package com.krmy.mediashelf.domain.illust;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.Getter;

/**
 * イラスト説明
 * @author Ituki Kuromiya
 *
 */
public final class IllustDescription {
	@Getter
	private String value;

	public IllustDescription(String value) {
		if (value == null) throw new DomainException("イラスト説明の値は必須です。");

		this.value = value;
	}
}
