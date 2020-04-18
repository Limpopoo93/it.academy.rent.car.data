package it.academy.rent.car.controller.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static it.academy.rent.car.util.ErrorConstant.ERROR;

@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleNoSuchEntityException(MethodArgumentNotValidException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute(ERROR, e.getMessage());
        return ERROR;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNoSuchEntityException(EntityNotFoundException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute(ERROR, e.getMessage());
        return ERROR;
    }

    @ExceptionHandler(AuthenticationException.class)
    public String handleAuthenticationException(EntityNotFoundException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute(ERROR, e.getMessage());
        return ERROR;
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNPException(NullPointerException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute(ERROR, e.getMessage());
        return ERROR;
    }

    @ExceptionHandler(Exception.class)
    public String handleOthersException(Exception e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute(ERROR, e.getMessage());
        return ERROR;
    }
}
