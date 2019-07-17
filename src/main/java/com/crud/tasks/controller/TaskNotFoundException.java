package com.crud.tasks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author Kamil Seweryn
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task dosen't exist")
public class TaskNotFoundException extends Exception {
}
