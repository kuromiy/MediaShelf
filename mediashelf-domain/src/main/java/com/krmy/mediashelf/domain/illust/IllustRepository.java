package com.krmy.mediashelf.domain.illust;

import java.io.InputStream;

import com.krmy.mediashelf.domain.resource.ResourceId;
import com.krmy.mediashelf.domain.resource.ResourceName;
import com.krmy.mediashelf.domain.resource.ResourcePath;

/**
 * イラストリポジトリ
 * @author Ituki Kuromiya
 *
 */
public interface IllustRepository {
	/**
	 * イラストを登録する。
	 *
	 * @param illust イラスト
	 * @return 処理結果
	 */
	public Illust register(Illust illust);

	/**
	 * イラストIDを生成する。
	 *
	 * @return イラストID
	 */
	public IllustId generateIllustId();

	/**
	 * リソースIDを生成する。
	 *
	 * @return リソースID
	 */
	public ResourceId generateResourceId();

	/**
	 * リソースを外部に保存する。
	 *
	 * @param inputStream リソースのストリーム
	 * @param resourceName リソース名
	 * @return リソースパス
	 */
	public ResourcePath outputResource(InputStream inputStream, ResourceName resourceName);
}
