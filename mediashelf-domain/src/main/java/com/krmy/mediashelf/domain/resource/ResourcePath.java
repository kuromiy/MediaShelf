package com.krmy.mediashelf.domain.resource;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.Getter;

/**
 * リソースパス
 * @author Ituki Kuromiya
 *
 */
public final class ResourcePath {
	@Getter
	private String value;

	public ResourcePath(String value) {
		if (value == null) throw new DomainException("リソースパスの値は必須です。");
		if (value.length() < 0) throw new DomainException("リソースパスの値は1字以上です。");

		this.value = value;
	}
}
