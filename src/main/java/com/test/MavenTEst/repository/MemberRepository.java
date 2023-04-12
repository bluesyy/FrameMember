package com.test.MavenTEst.repository;

import com.test.MavenTEst.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    /**
        DB와 연관이 있는 리파지토리 클래스
     */

    // 의존성 주입 필요
    // mybatis 에서 제공
    private final SqlSessionTemplate sql;

    public int save(MemberDTO memberDTO) {
        // db 연동 전에 잘 전달되나 확인
        System.out.println("memberDTO = " + memberDTO);
        /*
            <mapper namespace="Member"> Member
                <insert id="save" parameterType="member"> .save
         */
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll"); // 매개변수 없이 전체 데이터를 가져옴
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }
}
