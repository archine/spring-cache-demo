package com.gj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Gjing
 **/
@Entity
@Table(name = "custom")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "custom_name", columnDefinition = "varchar(20) not null comment '用户名'")
    private String customName;

    @Column(name = "custom_number", columnDefinition = "int not null comment '用户编号'")
    private Integer customNumber;

    @Column(name = "create_time", columnDefinition = "datetime")
    @CreatedDate
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "datetime")
    @LastModifiedDate
    private Date updateTime;
}
