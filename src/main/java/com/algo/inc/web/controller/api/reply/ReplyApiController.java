package com.algo.inc.web.controller.api.reply;

import com.algo.inc.web.dto.reply.ReplyResponseDto;
import com.algo.inc.web.dto.reply.ReplySaveRequestDto;
import com.algo.inc.web.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/replies")
@Log4j2
public class ReplyApiController {

    private final ReplyService replyService;

    // Create, boardId번 게시글에 댓글을 새로 추가한다.
    @PostMapping("/{boardId}")
    public Long registerReply(
            @PathVariable Long boardId,
            @RequestBody ReplySaveRequestDto replySaveRequestDto)
    {
        log.info("registerReply : {}", boardId);
        return replyService.registerReply(boardId, replySaveRequestDto);
    }

    // Read, boardId번 게시글에 달린 모든 댓글을 읽어온다
    @GetMapping("/{boardId}")
    public List<ReplyResponseDto> findReplyOnPost(@PathVariable Long boardId)
    {
        return replyService.findReplyOnPost(boardId);
    }

    // Update, replyId번 댓글을 수정한다.
    @PutMapping("/{replyId}")
    public Long updateReply(@PathVariable Long replyId, @RequestBody ReplySaveRequestDto replySaveRequestDto)
    {
        return replyService.updateReply(replyId,replySaveRequestDto);
    }

    // Delete, replyId번 댓글을 삭제한다.
    @DeleteMapping("/{boardId}/{replyId}")
    public ResponseEntity<List<ReplyResponseDto>> deleteReply(@PathVariable Long replyId, @PathVariable Long boardId)
    {
        return new ResponseEntity<>(replyService.deleteReply(boardId, replyId), HttpStatus.OK);
    }

}
