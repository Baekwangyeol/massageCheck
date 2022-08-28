package massage.check.web.dto.post;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import massage.check.domain.post.Post;
import massage.check.web.dto.comment.CommentDto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Request,Response Dto inner class로 한 번에 관리
 */
public class PostDto {

    @Getter
    public static class RequestDto{

    }


    /**
     * 게시물 정보를 리턴할 응답 클래스
     * 엔티티 클래스를 생성장 파라미터로 받아 데이터를 Dto로 변환하여 응답
     * 별도의 전달 객체를 활용해 연관관계를 맺은 엔티티 간의 무한 참조 방지
     */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDto{
        private Long id;
        private String title;
        private String content;
        private String writer;
        private String fileName;
        private int viewCount;
        private int likeCount;
        private String createdDate, updatedDate;
        private List<CommentDto.ResponseDto> comment;

        private String categoryName;

        /*Entity - > Dto*/
        public ResponseDto(Post post){
            this.id = post.getId();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.writer = post.getMember().getNickname();
            this.fileName = post.getFileName();
            this.viewCount = post.getViewCount();
            this.likeCount = post.getLikeCount();
            this.createdDate = post.getCreatedDate();
            this.updatedDate = post.getUpdatedDate();
            this.comment = post.getComment().stream().map(CommentDto.ResponseDto:: new).collect(Collectors.toList());

            this.categoryName = post.getPostCategory().getName();
        }
    }

    /*페이징 객체*/
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponsePageDto {

        private Long id;
        private String title;
        private String writer;
        private int viewCount;
        private int likeCount;
        private String createdDate;

        private String categoryName;

        /* Entity ->Dto*/
        public ResponsePageDto(Post post){
            this.id = post.getId();
            this.title = post.getTitle();
            this.writer = post.getMember().getNickname();
            this.viewCount = post.getViewCount();
            this.likeCount = post.getLikeCount();
            this.createdDate = post.getCreatedDate();

            this.categoryName = post.getPostCategory().getName();
        }
    }



}
