package com.ramos.examenfinal.exceptions;

import java.time.LocalDateTime;

public record CustomErrorResponse (
        LocalDateTime dateTime,
        String message,
        String path
){
}
