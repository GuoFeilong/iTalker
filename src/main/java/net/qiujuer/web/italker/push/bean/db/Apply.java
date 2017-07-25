package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 申请表
 *
 * @author by user on 17/7/25.
 */
@Entity
@Table(name = "TB_APPLY")
public class Apply {

    public static final int TYPE_ADD_USER = 1;// 添加好友
    public static final int TYPE_ADD_GROUP = 1;// 添加群

    @Id
    @PrimaryKeyJoinColumn
    // 主键生成存储的UUID
    @GeneratedValue(generator = "uuid")
    // 把UUID生成器定位仪UUID2,UUID2是常规的UUID string
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    /**
     * 描述:添加好友时候的描述
     */
    @Column(nullable = false)
    private String description;

    /**
     * 附件,可以携带图片,可以为空
     */
    @Column(columnDefinition = "TEXT")
    private String attach;

    @Column(nullable = false)
    private int type;

    /**
     * 申请人
     */
    @ManyToOne
    @JoinColumn(name = "applicantId")
    private User applicant;

    @Column(updatable = false, insertable = false)
    private String applicantId;
    /**
     * 目标id,是加人还是加群,不建立主外键不进行强关联
     */
    @Column(nullable = false)
    private String targetId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
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
