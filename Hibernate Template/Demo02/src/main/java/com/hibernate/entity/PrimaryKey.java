package com.hibernate.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PrimaryKey implements Serializable {
    private int id;
    private int petId;
}