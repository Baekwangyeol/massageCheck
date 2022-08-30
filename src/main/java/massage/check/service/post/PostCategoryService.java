package massage.check.service.post;

import massage.check.domain.post.PostCategory;
import massage.check.web.dto.category.PostCategoryDto;

import java.util.List;

public interface PostCategoryService {

    public List<PostCategoryDto.ResponseDto> findList();
}
