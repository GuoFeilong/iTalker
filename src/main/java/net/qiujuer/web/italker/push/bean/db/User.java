package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户model,对应数据库的
 *
 * @author by Jsion on 2017/7/16.
 */
@Entity
@Table(name = "TAB_USER")
public class User {
    // 主键盘
    @Id
    @PrimaryKeyJoinColumn
    // 主键生成存储的UUID
    @GeneratedValue(generator = "uuid")
    // 把UUID生成器定位仪UUID2,UUID2是常规的UUID string
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    @Column(nullable = false, length = 128, unique = true)
    private String name;

    @Column(nullable = false, length = 62, unique = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column
    private String portrait;

    @Column
    private String description;

    // 性别有初始值
    @Column(nullable = false)
    private int sex = 0;

    // token 可以拉取用户信息,素有token必须唯一
    @Column(unique = true)
    private String token;

    // 用于推送的设别ID;
    @Column
    private String pushID;

    // 创建的时间戳写入数据库
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt = LocalDateTime.now();

    // 定义更新时间戳
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    // 最后时间戳写入数据库
    @Column
    private LocalDateTime lastReceivedAt = LocalDateTime.now();


    // 我关注的人的列表,对应的数据库表字段为TB_USER_FOLLOW的.originID
    @JoinColumn(name = "originId")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserFollow> following = new HashSet<>();


    @JoinColumn(name = "targetId")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserFollow> followers = new HashSet<>();

    // 懒加载用户群
    @JoinColumn(name = "ownerId")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Group> groups = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPushID() {
        return pushID;
    }

    public void setPushID(String pushID) {
        this.pushID = pushID;
    }

    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getLastReceivedAt() {
        return lastReceivedAt;
    }

    public void setLastReceivedAt(LocalDateTime lastReceivedAt) {
        this.lastReceivedAt = lastReceivedAt;
    }

    public Set<UserFollow> getFollowing() {
        return following;
    }

    public void setFollowing(Set<UserFollow> following) {
        this.following = following;
    }

    public Set<UserFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserFollow> followers) {
        this.followers = followers;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}

