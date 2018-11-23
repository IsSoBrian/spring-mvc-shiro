package com.sunp.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sunpeng
 * Date: 2017/9/3
 * Time: 19:03
 * Describe: 用户实体类
 */
public class User implements Serializable{

    public User() {}

    public User(String userId, String userName, List<String> roles, List<String> permissions, String userPassword, String salt, String userRemark) {
        this.userId = userId;
        this.userName = userName;
        this.roles = roles;
        this.permissions = permissions;
        this.userPassword = userPassword;
        this.salt = salt;
        this.userRemark = userRemark;
    }

    private String userId;
    private String userName;
    private List<String> roles;
    private List<String> permissions;
    private String userPassword;
    private String salt;
    private String userRemark;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }
}
