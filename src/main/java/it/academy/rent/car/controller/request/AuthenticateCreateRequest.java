package it.academy.rent.car.controller.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.ErrorConstant.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AuthenticateCreateRequest {

    private Long id;

    @Size(min = 5, message = LOGIN_INVALID)
    private String login;

    @Size(min = 5, message = PASSWORD_INVALID)
    private String password;

    private String passwordConfirm;

    @Size(min = 1, max = 15)
    @Email(message = EMAIL_INVALID)
    private String email;

    private boolean profileClose;

    private Boolean profileRemote;
}
