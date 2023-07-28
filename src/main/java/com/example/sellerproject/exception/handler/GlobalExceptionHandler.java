package com.example.sellerproject.exception.handler;

import com.example.sellerproject.exception.ProductNotValidException;
import com.example.sellerproject.exception.ResourceNotFoundException;
import com.example.sellerproject.exception.SellerNotValidException;
import com.example.sellerproject.exception.error.AppError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<AppError> productNotValidException(ProductNotValidException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<AppError> sellerNotValidException(SellerNotValidException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }


}






//    private final ObjectMapper objectMapper;
//
//    public GlobalExceptionHandler(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @ExceptionHandler(value = {IllegalArgumentException.class, ClassCastException.class, IndexOutOfBoundsException.class, MethodArgumentNotValidException.class})
//    public void exceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
//        response.setContentType("application/json");
//        response.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() {
//            {
//                put("message: ", exception.getMessage());
//                put("type: ", exception.getClass());
//            }
//        }));
//        log.error(exception.getMessage());
//    }

