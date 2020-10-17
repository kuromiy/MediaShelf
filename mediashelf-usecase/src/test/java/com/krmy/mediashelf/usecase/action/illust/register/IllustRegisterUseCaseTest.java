package com.krmy.mediashelf.usecase.action.illust.register;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.krmy.mediashelf.domain.exception.DomainException;
import com.krmy.mediashelf.domain.illust.IllustRepository;
import com.krmy.mediashelf.usecase.action.illust.register.mock.IllustMocksource;
import com.krmy.mediashelf.usecase.error.UseCaseError;

import io.vavr.control.Either;

@DisplayName("イラスト登録ユースケーステスト")
public class IllustRegisterUseCaseTest {
	@Nested
	@DisplayName("正常系テスト")
	public class NormalTest {}

	@Nested
	@DisplayName("異常系テスト")
	@ExtendWith(MockitoExtension.class)
	public class AbnormalTest {
		private IllustRegisterUseCase useCase;
		private IllustRepository spyIllustRepository;

		/**
		 * 初期化処理
		 */
		@BeforeEach
		public void initialize() {
			this.spyIllustRepository = Mockito.spy(IllustMocksource.class);
			this.useCase = new IllustRegisterAction(this.spyIllustRepository);
		}

		/**
		 * [TC-001]</br>
		 * イラスト名がnullの時、DomainException「イラスト名の値は必須です。」が発生することの確認
		 */
		@DisplayName("[TC-001]イラスト名がnullの時、DomainException「イラスト名の値は必須です。」が発生することの確認")
		@Test
		public void testcase001() {
			// 1. 準備
			String illustName = null;
			String illustDescription = "";
			List<String> tagList = Arrays.asList("", "");
			String resourceName = "";
			InputStream resourceInputStream = null;

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));

			// 3. 検証
			assertEquals("イラスト名の値は必須です。", exception.getMessage());
		}

		/**
		 * [TC-002]</br>
		 * イラスト名が空文字の時、DomainException「イラスト名の値は1字以上です。」が発生することの確認
		 */
		@DisplayName("[TC-002]イラスト名が空文字の時、DomainException「イラスト名の値は1字以上です。」が発生することの確認")
		@Test
		public void testcase002() {
			// 1. 準備
			String illustName = "";
			String illustDescription = "";
			List<String> tagList = Arrays.asList("", "");
			String resourceName = "";
			InputStream resourceInputStream = null;

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));

			// 3. 検証
			assertEquals("イラスト名の値は1字以上です。", exception.getMessage());
		}

		/**
		 * [TC-003]</br>
		 * イラスト説明がnullの時、DomainException「イラスト説明の値は必須です。」が発生することの確認
		 */
		@DisplayName("[TC-003]イラスト説明がnullの時、DomainException「イラスト説明の値は必須です。」が発生することの確認")
		@Test
		public void testcase003() {
			// 1. 準備
			String illustName = "テスト";
			String illustDescription = null;
			List<String> tagList = Arrays.asList("", "");
			String resourceName = "";
			InputStream resourceInputStream = null;

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));

			// 3. 検証
			assertEquals("イラスト説明の値は必須です。", exception.getMessage());
		}

		/**
		 * [TC-004]</br>
		 * タグリストがnullの時、DomainException「タグは必須です。」が発生することの確認
		 */
		@DisplayName("[TC-004]タグリストがnullの時、DomainException「タグは必須です。」が発生することの確認")
		@Test
		public void testcase004() {
			// 1. 準備
			String illustName = "テスト";
			String illustDescription = "";
			List<String> tagList = null;
			String resourceName = "test";
			InputStream resourceInputStream = null;

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));

			// 3. 検証
			assertEquals("タグは必須です。", exception.getMessage());
		}

		/**
		 * [TC-005]</br>
		 * タグリストが空の時、DomainException「タグは1個以上です。」が発生することの確認
		 */
		@DisplayName("[TC-005]タグリストが空の時、DomainException「タグは1個以上です。」が発生することの確認")
		@Test
		public void testcase005() {
			// 1. 準備
			String illustName = "テスト";
			String illustDescription = "";
			List<String> tagList = Arrays.asList();
			String resourceName = "test";
			InputStream resourceInputStream = null;

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));

			// 3. 検証
			assertEquals("タグは1個以上です。", exception.getMessage());
		}

		/**
		 * [TC-006]</br>
		 * タグリストが11個以上の時、DomainException「タグは10個以下のリストです。」が発生することの確認
		 */
		@DisplayName("[TC-006]タグリストが11個以上の時、DomainException「タグは10個以下のリストです。」が発生することの確認")
		@Test
		public void testcase006() {
			// 1. 準備
			String illustName = "テスト";
			String illustDescription = "";
			List<String> tagList = Arrays.asList("test01","test02","test03","test04","test05","test06","test07","test08","test09","test10","test11");
			String resourceName = "test";
			InputStream resourceInputStream = null;

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));

			// 3. 検証
			assertEquals("タグは10個以下のリストです。", exception.getMessage());
		}

		/**
		 * [TC-007]</br>
		 * リソース名がnullの時、DomainException「リソース名の値は必須です。」が発生することの確認
		 */
		@DisplayName("[TC-007]リソース名がnullの時、DomainException「リソース名の値は必須です。」が発生することの確認")
		@Test
		public void testcase007() {
			// 1. 準備
			String illustName = "テスト";
			String illustDescription = "";
			List<String> tagList = Arrays.asList("", "");
			String resourceName = null;
			InputStream resourceInputStream = null;

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));

			// 3. 検証
			assertEquals("リソース名の値は必須です。", exception.getMessage());
		}

		/**
		 * [TC-008]</br>
		 * リソース名が空文字の時、DomainException「リソース名の値は1字以上です。」が発生することの確認
		 */
		@DisplayName("[TC-008]リソース名が空文字の時、DomainException「リソース名の値は1字以上です。」が発生することの確認")
		@Test
		public void testcase008() {
			// 1. 準備
			String illustName = "テスト";
			String illustDescription = "";
			List<String> tagList = Arrays.asList("", "");
			String resourceName = "";
			InputStream resourceInputStream = null;

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));

			// 3. 検証
			assertEquals("リソース名の値は1字以上です。", exception.getMessage());
		}

		/**
		 * [TC-009]</br>
		 *
		 */
		@DisplayName("[TC-009]")
		@Test
		public void testcase009() {
			// 1. 準備
			String illustName = "テスト";
			String illustDescription = "";
			List<String> tagList = Arrays.asList("test001", "test002");
			String resourceName = "name";
			InputStream resourceInputStream = null;

			Mockito.when(this.spyIllustRepository.register(Mockito.any())).thenReturn(0);

			// 2. 実行
			IllustRegisterInput input = new IllustRegisterInput(illustName, illustDescription, tagList, resourceName, resourceInputStream);
			Either<UseCaseError, IllustRegisterOutput> result = this.useCase.handle(input);

			// 3. 検証
			assertTrue(result.isLeft());
			assertTrue(UseCaseError.UCE0101 == result.getLeft());
		}
	}
}
