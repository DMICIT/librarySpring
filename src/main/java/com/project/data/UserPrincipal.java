package com.project.data;

import lombok.*;

@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class UserPrincipal {
    String email;
    Enum role;

}
