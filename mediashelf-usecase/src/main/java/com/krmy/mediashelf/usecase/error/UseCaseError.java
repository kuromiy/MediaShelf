package com.krmy.mediashelf.usecase.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユースケースエラー</br>
 * 以下ルールでエラーコードを割り振る。</br>
 * UCE(UseCaseErrorの短縮) + "-" + XX(機能番号) + XX(機能毎連番)
 * @author Ituki Kuromiya
 *
 */
@AllArgsConstructor
@Getter
public enum UseCaseError {
	DEFAULT("0000", "未実装", "未実装エラー"),
	/** UCE-01 イラスト登録ユースケースエラー */
	UCE0101("UCE-0101", "イラスト登録エラー", "イラスト登録に失敗しました。"),
	;

	private String errorCode;
	private String errorName;
	private String errorMessage;
}
