package massage.check.web.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import massage.check.domain.Role;
import massage.check.domain.member.Member;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class MemberDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RequestDto {

        private Long id;

        @NotBlank(message = "아이디 입력값은 필수입니다.")
        @Pattern(regexp = "")
        private String username;

        @Pattern(regexp = "")
        private String password;

        @NotBlank(message = "닉네임은 필수 입력값입니다.")
        @Pattern(regexp = "")
        private String nickname;

        @NotBlank(message = "닉네임은 필수 입력값입니다.")
        @Pattern(regexp = "")
        private String email;

        private Role role;

        /** 암호화된 password **/
        public void encryptPassword(String BCryptpassword){
            this.password = BCryptpassword;
        }

        /*Dto ->Entity*/
        public Member entity() {
            Member member = Member.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .email(email)
                    .role(role.USER)
                    .build();
            return member;
        }
    }

    /**
     * 인증된 사용자 정보를 세션에 저장하기 위한 클래스
     * 세션에 저장하기 위해 직렬화
     */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDto implements Serializable {

        private Long id;
        private String username;
        private String nickname;
        private String email;
        private Role role;
        private String updateDate;

        /*Entity -> Dto*/
        public ResponseDto(Member member){
            this.id = member.getId();
            this.username = member.getUsername();
            this.nickname = member.getNickname();
            this.email = member.getEmail();
            this.role = member.getRole();
            this.updateDate = member.getUpdatedDate();
        }
    }
}
