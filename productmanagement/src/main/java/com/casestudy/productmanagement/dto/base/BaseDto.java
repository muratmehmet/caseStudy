package com.casestudy.productmanagement.dto.base;

import lombok.Data;
import java.io.Serializable;


@Data
public class BaseDto implements Serializable {
    protected Long id;
    protected String createdDate;
    protected String lastModifiedDate;
}
