package com.example.paic.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@Table(name = "call_detail_records", schema = "dbo")
public class CallDetailRecords implements Serializable {

    @Column(name = "RECORD_DATE", nullable = false)
    private Timestamp recordDate;

    @Column(name = "L_SPC")
    private Integer lSpc;

    @Column(name = "L_SSN")
    private Integer lSsn;

    @Column(name = "L_RI")
    private Integer lRi;

    @Column(name = "L_GT_I")
    private Integer lGti;

    @Column(name = "L_GT_DIGITS")
    private String lGtDigits;

    @Column(name = "R_SPC")
    private Integer rSpc;

    @Column(name = "R_SSN")
    private Integer rSsn;

    @Column(name = "R_RI")
    private Integer rRi;

    @Column(name = "R_GT_I")
    private Integer rGtI;

    @Column(name = "R_GT_DIGITS", length = 18)
    private String rGtDigits;

    @Column(name = "SERVICE_CODE", length = 50)
    private String serviceCode;

    @Column(name = "OR_NATURE")
    private Integer orNature;

    @Column(name = "OR_PLAN")
    private Integer orPlan;

    @Column(name = "OR_DIGITS", length = 18)
    private String orDigits;

    @Column(name = "DE_NATURE")
    private Integer deNature;

    @Column(name = "DE_PLAN")
    private Integer dePlan;

    @Column(name = "DE_DIGITS", length = 18)
    private String deDigits;

    @Column(name = "ISDN_NATURE")
    private Integer isdnNature;

    @Column(name = "ISDN_PLAN")
    private Integer isdnPlan;

    @Column(name = "MSISDN", length = 18)
    private String msisdn;

    @Column(name = "VLR_NATURE")
    private Integer vlrNature;

    @Column(name = "VLR_PLAN")
    private Integer vlrPlan;

    @Column(name = "VLR_DIGITS", length = 18)
    private String vlrDigits;

    @Column(name = "IMSI", length = 100)
    private String imsi;

    @Column(name = "STATUS", length = 30, nullable = false)
    private String status;

    @Column(name = "TYPE", length = 30, nullable = false)
    private String type;

    @Column(name = "TSTAMP", nullable = false)
    private Timestamp tstamp;

    @Column(name = "LOCAL_DIALOG_ID")
    private BigInteger localDialogId;

    @Column(name = "REMOTE_DIALOG_ID")
    private BigInteger remoteDialogId;

    @Column(name = "DIALOG_DURATION")
    private BigInteger dialogDuration;

    @Column(name = "USSD_STRING", length = 255)
    private String ussdString;

    @Id
    @Column(name = "ID", length = 150, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public CallDetailRecords() {

    }
}
