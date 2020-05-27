package com.backend.template.constant;

public enum StoryStatuses {

    NEW(0),

    APPROVED(1);

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private StoryStatuses(int status) {
        this.status = status;
    }

}
