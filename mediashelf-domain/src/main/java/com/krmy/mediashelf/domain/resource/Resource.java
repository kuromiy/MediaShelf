package com.krmy.mediashelf.domain.resource;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.Getter;

/**
 * リソース
 * @author Ituki Kuromiya
 *
 */
@Getter
public final class Resource {
	private ResourceId resourceId;
	private ResourceName resourceName;
	private ResourcePath resourcePath;

	public Resource(ResourceId resourceId, ResourceName resourceName, ResourcePath resourcePath) {
		if (resourceId == null) throw new DomainException("リソースIDは必須です。");
		if (resourceName == null) throw new DomainException("リソース名は必須です。");
		if (resourcePath == null) throw new DomainException("リソースパスは必須です。");

		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourcePath = resourcePath;
	}
}
