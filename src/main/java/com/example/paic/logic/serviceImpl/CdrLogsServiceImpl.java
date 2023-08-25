package com.example.paic.logic.serviceImpl;

import com.example.paic.logic.service.CdrLogsService;
import com.example.paic.modelo.CdrLogs;
import com.example.paic.repo.CdrLogsCrud;
import com.example.paic.repo.dao.CdrLogsDAO;
import com.example.paic.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CdrLogsServiceImpl implements CdrLogsService {
    private final CdrLogsDAO oCdrLogsDAO;
    private final CdrLogsCrud oCdrLogsCrud;

    @Autowired
    public CdrLogsServiceImpl(CdrLogsDAO oCdrLogsDAO, CdrLogsCrud oCdrLogsCrud) {
        this.oCdrLogsDAO = oCdrLogsDAO;
        this.oCdrLogsCrud = oCdrLogsCrud;
    }

    public void guardarLogs(CdrLogs oNuevo) {
        oNuevo.setDFechaFinalCarga(Utils.getToday());
        oCdrLogsCrud.save(oNuevo);
    }

    private List<CdrLogs> findAll() {
        return (List<CdrLogs>) oCdrLogsCrud.findAll();
    }


}
