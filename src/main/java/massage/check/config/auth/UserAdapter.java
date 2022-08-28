package massage.check.config.auth;


import massage.check.domain.member.Member;
import massage.check.web.dto.member.MemberDto;

import java.util.Map;

public class UserAdapter extends CustomUserDetails{

    private Member member;
    private Map<String, Object> attributes;

    public UserAdapter(Member member){
        super(member);
        this.member =member;
    }

    public UserAdapter(Member member, Map<String,Object> attributes){
        super(member, attributes);
        this.member=member;
        this.attributes = attributes;
    }

    /** 컨트롤러에서는 Member엔티티 대신 MemberDto.ResponseDto 객체 반환하도록 함 **/
    public MemberDto.ResponseDto getMemberDto() {
         return new MemberDto.ResponseDto(member);
    }

}
