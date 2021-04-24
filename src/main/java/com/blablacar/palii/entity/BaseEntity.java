package com.blablacar.palii.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.Instant;

@Getter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(updatable = false, nullable = false, length = 32)
	protected String id;

	@Version
	protected Long version;

	@CreatedDate
	@Column(updatable = false)
	protected Instant createdDate;

	@LastModifiedDate
	protected Instant updatedDate;

	@CreatedBy
	@Column(updatable = false)
	protected String createdByUser;

	@LastModifiedBy
	protected String updatedByUser;

}
