package com.app.travelmaker.entity.eco;

import com.app.travelmaker.auditing.Period;
import com.app.travelmaker.entity.file.File;
import com.app.travelmaker.entity.notice.Notice;
import com.app.travelmaker.entity.reply.Reply;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * EcoReply Entity (에코 인증)
 * */

@Entity
@Table(name = "TBL_ECO_REPLY")
@Getter @ToString
@SQLDelete(sql = "UPDATE TBL_ECO_REPLY SET DELETED = 1 WHERE ID = ?")
@Where(clause = "DELETED = 0")
public class EcoReply extends Period {

    /**
     * EcoReply PK(고유 번호)
     * */
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    /**
     * EcoReply FK(슈퍼키 서브키)
     * PK 이자 FK 연결 Reply의 PK 와 연결됌 (N : 1)
     * */
    @MapsId
    @JoinColumn(name = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reply reply;



    /**
     * Eco (Eco 와 연관 관계) (N : 1)
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    private Eco eco;

    /**
     * EcoReply Status (에코 인증 댓글 중간 테이블 삭제 상태)
     * */
    private boolean deleted = Boolean.FALSE;

}
