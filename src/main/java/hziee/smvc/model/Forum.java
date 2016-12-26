package hziee.smvc.model;

public class Forum {
    private Integer id;

    private String title;

    private Integer userId;

    private String content;

    private String types;

    private String additionStatus;

    private Integer additionId;

    private String addTime;

    private Integer floors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types == null ? null : types.trim();
    }

    public String getAdditionStatus() {
        return additionStatus;
    }

    public void setAdditionStatus(String additionStatus) {
        this.additionStatus = additionStatus == null ? null : additionStatus.trim();
    }

    public Integer getAdditionId() {
        return additionId;
    }

    public void setAdditionId(Integer additionId) {
        this.additionId = additionId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }
}