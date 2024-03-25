package sg.edu.ntu.singastays.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import sg.edu.ntu.singastays.entities.ErrorResponse;
import sg.edu.ntu.singastays.exceptions.AttractionNotFoundException;
import sg.edu.ntu.singastays.exceptions.CategoryAlreadyExistsException;
import sg.edu.ntu.singastays.exceptions.CategoryNotFoundException;
import sg.edu.ntu.singastays.exceptions.DeleteNonEmptyCategoryException;
import sg.edu.ntu.singastays.exceptions.MemberNotFoundException;
import sg.edu.ntu.singastays.exceptions.AttractionNotFoundException;
// import sg.edu.ntu.singastays.exceptions.InteractionNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // this is handler for MemberNotFoundException, CategoryNotFoundException,
    // AttractionNotFoundException
    @ExceptionHandler({ MemberNotFoundException.class, CategoryNotFoundException.class,
            AttractionNotFoundException.class })
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    // this is handler for DeleteNonEmptyCategoryException, CategoryAlreadyExistsException
    @ExceptionHandler({ DeleteNonEmptyCategoryException.class, CategoryAlreadyExistsException.class })
    public ResponseEntity<ErrorResponse> handleConflictsException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    // [Activity 1 - Refactor]
    // @ExceptionHandler(InteractionNotFoundException.class)
    // public ResponseEntity<ErrorResponse>
    // handleInteractionNotFoundException(MemberNotFoundException ex){
    // ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
    // LocalDateTime.now());
    // return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    // }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Item does not exist.", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Get a list of all validation errors from the exception object
        List<ObjectError> validationErrors = ex.getBindingResult().getAllErrors();

        // Create a StringBuilder to store all error messages
        StringBuilder sb = new StringBuilder();

        for (ObjectError error : validationErrors) {
            sb.append(error.getDefaultMessage() + ".");
        }

        ErrorResponse errorResponse = new ErrorResponse(sb.toString(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // We can log the exception here
        // logger.error(ex.getMessage(), ex);

        // return generic error message;
        ErrorResponse errorResponse = new ErrorResponse("Something went wrongssss", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
