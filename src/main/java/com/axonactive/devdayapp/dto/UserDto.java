package com.axonactive.devdayapp.dto;

import com.axonactive.devdayapp.domain.User;

import java.util.Date;
import java.util.List;

public class UserDto {

	private Long id;
    private String fullName;
    private String email;
    private Date createAt;
    private List<CommentDto> comments;
    private List<DeviceDto> devices;
    private List<RatingDto> ratings;
    private List<BookDto> bookInWishList;

    public static UserDto fromEntity(User entity) {
        if (entity == null) return null;
        UserDto dto = new UserDto();
        dto.id = entity.getId();
        dto.fullName = entity.getFullName();
        dto.email = entity.getEmail();
        dto.createAt = entity.getCreateAt();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<DeviceDto> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceDto> devices) {
        this.devices = devices;
    }

    public List<RatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDto> ratings) {
        this.ratings = ratings;
    }

    public List<BookDto> getBookInWishList() {
        return bookInWishList;
    }

    public void setBookInWishList(List<BookDto> bookInWishList) {
        this.bookInWishList = bookInWishList;
    }
}
