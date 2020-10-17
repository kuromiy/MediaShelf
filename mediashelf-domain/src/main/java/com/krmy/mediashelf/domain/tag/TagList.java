package com.krmy.mediashelf.domain.tag;

import java.util.List;
import java.util.stream.Collectors;

import com.krmy.mediashelf.domain.exception.DomainException;

/**
 * タグリスト
 * @author Ituki Kuromiya
 *
 */
public final class TagList {
	private List<Tag> valueList;

	public TagList(List<String> valueList) {
		if (valueList == null) throw new DomainException("タグは必須です。");
		if (valueList.size() < 1) throw new DomainException("タグは1個以上です。");
		if (valueList.size() > 10) throw new DomainException("タグは10個以下のリストです。");

		this.valueList = valueList.stream()
				.map(value -> {
					return Tag.precreate(new TagName(value));
				})
				.collect(Collectors.toList());
	}
}
