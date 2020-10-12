package com.krmy.mediashelf.usecase.action.illust.register.mock;

import java.io.InputStream;
import java.util.UUID;

import com.krmy.mediashelf.domain.illust.Illust;
import com.krmy.mediashelf.domain.illust.IllustId;
import com.krmy.mediashelf.domain.illust.IllustRepository;
import com.krmy.mediashelf.domain.resource.ResourceId;
import com.krmy.mediashelf.domain.resource.ResourceName;
import com.krmy.mediashelf.domain.resource.ResourcePath;

public class IllustMocksource implements IllustRepository {
	@Override
	public int register(Illust illust) {
		// TODO 自動生成されたメソッド・スタブ
		return 1;
	}

	@Override
	public IllustId generateIllustId() {
		UUID uid = UUID.randomUUID();
		return new IllustId(uid.toString());
	}

	@Override
	public ResourceId generateResourceId() {
		UUID uid = UUID.randomUUID();
		return new ResourceId(uid.toString());
	}

	@Override
	public ResourcePath outputResource(InputStream inputStream, ResourceName resourceName) {
		return new ResourcePath("test");
	}
}
