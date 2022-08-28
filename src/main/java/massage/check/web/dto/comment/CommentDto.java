package massage.check.web.dto.comment;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import massage.check.domain.comment.Comment;
import massage.check.domain.member.Member;
import massage.check.domain.post.Post;

/**
 * Request, Response Dto inner class로 한번에 관리
 */
public class CommentDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RequestDto {

        private Long id;
        private String content;
        private String createdDate, updatedDate;

        private Post post;
        private Member member;

        public void setPost(Post post){
            this.post = post;
        }

        public void setMember(Member member){
            this.member = member;
        }

        /* Dto -> Entity*/
        public Comment toEntity() {
            Comment comment = Comment.builder()
                    .id(id)
                    .content(content)
                    .member(member)
                    .post(post)
                    .build();

            return comment;
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDto {
        private Long id;
        private String content;
        private String createdDate, updatedDate;
        private String writer;

        private Long memberId;
        private Long postId;

        /* Entity -> Dto*/
        public ResponseDto(Comment comment){
            this.id = comment.getId();
            this.content = comment.getContent();
            this.writer = comment.getMember().getNickname();
            this.createdDate = comment.getCreatedDate();
            this.updatedDate = comment.getUpdatedDate();

            this.postId = comment.getPost().getId();
            this.memberId = comment.getMember().getId();
        }

    }

}
