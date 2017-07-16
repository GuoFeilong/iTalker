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
@Table(name = "TB_USER_FOLLOW")
public class UserFollow {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    // 定义一个发起人,你关注默认,这里代表你自己
    // 多对1 你可以关注很多人,你的每次关注都是一条记录
    // User对应多个UserFollow
    // optional 不可选,必须存储,
    @ManyToOne(optional = false)
    // 定义关联的表字段,为originId,对应user.id
    @JoinColumn(name = "originId")
    private User origin;

    @Column(nullable = false, updatable = false, insertable = false)
    private String originId;

    // 定义关注目标,你关注的人
    // 也是多对1,你可以被多人关注,每次关注都是一条记录
    // 多个userfollow 对应多一个user
    @ManyToOne(optional = false)
    //定义关联的targetiD,对应的也是uesr.id
    @JoinColumn(name = "targetId")
    private User target;

    @Column(nullable = false, updatable = false, insertable = false)
    private String targetId;

    // 别名,对target的备注
    @Column
    private String alias;

    // 创建的时间戳写入数据库
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt = LocalDateTime.now();

    // 定义更新时间戳
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOrigin() {
        return origin;
    }

    public void setOrigin(User origin) {
        this.origin = origin;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
}
