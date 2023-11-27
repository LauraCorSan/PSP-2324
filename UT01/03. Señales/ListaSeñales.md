# LISTADO SEÑALES
Lista numero con explicacion

1. **SIGABRT (Abort): 6**
Desencadenada por la función abort(). Usualmente, es enviada por el programa mismo cuando detecta un error irreparable.

2. **SIGALRM (Alarm clock): 14**
Generada cuando expira un temporizador creado con alarm().

3. **SIGBUS (Bus error): 10**
Indica un error de alineación o problemas de acceso a la memoria.

4. **SIGCHLD (Child exited): 17**
Enviada a un proceso padre cuando uno de sus procesos hijos termina.

5. **SIGCONT (Continue): 18**
Indica que un proceso detenido debe continuar su ejecución.

6. **SIGFPE (Floating-point exception): 8**
Indica una excepción aritmética, como la división por cero.

7. **SIGHUP (Hangup): 1**
Enviada a un proceso cuando la terminal que lo inició es cerrada.

8. **SIGILL (Illegal instruction): 4**
Indica que el proceso ha intentado ejecutar una instrucción no válida.

9. **SIGINT (Interrupt): 2**
Enviada cuando se interrumpe la ejecución de un programa, generalmente desde el teclado con Ctrl+C.

10. **SIGKILL (Kill): 9**
Indica que el proceso debe ser terminado de inmediato. No se puede capturar ni ignorar.

11. **SIGPIPE (Broken pipe): 13**
Enviada a un proceso cuando intenta escribir en un extremo de una tubería cuyo extremo opuesto se ha cerrado.

12. **SIGQUIT (Quit): 3**
Similar a SIGINT, pero también genera un archivo de núcleo del programa.

13. **SIGSEGV (Segmentation fault): 11**
Indica que el programa intentó acceder a una región de memoria que no tenía permiso de acceso.

14. **SIGSTOP (Stop, unblockable): 19**
Detiene la ejecución de un proceso. No se puede capturar ni ignorar.

15. **SIGTERM (Termination): 15**
Indica que el proceso debe terminar su ejecución normalmente.

16. **SIGTSTP (Keyboard stop): 20**
Enviada por el teclado con Ctrl+Z para detener un proceso temporalmente.

17. **SIGTTIN (Background read from tty): 21**
Enviada a un proceso en segundo plano que intenta leer de la terminal.

18. **SIGTTOU (Background write to tty): 22**
Enviada a un proceso en segundo plano que intenta escribir en la terminal.

19. **SIGUSR1 (User-defined signal 1): 10**
Se puede utilizar por el programador para propósitos personalizados.

20. **SIGUSR2 (User-defined signal 2): 12**
Se puede utilizar por el programador para propósitos personalizados.

21. **SIGPOLL (Pollable event): 22**
Indica eventos disponibles para E/S con poll().

22. **SIGPROF (Profiling timer expired): 27**
Enviada cuando expira un temporizador utilizado para perfiles.

23. **SIGSYS (Bad system call): 12**
Indica una llamada al sistema no válida.

24. **SIGTRAP (Trace/breakpoint trap): 5**
Indica un punto de interrupción o una instrucción de traza fue alcanzada.

25. **SIGURG (High bandwidth data is available at a socket): 23**
Indica datos urgentes disponibles en un socket.

26. **SIGVTALRM (Virtual timer expired): 26**
Enviada cuando expira un temporizador virtual.

27. **SIGXCPU (CPU time limit exceeded): 24**
Indica que un proceso ha excedido su límite de tiempo de CPU.

28. **SIGXFSZ (File size limit exceeded): 25**
Indica que un proceso ha excedido su límite de tamaño de archivo.
