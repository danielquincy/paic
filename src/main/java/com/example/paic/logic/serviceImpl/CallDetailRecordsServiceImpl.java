package com.example.paic.logic.serviceImpl;

import com.example.paic.logic.service.CallDetailRecordsService;
import com.example.paic.modelo.CallDetailRecords;
import com.example.paic.repo.CallDetailRecordsCrud;
import com.example.paic.repo.dao.CallDetailRecordsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.paic.web.utils.Utils.toTimestamp;
import static com.example.paic.web.utils.Utils.toTimestamp2;

@Service
public class CallDetailRecordsServiceImpl implements CallDetailRecordsService {

    private final CallDetailRecordsDAO oCallDetailRecordsDAO;

    private final CallDetailRecordsCrud oCallDetailRecordsCrud;

    @Autowired
    public CallDetailRecordsServiceImpl(final CallDetailRecordsDAO oCallDetailRecordsDAO,
                                        final CallDetailRecordsCrud oCallDetailRecordsCrud) {
        this.oCallDetailRecordsDAO = oCallDetailRecordsDAO;
        this.oCallDetailRecordsCrud = oCallDetailRecordsCrud;
    }

    public Integer insertar(List<CallDetailRecords> oLista) {
        if (Objects.nonNull(oLista) && !oLista.isEmpty()) {
            return oCallDetailRecordsDAO.insertar(oLista);
        } else {
            return 0;
        }
    }

    public List<CallDetailRecords> leer(String ruta) {
        List<CallDetailRecords> oNuevos = new ArrayList<>();
        String separador = "\\|";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(ruta);
            bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {

                String[] arreglo = linea.split(separador);

                oNuevos.add(new CallDetailRecords(
                        toTimestamp(arreglo[0]),
                        arreglo[1].isEmpty() ? null : Integer.valueOf(arreglo[1]),
                        arreglo[2].isEmpty() ? null : Integer.valueOf(arreglo[2]),
                        arreglo[3].isEmpty() ? null : Integer.valueOf(arreglo[3]),
                        arreglo[4].isEmpty() ? null : Integer.valueOf(arreglo[4]),
                        arreglo[5],
                        arreglo[6].isEmpty() ? null : Integer.valueOf(arreglo[6]),
                        arreglo[7].isEmpty() ? null : Integer.valueOf(arreglo[7]),
                        arreglo[8].isEmpty() ? null : Integer.valueOf(arreglo[8]),
                        arreglo[9].isEmpty() ? null : Integer.valueOf(arreglo[9]),
                        arreglo[10],
                        arreglo[11],
                        arreglo[12].isEmpty() ? null : Integer.valueOf(arreglo[12]),
                        arreglo[13].isEmpty() ? null : Integer.valueOf(arreglo[13]),
                        arreglo[14],
                        arreglo[15].isEmpty() ? null : Integer.valueOf(arreglo[15]),
                        arreglo[16].isEmpty() ? null : Integer.valueOf(arreglo[16]),
                        arreglo[17],
                        arreglo[18].isEmpty() ? null : Integer.valueOf(arreglo[18]),
                        arreglo[19].isEmpty() ? null : Integer.valueOf(arreglo[19]),
                        arreglo[20],
                        arreglo[21].isEmpty() ? null : Integer.valueOf(arreglo[21]),
                        arreglo[22].isEmpty() ? null : Integer.valueOf(arreglo[22]),
                        arreglo[23],
                        arreglo[24],
                        arreglo[25],
                        arreglo[26],
                        toTimestamp2(arreglo[27]),
                        arreglo[28].isEmpty() ? new BigInteger("0") : new BigInteger(arreglo[28]),
                        arreglo[29].isEmpty() ? new BigInteger("0") : new BigInteger(arreglo[29]),
                        arreglo[30].isEmpty() ? new BigInteger("0") : new BigInteger(arreglo[30]),
                        arreglo[31],
                        arreglo[32])
                );
            }


        } catch (IOException e) {
            System.out.println("Excepción cerrando: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }

        }
        return oNuevos;
    }

    private List<CallDetailRecords> findAll() {
        return (List<CallDetailRecords>) oCallDetailRecordsCrud.findAll();
    }


}





