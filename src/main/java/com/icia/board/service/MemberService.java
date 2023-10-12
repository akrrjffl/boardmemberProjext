package com.icia.board.service;

import com.icia.board.dto.MemberDTO;
import com.icia.board.entity.MemberEntity;
import com.icia.board.repository.MemberFileRepository;
import com.icia.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberFileRepository memberFileRepository;

    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> optionalMemberEntity =
                memberRepository.findByMemberEmailAndMemberPassword(memberDTO.getMemberEmail(), memberDTO.getMemberPassword());
        if (optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity = optionalMemberEntity.get(); // optional안에있는 Entity를 사용하기 위해 벗겨내는 역할
            MemberDTO loginDTO = MemberDTO.toDTO(memberEntity);     // 벗겨낸 entity의 값을 DTO로 바꿔 DTO를 저장
            return loginDTO;
        } else {
            return null;
        }
    }
}
