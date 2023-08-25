package com.example.paic.logic.service;

import com.example.paic.modelo.CallDetailRecords;

import java.util.List;

public interface CallDetailRecordsService {

    Integer insertar(List<CallDetailRecords> oLista);

    List<CallDetailRecords> leer(String ruta);

}
