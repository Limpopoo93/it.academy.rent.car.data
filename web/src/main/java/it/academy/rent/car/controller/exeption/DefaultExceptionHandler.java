package it.academy.rent.car.controller.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleNoSuchEntityException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        return "error";
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNoSuchEntityException(EntityNotFoundException e) {
        log.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        return "error";
    }

    @ExceptionHandler(AuthenticationException.class)
    public String handleAuthenticationException(EntityNotFoundException e) {
        log.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        return "error";
    }


    @ExceptionHandler(NullPointerException.class)
    public String handleNPException(NullPointerException e) {
        log.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleOthersException(Exception e) {
        log.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        return "error";
    }
}
