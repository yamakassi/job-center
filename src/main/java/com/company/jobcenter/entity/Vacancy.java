package com.company.jobcenter.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@JmixEntity
@Table(name = "VACANCY", indexes = {
        @Index(name = "IDX_VACANCY_JOB_CENTER_ID", columnList = "JOB_CENTER_ID")
})
@Entity
public class Vacancy {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Composition
    @OneToMany(mappedBy = "vacancy")
    @OnDelete(DeletePolicy.CASCADE)
    private List<Citizen> employees;

    @Column(name = "POSITION_", nullable = false)
    @NotNull
    private String position;

    @Column(name = "SALARY")
    private Long salary;

    @DecimalMax(message = "{msg://com.company.jobcenter.entity/Vacancy.rate.validation.DecimalMax}", value = "3")
    @PositiveOrZero(message = "{msg://com.company.jobcenter.entity/Vacancy.rate.validation.PositiveOrZero}")
    @Column(name = "RATE", nullable = false)
    @NotNull
    private Double rate;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "EMPLOYER_NAME", nullable = false)
    @NotNull
    private String employerName;

    @JoinTable(name = "VACANCY_PROFESSION_LINK",
            joinColumns = @JoinColumn(name = "VACANCY_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PROFESSION_ID", referencedColumnName = "ID"))
    @ManyToMany
    private Set<Profession> professions;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @JoinColumn(name = "JOB_CENTER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private JobCenter jobCenter;

    public void setEmployees(List<Citizen> employees) {
        this.employees = employees;
    }

    public List<Citizen> getEmployees() {
        return employees;
    }

    public Set<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(Set<Profession> professions) {
        this.professions = professions;
    }

    public JobCenter getJobCenter() {
        return jobCenter;
    }

    public void setJobCenter(JobCenter jobCenter) {
        this.jobCenter = jobCenter;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}