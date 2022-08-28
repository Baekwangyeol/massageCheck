package massage.check.domain.lecture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import massage.check.domain.BaseTimeEntity;
import massage.check.domain.member.Member;
import massage.check.domain.review.Review;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Lecture extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tutor; //강사

    @Column(nullable = false, unique = true)
    private String title;

    /* 강의 소개 */
    @Column(nullable = false)
    private String intro;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    /* 파일 경로명 */
    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lectureCategory_id")
    private LectureCategory lectureCategory;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> review;
}
