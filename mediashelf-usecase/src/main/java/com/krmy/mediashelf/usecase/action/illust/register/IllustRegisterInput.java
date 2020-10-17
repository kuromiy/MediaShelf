package com.krmy.mediashelf.usecase.action.illust.register;

import java.io.InputStream;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * イラスト登録入力情報
 * @author Ituki Kuromiya
 *
 */
@AllArgsConstructor
@Getter
public final class IllustRegisterInput {
	private String illustName;
	private String illustDescription;
	private List<String> tagList;
	private String resourceName;
	private InputStream resourceInputStream;
}
