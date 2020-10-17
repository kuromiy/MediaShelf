package com.krmy.mediashelf.usecase.action.illust.register.provider;

import java.io.InputStream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import com.krmy.mediashelf.usecase.action.illust.register.IllustRegisterInput;

public class MyProvider {
	public static Stream<Arguments> provide() {
		return Stream.of(
			Arguments.of(
				"[TC-001]イラスト名がnullの時、DomainException「イラスト名の値は必須です。」が発生することの確認",
				InputCase.TC001.input(),
				"イラスト名の値は必須です。"
			),
			Arguments.of(
				"[TC-002]イラスト名が空文字の時、DomainException「イラスト名の値は1字以上です。」が発生することの確認",
				InputCase.TC002.input(),
				"イラスト名の値は1字以上です。"
			),
			Arguments.of(
				"[TC-003]イラスト説明がnullの時、DomainException「イラスト説明の値は必須です。」が発生することの確認",
				InputCase.TC003.input(),
				"イラスト説明の値は必須です。"
			),
			Arguments.of(
				"[TC-004]タグリストがnullの時、DomainException「タグは必須です。」が発生することの確認",
				InputCase.TC004.input(),
				"タグは必須です。"
			),
			Arguments.of(
				"[TC-005]タグリストが空の時、DomainException「タグは1個以上です。」が発生することの確認",
				InputCase.TC005.input(),
				"タグは1個以上です。"
			),
			Arguments.of(
				"[TC-006]タグリストが11個以上の時、DomainException「タグは10個以下のリストです。」が発生することの確認",
				InputCase.TC006.input(),
				"タグは10個以下のリストです。"
			),
			Arguments.of(
				"[TC-007]リソース名がnullの時、DomainException「リソース名の値は必須です。」が発生することの確認",
				InputCase.TC007.input(),
				"リソース名の値は必須です。"
			),
			Arguments.of(
				"[TC-008]リソース名が空文字の時、DomainException「リソース名の値は1字以上です。」が発生することの確認",
				InputCase.TC008.input(),
				"リソース名の値は1字以上です。"
			)
		);
	}
}

enum InputCase {
	TC001(null, "", Arrays.asList("test"), "test", null),
	TC002("", "", Arrays.asList("test"), "test", null),
	TC003("テスト", null, Arrays.asList("test"), "test", null),
	TC004("テスト", "", null, "test", null),
	TC005("テスト", "", Arrays.asList(), "test", null),
	TC006("テスト", "", IntStream.range(0, 11).mapToObj(value -> String.valueOf(value)).collect(Collectors.toList()), "test", null),
	TC007("テスト", "", Arrays.asList("test"), null, null),
	TC008("テスト", "", Arrays.asList("test"), "", null),
	;

	private IllustRegisterInput illustRegisterInput;

	private InputCase(String illustName, String illustDescription, List<String> tagList, String resourceName, InputStream resourceInputStream) {
		this.illustRegisterInput = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
	}

	public IllustRegisterInput input() {
		return this.illustRegisterInput;
	}
}
