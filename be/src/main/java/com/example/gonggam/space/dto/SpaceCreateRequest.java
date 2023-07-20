package com.example.gonggam.space.dto;

import com.example.gonggam.util.exception.ValidationStatus;
import com.example.gonggam.util.UtilsCode;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class SpaceCreateRequest {

    @NotNull(message = ValidationStatus.Global.NO_DATA)
    private final Long ownerId;

    @NotBlank(message = ValidationStatus.Global.NOT_BLANK)
    private final String title;

    @NotBlank(message = ValidationStatus.Global.NOT_BLANK)
    private final String location;

    private String description;

    @Min(value = UtilsCode.Space.MIN_SPACE_CAPACITY, message = ValidationStatus.Space.UNDER_MIN_CAPACIRY)
    private final int capacity;

    @Min(value = UtilsCode.Space.MIN_MONEY, message = ValidationStatus.Space.UNDER_MIN_CAPACIRY)
    private final long amount;

    @DateTimeFormat(pattern = UtilsCode.Space.DATE_FORMAT)
    @NotNull(message = ValidationStatus.Global.NO_DATA)
    private final LocalDateTime startAt;

    @DateTimeFormat(pattern = UtilsCode.Space.DATE_FORMAT)
    @NotNull(message = ValidationStatus.Global.NO_DATA)
    private final LocalDateTime endAt;

    @Builder
    public SpaceCreateRequest(final long ownerId,
                              final String title,
                              final String location,
                              final String description,
                              final int capacity,
                              final long amount,
                              final LocalDateTime startAt,
                              final LocalDateTime endAt) {
        this.ownerId = ownerId;
        this.title = title;
        this.location = location;
        this.description = description;
        this.capacity = capacity;
        this.amount = amount;
        this.startAt = startAt;
        this.endAt = endAt;
    }
}
