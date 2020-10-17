package com.krmy.mediashelf.domain.illust;

import java.time.LocalDateTime;

import com.krmy.mediashelf.domain.exception.DomainException;
import com.krmy.mediashelf.domain.resource.Resource;
import com.krmy.mediashelf.domain.tag.TagList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * イラスト
 * @author Ituki Kuromiya
 *
 */
@Getter
@EqualsAndHashCode(of= {"illustId"})
@ToString
public final class Illust {
	private IllustId illustId;
	private IllustName illustName;
	private IllustDescription illustDescription;
	private Resource resource;
	private TagList tagList;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Illust(IllustId illustId, IllustName illustName, IllustDescription illustDescription, Resource resource, TagList tagList) {
		if (illustId == null) throw new DomainException("イラストIDは必須です。");
		if (illustName == null) throw new DomainException("イラスト名は必須です。");
		if (illustDescription == null) throw new DomainException("イラスト説明は必須です。");
		if (resource == null) throw new DomainException("リソースは必須です。");
		if (tagList == null) throw new DomainException("タグは必須です。");

		this.illustId = illustId;
		this.illustName = illustName;
		this.illustDescription = illustDescription;
		this.resource = resource;
		this.tagList = tagList;
	}
}
