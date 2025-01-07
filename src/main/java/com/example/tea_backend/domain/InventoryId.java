package com.example.tea_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class InventoryId implements Serializable {
    @Column(name = "teaId")
    private Long teaId;

    @Column(name = "userId")
    private Long userId;
}
