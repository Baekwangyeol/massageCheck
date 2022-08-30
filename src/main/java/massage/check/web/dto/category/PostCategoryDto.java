package massage.check.web.dto.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import massage.check.domain.post.PostCategory;
import org.apache.coyote.Response;

public class PostCategoryDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestDto{
        private Long id;
        private String name;

        /*Dto ->Entity*/
        public PostCategory toEntity(){
            PostCategory postCategory = PostCategory.builder()
                    .id(id)
                    .name(name)
                    .build();
            return postCategory;
        }

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDto{

        private Long id;
        private String name;

        /*Entity -> Dto*/
        public ResponseDto(PostCategory postCategory){
            this.id = postCategory.getId();
            this.name = postCategory.getName();
        }
    }
}
