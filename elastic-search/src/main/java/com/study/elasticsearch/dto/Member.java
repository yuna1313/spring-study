package com.study.elasticsearch.dto;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Builder
@Getter
@NoArgsConstructor
@Document(indexName = "members")
@Data
public class Member {
    private Long id;
    private String nickname;
    private String profilePath;

    public Member(Long id, String nickname, String profileUrl) {
        this.id = id;
        this.nickname = nickname;
        this.profilePath = profileUrl;
    }
}
