# COMANDOS LINUX #
1. **ps:**
ps aux
*Este comando mostrará una lista completa de todos los procesos en ejecución con detalles extensos.*

2. **top**
top
*Este comando proporcionará una visión en tiempo real de los procesos que consumen más recursos en el sistema. Para salir de top, puedes presionar la tecla q.*

3. **htop**
htop
*Similar a top, pero con una interfaz más amigable y opciones de personalización. También puedes salir de htop presionando la tecla q.*

4. **kill**
kill -9 PID
*Este comando enviará la señal SIGKILL al proceso con el ID especificado (PID), forzando su terminación.*

5. **pgrep**
pgrep nombre_del_proceso
*Encuentra el PID de un proceso basado en su nombre.*

6. **pkill**
pkill -SIGTERM nombre_del_proceso
*Envía la señal SIGTERM al proceso con el nombre especificado, permitiéndole realizar una salida limpia.*

7. **killall**
killall nombre_del_proceso
*Detiene todos los procesos con el nombre especificado.*

8. **nice y renice**
nice -n 10 comando
*Establece la prioridad de ejecución de un comando. Puedes usar renice para cambiar la prioridad de un proceso en ejecución.*

9. **jobs**
jobs
*Muestra los trabajos en segundo plano en el shell actual.*

10. **bg y fg**
bg %1
fg %1
*bg pone un trabajo en segundo plano, y fg lo trae al primer plano. %1 se refiere al primer trabajo en segundo plano.*

11. **nohup**
nohup comando &
*Ejecuta un comando de forma que continúe ejecutándose incluso después de cerrar la sesión o terminal.*

12. **at**
at 14:30
ls -l
Ctrl+D
*Programa la ejecución de un comando (ls -l en este caso) en un momento específico en el futuro (14:30).*

13. **cron**
crontab -e
*Abre el editor para editar el cronjob. Por ejemplo, para ejecutar un script todos los días a las 3 AM:*

14. **systemctl**
sudo systemctl start nombre_del_servicio
sudo systemctl stop nombre_del_servicio
sudo systemctl restart nombre_del_servicio
sudo systemctl status nombre_del_servicio
*Controla servicios y unidades del sistema en sistemas basados en systemd. Ajusta nombre_del_servicio según sea necesario.*