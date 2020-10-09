package com.krmy.mediashelf.domain.tag;

import java.util.Optional;

/**
 * タグリポジトリ
 * @author Ituki Kuromiya
 *
 */
public interface TagRepository {
	/**
	 * タグ名を条件にタグを取得する。
	 *
	 * @param tagName タグ名
	 * @return タグ
	 */
	public Optional<Tag> findByTagName(TagName tagName);

	/**
	 * タグIDを生成する。
	 *
	 * @return タグID
	 */
	public TagId generateTagId();
}
