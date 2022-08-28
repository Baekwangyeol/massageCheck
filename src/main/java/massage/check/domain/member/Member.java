package massage.check.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import massage.check.domain.BaseTimeEntity;
import massage.check.domain.Role;
import massage.check.domain.cart.Cart;
import massage.check.domain.lecture.Lecture;
import massage.check.domain.lecture.MemberWishLecture;
import massage.check.domain.lecture.MyLecture;
import massage.check.domain.post.MemberLikePost;
import massage.check.domain.post.Post;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* 로그인 할 회원 아이디 */
    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; //회원가입시 무조건 user로 설정할 것

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL,orphanRemoval = true)
    @OrderBy("id asc")
    private List<Post> post;

    @OneToMany(mappedBy = "member")
    @OrderBy("id asc")
    private List<Lecture> lecture;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    private List<Cart> cart;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    private List<MemberWishLecture> wish;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    private List<MemberLikePost> like;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    private List<MyLecture> myLecture;

    /* 회원 수정 메서드*/
    public void update(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }

    /* 소셜 로그인 시 이미 등록된 회원인 경우 수정 날짜 업데이트 , 기존 데이터는 보존 */
    public Member updateUpdateDate() {
        this.onPreUpdate();  //수정 날짜 업데이트
        return this;
    }

}
