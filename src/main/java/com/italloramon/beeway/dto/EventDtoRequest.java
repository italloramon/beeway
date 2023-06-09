package com.italloramon.beeway.dto;

import com.italloramon.beeway.model.User;
import com.italloramon.beeway.model.Voucher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EventDtoRequest {
    private String title;
    private String description;

    private Integer maximumVouchers;

    private String imageUrl;

    private List<Voucher> currentVouchers;

    private User createdBy;
}
