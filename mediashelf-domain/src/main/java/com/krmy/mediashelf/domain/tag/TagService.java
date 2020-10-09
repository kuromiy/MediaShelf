package com.krmy.mediashelf.domain.tag;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.krmy.mediashelf.domain.exception.DomainException;

/**
 * タグサービス
 * @author Ituki Kuromiya
 *
 */
public final class TagService {
	private TagRepository tagRepository;

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	/**
	 * タグ名リストからタグリストを作成する。
	 *
	 * @param tagNameList タグ名リスト
	 * @return タグリスト
	 */
	public List<Tag> buildTagList(List<TagName> tagNameList) {
		if (tagNameList.size() > 10) throw new DomainException("タグは10個以下のリストです。");

		List<Tag> tagList = tagNameList.stream()
				.map((tagName) -> {
					Optional<Tag> foundTag = this.tagRepository.findByTagName(tagName);
					return foundTag.orElseGet(() -> this.buildTag(tagName));
				})
				.collect(Collectors.toList());
		return tagList;
	}

	/**
	 * タグ名からタグを作成する。
	 *
	 * @param tagName タグ名
	 * @return タグ
	 */
	private Tag buildTag(TagName tagName) {
		TagId tagId = this.tagRepository.generateTagId();
		return Tag.create(tagId, tagName);
	}
}
