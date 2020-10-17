package com.krmy.mediashelf.usecase.action.illust.register;

import com.krmy.mediashelf.domain.illust.Illust;
import com.krmy.mediashelf.domain.illust.IllustDescription;
import com.krmy.mediashelf.domain.illust.IllustId;
import com.krmy.mediashelf.domain.illust.IllustName;
import com.krmy.mediashelf.domain.illust.IllustRepository;
import com.krmy.mediashelf.domain.resource.Resource;
import com.krmy.mediashelf.domain.resource.ResourceId;
import com.krmy.mediashelf.domain.resource.ResourceName;
import com.krmy.mediashelf.domain.resource.ResourcePath;
import com.krmy.mediashelf.domain.tag.TagList;
import com.krmy.mediashelf.usecase.converter.IllustConverter;
import com.krmy.mediashelf.usecase.dto.IllustDto;
import com.krmy.mediashelf.usecase.error.UseCaseError;

import io.vavr.control.Either;

/**
 * イラスト登録アクション
 * @author Ituki Kuromiya
 *
 */
public final class IllustRegisterAction implements IllustRegisterUseCase {
	private IllustRepository illustRepository;

	public IllustRegisterAction(IllustRepository illustRepository) {
		this.illustRepository = illustRepository;
	}

	@Override
	public Either<UseCaseError, IllustRegisterOutput> handle(IllustRegisterInput input) {
		IllustName illustName = new IllustName(input.getIllustName());
		IllustDescription illustDescription = new IllustDescription(input.getIllustDescription());
		ResourceName resourceName = new ResourceName(input.getResourceName());
		TagList tagList = new TagList(input.getTagList());

		// 1. リソース保存
		ResourcePath resourcePath = this.illustRepository.outputResource(input.getResourceInputStream(), resourceName);

		// 2. リソースID生成
		ResourceId resourceId = this.illustRepository.generateResourceId();

		// 3. リソース作成
		Resource resource = new Resource(resourceId, resourceName, resourcePath);

		// 4. イラストID生成
		IllustId illustId = this.illustRepository.generateIllustId();

		// 5. イラスト作成
		Illust illust = new Illust(illustId, illustName, illustDescription, resource, tagList);

		// 6. イラスト登録
		Illust registeredIllust= this.illustRepository.register(illust);
		if (registeredIllust == null) return Either.left(UseCaseError.UCE0101);

		IllustDto illustDto = IllustConverter.convert(registeredIllust);
		IllustRegisterOutput output = new IllustRegisterOutput(illustDto);
		return Either.right(output);
	}
}
