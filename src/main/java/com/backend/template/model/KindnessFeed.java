package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * The persistent class for the kindness_feed database table.
 * 
 */
@Entity
@Table(name = "kindness_feed")
@NamedQuery(name = "KindnessFeed.findAll", query = "SELECT k FROM KindnessFeed k")
public class KindnessFeed implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "inserted_time")
    private BigInteger insertedTime;

    @Column(name = "item_id")
    private BigInteger itemId;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "source_user_id")
    private BigInteger sourceUserId;

    @Column(name = "user_id")
    private BigInteger userId;

    public KindnessFeed() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getInsertedTime() {
        return this.insertedTime;
    }

    public void setInsertedTime(BigInteger insertedTime) {
        this.insertedTime = insertedTime;
    }

    public BigInteger getItemId() {
        return this.itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigInteger getSourceUserId() {
        return this.sourceUserId;
    }

    public void setSourceUserId(BigInteger sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public BigInteger getUserId() {
        return this.userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

}