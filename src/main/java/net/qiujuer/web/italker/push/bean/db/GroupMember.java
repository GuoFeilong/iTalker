package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author by Jsion on 2017/7/16.
 */
@Entity
@Table(name = "TB_GROUP_MEMBER")
public class GroupMember {
    public static final int NOTIFY_LEVEL_INVALID = -1;
    public static final int NOTIFY_LEVEL_NONE = 0;
    public static final int NOTIFY_LEVEL_CLODE = 1;

    public static final int PERMISSIONT_TYPE_NONE = 0;
    public static final int PERMISSIONT_TYPE_ADMIN = 1;
    public static final int PERMISSIONT_TYPE_ADMIN_SU = 100;

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    @Column
    private String alias;

    @Column(nullable = false)
    private int notifyLevel = NOTIFY_LEVEL_NONE;

    @Column(nullable = false)
    private int permissionType = PERMISSIONT_TYPE_NONE;

    // 创建的时间戳写入数据库
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt = LocalDateTime.now();

    // 定义更新时间戳
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false, updatable = false, insertable = false)
    private String userId;


    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "groupId")
    private Group group;

    @Column(nullable = false, updatable = false, insertable = false)
    private String groupId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(int notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
