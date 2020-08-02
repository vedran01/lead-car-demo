package com.vbradara.web.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

  private LocalDateTime timestamp;
  private int status;
  private String message;
  private String path;
  private List<String> params;

  private ErrorResponse(HttpStatus status, String message, String path){
    this.timestamp = LocalDateTime.now();
    this.status = status.value();
    this.message = message;
    this.path = path;
  }

  public static ErrorResponse of(HttpStatus status, String message, String path){
    return new ErrorResponse(status, message, path);
  }

  public static ErrorResponse of(HttpStatus status, String message, String path, List<String> errors) {
    ErrorResponse errorResponse = new ErrorResponse(status, message, path);
    errorResponse.params = errors;
    return errorResponse;
  }
}
