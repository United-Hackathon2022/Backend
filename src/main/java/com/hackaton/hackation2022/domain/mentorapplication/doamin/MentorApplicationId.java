package com.hackaton.hackation2022.domain.mentorapplication.doamin;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@EqualsAndHashCode
public class MentorApplicationId implements Serializable {

    private UUID user;

    private UUID targetUser;

}
