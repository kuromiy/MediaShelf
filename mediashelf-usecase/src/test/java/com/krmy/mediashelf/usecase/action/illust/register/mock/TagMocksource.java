package com.krmy.mediashelf.usecase.action.illust.register.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.krmy.mediashelf.domain.tag.Tag;
import com.krmy.mediashelf.domain.tag.TagId;
import com.krmy.mediashelf.domain.tag.TagName;
import com.krmy.mediashelf.domain.tag.TagRepository;

public class TagMocksource implements TagRepository {
	private List<Tag> list = new ArrayList<Tag>();

	@Override
	public Optional<Tag> findByTagName(TagName tagName) {
		Optional<Tag> tag = list.stream().filter(value -> tagName.getValue().equals(value)).findFirst();
		return tag;
	}

	@Override
	public TagId generateTagId() {
		UUID uid = UUID.randomUUID();
		TagId tagId = new TagId(uid.toString());
		return tagId;
	}
}
