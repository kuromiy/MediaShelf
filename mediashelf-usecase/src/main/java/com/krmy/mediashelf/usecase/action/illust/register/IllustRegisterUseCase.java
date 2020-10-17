package com.krmy.mediashelf.usecase.action.illust.register;

import com.krmy.mediashelf.usecase.error.UseCaseError;

import io.vavr.control.Either;

/**
 * イラスト登録ユースケース
 * @author Ituki Kuromiya
 *
 */
public interface IllustRegisterUseCase {
	public Either<UseCaseError, IllustRegisterOutput> handle(IllustRegisterInput input);
}
