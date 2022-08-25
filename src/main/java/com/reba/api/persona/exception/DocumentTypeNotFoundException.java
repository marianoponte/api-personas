package com.reba.api.persona.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocumentTypeNotFoundException extends RuntimeException {

    private Long rejectedValue;
}
