package massage.check.domain.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    /*카테고리 id로 post 찾기*/
    Page<Post> findByPostCategory_Name(String category_Name, Pageable pageable);

    Page<Post> findByPostCategory_NameContainingIgnoreCase(String category_name, String keyword, Pageable pageable);

    /* 카테고리 name 과 member id로 post찾기*/
    Page<Post> findByPostCategory_NameAndByMember_Id(String category_name,Long member_id, Pageable pageable);
}
