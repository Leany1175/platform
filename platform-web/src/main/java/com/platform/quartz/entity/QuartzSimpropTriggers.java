package com.platform.quartz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "qrtz_simprop_triggers")
@IdClass(TriggersKey.class)
public class QuartzSimpropTriggers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "trigger_name", length = 200, nullable = false)
    private String triggerName;

    @Id
    @Column(name = "trigger_group", length = 200, nullable = false)
    private String triggerGroup;

    @Column(name = "str_prop_1", length = 512)
    private String strProp1;

    @Column(name = "str_prop_2", length = 512)
    private String strProp2;

    @Column(name = "str_prop_3", length = 512)
    private String strProp3;

    @Column(name = "int_prop_1")
    private Integer intProp1;

    @Column(name = "int_prop_2")
    private Integer intProp2;

    @Column(name = "long_prop_1")
    private BigDecimal longProp1;

    @Column(name = "long_prop_2")
    private BigDecimal longProp2;

    @Column(name = "dec_prop_1")
    private Number decProp1;

    @Column(name = "dec_prop_2")
    private Number decProp2;

    @Column(name = "bool_prop_1", length = 1)
    private String boolProp1;

    @Column(name = "bool_prop_2", length = 1)
    private String boolProp2;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getStrProp1() {
        return strProp1;
    }

    public void setStrProp1(String strProp1) {
        this.strProp1 = strProp1;
    }

    public String getStrProp2() {
        return strProp2;
    }

    public void setStrProp2(String strProp2) {
        this.strProp2 = strProp2;
    }

    public String getStrProp3() {
        return strProp3;
    }

    public void setStrProp3(String strProp3) {
        this.strProp3 = strProp3;
    }

    public Integer getIntProp1() {
        return intProp1;
    }

    public void setIntProp1(Integer intProp1) {
        this.intProp1 = intProp1;
    }

    public Integer getIntProp2() {
        return intProp2;
    }

    public void setIntProp2(Integer intProp2) {
        this.intProp2 = intProp2;
    }

    public BigDecimal getLongProp1() {
        return longProp1;
    }

    public void setLongProp1(BigDecimal longProp1) {
        this.longProp1 = longProp1;
    }

    public BigDecimal getLongProp2() {
        return longProp2;
    }

    public void setLongProp2(BigDecimal longProp2) {
        this.longProp2 = longProp2;
    }

    public Number getDecProp1() {
        return decProp1;
    }

    public void setDecProp1(Number decProp1) {
        this.decProp1 = decProp1;
    }

    public Number getDecProp2() {
        return decProp2;
    }

    public void setDecProp2(Number decProp2) {
        this.decProp2 = decProp2;
    }

    public String getBoolProp1() {
        return boolProp1;
    }

    public void setBoolProp1(String boolProp1) {
        this.boolProp1 = boolProp1;
    }

    public String getBoolProp2() {
        return boolProp2;
    }

    public void setBoolProp2(String boolProp2) {
        this.boolProp2 = boolProp2;
    }
}
