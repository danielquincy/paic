## paic
App para realizar la busqueda de archivos nuevos a una carpeta y escribirlos en una base de datos junto con sus respectivos Logs

# Descripcion
Una aplicación que este leyendo una carpeta cada minuto y que cuando se detecte un archivo nuevo este mismo sea cargado a una sola tabla llamada "call_detail_records" en una base de datos llamada "ussd", el motor de base de datos puede ser de tu elección. De igual forma se necesita almacenar una tabla de control "cdr_logs" que registre el nombre del archivo, la fecha y hora del inicio de la carga, la hora de fin, número de registros cargados, número de registros fallidos.

