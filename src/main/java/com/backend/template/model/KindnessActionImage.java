package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * The persistent class for the kindness_action_image database table.
 * 
 */
@Entity
@Table(name = "kindness_action_image")
@NamedQuery(name = "KindnessActionImage.findAll", query = "SELECT k FROM KindnessActionImage k")
public class KindnessActionImage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "created_time")
    private BigInteger createdTime;

    @Column(name = "image_id")
    private BigInteger imageId;

    @Column(name = "kindness_action_id")
    private BigInteger kindnessActionId;

    public KindnessActionImage() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(BigInteger createdTime) {
        this.createdTime = createdTime;
    }

    public BigInteger getImageId() {
        return this.imageId;
    }

    public void setImageId(BigInteger imageId) {
        this.imageId = imageId;
    }

    public BigInteger getKindnessActionId() {
        return this.kindnessActionId;
    }

    public void setKindnessActionId(BigInteger kindnessActionId) {
        this.kindnessActionId = kindnessActionId;
    }

}