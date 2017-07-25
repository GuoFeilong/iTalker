package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author by user on 17/7/25.
 */
@Entity
@Table(name = "TB_PUSH_HISTORY")
public class PushHistory {
    @Id
    @PrimaryKeyJoinColumn
    // 主键生成存储的UUID
    @GeneratedValue(generator = "uuid")
    // 把UUID生成器定位仪UUID2,UUID2是常规的UUID string
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    /**
     * 推送的具体实体都是存储的JSON字符串,设置大字段类型
     */
    @Lob
    @Column(nullable = false, columnDefinition = "BLOB")
    private String entity;

    @Column(nullable = false)
    private int entityType;

    /**
     * 接受者不允许为空,一个接受者可以接受很多消息
     * 加载一条推送消息的时候直接加载用户信息
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "receiverId")
    private User receiver;

    @Column(nullable = false, updatable = false, insertable = false)
    private String receiverId;

    @Column
    private String receiverPushId;


    /**
     * 发送者可能为空,可能为系统信息
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "senderId")
    private User sender;

    @Column(updatable = false, insertable = false)
    private String senderId;

    // 创建的时间戳写入数据库
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt = LocalDateTime.now();

    // 定义更新时间戳
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    // 定义消息送达的时间可以为空
    @Column
    private LocalDateTime arrivalAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverPushId() {
        return receiverPushId;
    }

    public void setReceiverPushId(String receiverPushId) {
        this.receiverPushId = receiverPushId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
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

    public LocalDateTime getArrivalAt() {
        return arrivalAt;
    }

    public void setArrivalAt(LocalDateTime arrivalAt) {
        this.arrivalAt = arrivalAt;
    }
}
