package massage.check.service.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import massage.check.domain.comment.Comment;
import massage.check.domain.comment.CommentRepository;
import massage.check.domain.post.Post;
import massage.check.domain.post.PostRepository;
import massage.check.web.dto.comment.CommentDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public List<CommentDto.ResponseDto> findListById(Long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(() ->
                new IllegalArgumentException("댓글 조회 실패 : 해당 게시물이 존재하지 않습니다."));

        /*반환한 post의 댓글을 List 컬렉션으로 반환*/
        List<Comment> comment = post.getComment();

        /* 반환한 Comment List 컬렉션 객체를 CommentDto.ResponseDto List 컬렉션 객체로 변환*/
        return comment.stream().map(CommentDto.ResponseDto::new).collect(Collectors.toList());

    }
}
