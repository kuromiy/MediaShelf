package com.krmy.mediashelf.usecase.action.illust.register;

import com.krmy.mediashelf.usecase.dto.IllustDto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * イラスト登録出力情報
 * @author Ituki Kuromiya
 *
 */
@AllArgsConstructor
@Data
public final class IllustRegisterOutput {
	private IllustDto illust;
}
