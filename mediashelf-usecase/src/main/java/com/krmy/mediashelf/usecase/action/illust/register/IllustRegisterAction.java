package com.krmy.mediashelf.usecase.action.illust.register;

import java.util.List;
import java.util.stream.Collectors;

import com.krmy.mediashelf.domain.illust.Illust;
import com.krmy.mediashelf.domain.illust.IllustDescription;
import com.krmy.mediashelf.domain.illust.IllustId;
import com.krmy.mediashelf.domain.illust.IllustName;
import com.krmy.mediashelf.domain.illust.IllustRepository;
import com.krmy.mediashelf.domain.resource.Resource;
import com.krmy.mediashelf.domain.resource.ResourceId;
import com.krmy.mediashelf.domain.resource.ResourceName;
import com.krmy.mediashelf.domain.resource.ResourcePath;
import com.krmy.mediashelf.domain.tag.Tag;
import com.krmy.mediashelf.domain.tag.TagName;
import com.krmy.mediashelf.domain.tag.TagRepository;
import com.krmy.mediashelf.domain.tag.TagService;
import com.krmy.mediashelf.usecase.error.UseCaseError;

import io.vavr.control.Either;

/**
 * イラスト登録アクション
 * @author Ituki Kuromiya
 *
 */
public final class IllustRegisterAction implements IllustRegisterUseCase {
	private IllustRepository illustRepository;
	private TagService tagService;

	public IllustRegisterAction(IllustRepository illustRepository, TagRepository tagRepository) {
		this.illustRepository = illustRepository;
		this.tagService = new TagService(tagRepository);
	}

	@Override
	public Either<UseCaseError, IllustRegisterOutput> handle(IllustRegisterInput input) {
		IllustName illustName = new IllustName(input.getIllustName());
		IllustDescription illustDescription = new IllustDescription(input.getIllustDescription());
		ResourceName resourceName = new ResourceName(input.getResourceName());

		// 1. リソース保存
		ResourcePath resourcePath = this.illustRepository.outputResource(input.getResourceInputStream(), resourceName);

		// 2. リソースID生成
		ResourceId resourceId = this.illustRepository.generateResourceId();

		// 3. リソース作成
		Resource resource = new Resource(resourceId, resourceName, resourcePath);

		// 4. タグリスト作成
		List<TagName> tagNameList = input.getTagList().stream().map(TagName::new).collect(Collectors.toList());
		List<Tag> tagList = this.tagService.buildTagList(tagNameList);

		// 5. イラストID生成
		IllustId illustId = this.illustRepository.generateIllustId();

		// 6. イラスト作成
		Illust illust = new Illust(illustId, illustName, illustDescription, resource, tagList);

		// 7. イラスト登録
		int result = this.illustRepository.register(illust);
		if (result == 0) return Either.left(UseCaseError.UCE0101);

		IllustRegisterOutput output = new IllustRegisterOutput();
		return Either.right(output);
	}
}
