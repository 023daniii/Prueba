package LdInfrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import LdInfrastructure.LdTools.CMDColor;

public class AppException extends Exception {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
    public AppException(String showMsg) {
        super((showMsg == null || showMsg.isBlank()) ? LdAppConfig.MSG_DEFAULT_ERROR : showMsg);
        saveLogFile(null, null, null);
    }

    public AppException(String showMsg, Exception e, Class<?> clase, String metodo) {
        super((showMsg == null || showMsg.isBlank()) ? LdAppConfig.MSG_DEFAULT_ERROR : showMsg);
        saveLogFile(e != null ? e.getMessage() : null, clase, metodo);
    }

    private void saveLogFile(String logMsg, Class<?> clase, String metodo) {
        String timestamp  = LocalDateTime.now().format(FORMATTER);
        String className  = (clase  == null) ? LdAppConfig.MSG_DEFAULT_CLASS  : clase.getSimpleName();
        String methodName = (metodo == null) ? LdAppConfig.MSG_DEFAULT_METHOD : metodo;
        logMsg = (logMsg == null || logMsg.isBlank()) ? LdAppConfig.MSG_DEFAULT_ERROR : logMsg;
        
        String formattedLog = String.format("╭── SHOW ❱❱ %s \n╰──── LOG  ❱❱ %s | %s.%s | %s", 
                                            getMessage(), timestamp, className, methodName, logMsg);

        try (PrintWriter writer = new PrintWriter(new FileWriter(LdAppConfig.LOGFILE, true))) {
            System.err.println(CMDColor.BLUE + formattedLog);
            writer.println(formattedLog);
        } catch (Exception e) {
            System.err.println(CMDColor.RED + "[AppException.saveLogFile] ❱ " + e.getMessage());
        } finally {
            System.out.print(CMDColor.RESET);
        }
    }
}