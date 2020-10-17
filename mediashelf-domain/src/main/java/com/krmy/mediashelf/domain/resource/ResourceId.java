package com.krmy.mediashelf.domain.resource;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * リソースID
 * @author Ituki Kuromiya
 *
 */
@EqualsAndHashCode(of= {"value"})
@ToString
public final class ResourceId {
	@Getter
	private String value;

	public ResourceId(String value) {
		if (value == null) throw new DomainException("リソースIDの値は必須です。");
		if (value.length() < 1) throw new DomainException("リソースIDの値は0字以上です。");

		this.value = value;
	}
}
