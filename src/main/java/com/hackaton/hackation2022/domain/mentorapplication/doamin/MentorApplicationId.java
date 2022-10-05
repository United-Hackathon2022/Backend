package com.hackaton.hackation2022.domain.mentorapplication.doamin;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@EqualsAndHashCode
public class MentorApplicationId implements Serializable {

    private Long user;


    private Long targetUser;

}
