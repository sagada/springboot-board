package com.algo.inc.web.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardUpdateRequestDto(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}