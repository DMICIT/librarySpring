package com.project.data;

import com.project.enums.Role;
import lombok.*;

@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class UserPrincipal {
    String email;
    Enum role;

}
