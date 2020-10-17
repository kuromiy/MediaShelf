package com.krmy.mediashelf.usecase.dto;

import java.util.List;

import lombok.Data;

@Data
public class IllustDto {
	private String illustId;
	private String illustName;
	private String illustDescription;
	private ResourceDto resource;
	private List<TagDto> tagList;
}
