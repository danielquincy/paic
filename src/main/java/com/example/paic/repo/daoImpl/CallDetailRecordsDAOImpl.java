package com.example.paic.repo.daoImpl;

import com.example.paic.modelo.CallDetailRecords;
import com.example.paic.repo.dao.CallDetailRecordsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CallDetailRecordsDAOImpl implements CallDetailRecordsDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CallDetailRecordsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer insertar(List<CallDetailRecords> oLista) {
        Integer count = 0;

        for (CallDetailRecords oNuevo : oLista) {
            count += jdbcTemplate.update("" +
                            "[INSERT INTO [dbo].[call_detail_records] (" +
                            "[RECORD_DATE], " +
                            "[L_SPC]," +
                            "[L_SSN]," +
                            "[L_RI]," +
                            "[L_GT_I]," +
                            "[L_GT_DIGITS]," +
                            "[R_SPC]," +
                            "[R_SSN ]," +
                            "[R_RI]," +
                            "[R_GT_I]," +
                            "[R_GT_DIGITS]," +
                            "[SERVICE_CODE]," +
                            "[OR_NATURE]," +
                            "[OR_PLAN]," +
                            "[OR_DIGITS]," +
                            "[DE_NATURE]," +
                            "[DE_PLAN]," +
                            "[DE_DIGITS]," +
                            "[ISDN_NATURE]," +
                            "[ISDN_PLAN]," +
                            "[MSISDN]," +
                            "[VLR_NATURE]," +
                            "[VLR_PLAN]," +
                            "[VLR_DIGITS]," +
                            "[IMSI]," +
                            "[STATUS]," +
                            "[TYPE]," +
                            "[TSTAMP]," +
                            "[LOCAL_DIALOG_ID]," +
                            "[REMOTE_DIALOG_ID]," +
                            "[DIALOG_DURATION]," +
                            "[USSD_STRING]," +
                            "[ID)" +
                            "VALUES" +
                            "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    oNuevo.getRecordDate(),
                    oNuevo.getLSpc(),
                    oNuevo.getLSsn(),
                    oNuevo.getLRi(),
                    oNuevo.getLGti(),
                    oNuevo.getLGtDigits(),
                    oNuevo.getRSpc(),
                    oNuevo.getRSsn(),
                    oNuevo.getRRi(),
                    oNuevo.getRGtI(),
                    oNuevo.getRGtDigits(),
                    oNuevo.getServiceCode(),
                    oNuevo.getOrNature(),
                    oNuevo.getOrPlan(),
                    oNuevo.getOrDigits(),
                    oNuevo.getDeNature(),
                    oNuevo.getDePlan(),
                    oNuevo.getDeDigits(),
                    oNuevo.getIsdnNature(),
                    oNuevo.getIsdnPlan(),
                    oNuevo.getMsisdn(),
                    oNuevo.getVlrNature(),
                    oNuevo.getVlrPlan(),
                    oNuevo.getVlrDigits(),
                    oNuevo.getImsi(),
                    oNuevo.getStatus(),
                    oNuevo.getType(),
                    oNuevo.getTstamp(),
                    oNuevo.getLocalDialogId(),
                    oNuevo.getRemoteDialogId(),
                    oNuevo.getDialogDuration(),
                    oNuevo.getUssdString(),
                    oNuevo.getId());
        }

        return count;
    }

}
