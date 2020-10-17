package com.krmy.mediashelf.usecase.action.illust.register;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

		@DisplayName("DomainException")
		@ParameterizedTest(name = "{0}")
		@MethodSource("com.krmy.mediashelf.usecase.action.illust.register.provider.MyProvider#provide")
		public void test(String title, IllustRegisterInput input, String errorMessage) {
			Throwable exception = assertThrows(DomainException.class, () -> this.useCase.handle(input));
			assertEquals(errorMessage, exception.getMessage());
		}

		@DisplayName("UseCaseError")
		@Test
		public void testcase() {
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
