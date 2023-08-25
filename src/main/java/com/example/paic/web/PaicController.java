package com.example.paic.web;

import com.example.paic.logic.service.CallDetailRecordsService;
import com.example.paic.logic.service.CdrLogsService;
import com.example.paic.modelo.CallDetailRecords;
import com.example.paic.modelo.CdrLogs;
import com.example.paic.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;


@RestController
@RequestMapping("/ussd")
public class PaicController {
    private final CallDetailRecordsService oCallDetailRecordsService;
    private final CdrLogsService oCdrLogsService;

    @Autowired
    public PaicController(CallDetailRecordsService oCallDetailRecordsService, CdrLogsService oCdrLogsService) {
        this.oCallDetailRecordsService = oCallDetailRecordsService;
        this.oCdrLogsService = oCdrLogsService;
    }


    /**
     * @apiNote Método que Busca cada 5 minutos una actualización en un directorio específico y así poder guardar
     * sus archivos
     */
    @GetMapping(value = "/find")
    private void fileObserver() {
        try {
            String path = "C:\\desarrollo\\PAIC\\Carpeta\\carpetaLectura\\";
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path folder = Paths.get(path);
            folder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        Path newFile = folder.resolve((Path) event.context());

                        CdrLogs oNuevoLog = new CdrLogs();
                        oNuevoLog.setCNombre(newFile.getFileName().toString());
                        oNuevoLog.setDFechaInicioCarga(Utils.getToday());

                        List<CallDetailRecords> olista = oCallDetailRecordsService.leer(newFile.toString());
                        Integer oExitosos = oCallDetailRecordsService.insertar(olista);
                        oNuevoLog.setDFechaFinalCarga(Utils.getToday());
                        oNuevoLog.setNRegistrosCargados(oExitosos);
                        oNuevoLog.setNRegistroFallidos(olista.size() - oExitosos);
                        oCdrLogsService.guardarLogs(oNuevoLog);
                        System.out.println("Log guardado : "+ oNuevoLog);
                    }
                }
                key.reset();
                Thread.sleep(10000); // Espera de 5  minutos 300000

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
