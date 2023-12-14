package com.prism.mr.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class LeaveDto {

    private Long id;
    private Long employeeId;
    private Long leaveType;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate startAt;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate endAt;
    private String reason;
    private Integer status;
    private Double duration;
    private Long actionBy;
    private String remarks;
    private Boolean halfDay;
}
