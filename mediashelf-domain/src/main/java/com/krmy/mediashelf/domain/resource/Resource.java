package com.krmy.mediashelf.domain.resource;

import java.time.LocalDateTime;

import com.krmy.mediashelf.domain.exception.DomainException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * リソース
 * @author Ituki Kuromiya
 *
 */
@Getter
@EqualsAndHashCode(of= {"resourceId"})
@ToString
public final class Resource {
	private ResourceId resourceId;
	private ResourceName resourceName;
	private ResourcePath resourcePath;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Resource(ResourceId resourceId, ResourceName resourceName, ResourcePath resourcePath) {
		if (resourceId == null) throw new DomainException("リソースIDは必須です。");
		if (resourceName == null) throw new DomainException("リソース名は必須です。");
		if (resourcePath == null) throw new DomainException("リソースパスは必須です。");

		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourcePath = resourcePath;
	}
}
