package massage.check.service.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import massage.check.domain.post.PostCategory;
import massage.check.domain.post.PostCategoryRepository;
import massage.check.web.dto.category.PostCategoryDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostCategoryServiceImpl implements PostCategoryService{

    private final PostCategoryRepository postCategoryRepository;

    @Override
    public List<PostCategoryDto.ResponseDto> findList() {
        List<PostCategory> postsCategoryList = postCategoryRepository.findAll();

        /* 반환한 PostCategory List 컬렉션 객체를 PostCategoryDto.ResponseDto List 컬렉션 객체로 변환*/
        return postsCategoryList.stream().map(PostCategoryDto.ResponseDto::new).collect(Collectors.toList());
    }
}
