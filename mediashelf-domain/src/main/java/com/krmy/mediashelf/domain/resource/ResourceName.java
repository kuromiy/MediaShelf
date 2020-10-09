package com.krmy.mediashelf.domain.resource;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.Getter;

/**
 * リソース名
 * @author Ituki Kuromiya
 *
 */
public final class ResourceName {
	@Getter
	private String value;

	public ResourceName(String value) {
		if (value == null) throw new DomainException("リソース名の値は必須です。");
		if (value.length() < 0) throw new DomainException("リソース名の値は1字以上です。");

		this.value = value;
	}
}
