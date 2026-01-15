package LdInfrastructure;

import java.net.URL;

public abstract class LdAppConfig {
    // Paths Storage
    // Se mantiene la base de datos pero se ajusta el nombre del CSV de salida
    public static final String DATABASE = "jdbc:sqlite:storage\\DataBase\\antCiberDron.sqlite";
    public static final String DATAFILE = "Storage\\DataFile\\Lanchimba_Danny.csv"; // CAMBIADO
    public static final String LOGFILE  = "Storage\\Logs\\AppErrors.log";

    // Resources (Rutas de Assets refactorizadas con tu prefijo Ld)
    public static final URL URL_MAIN    = LdAppConfig.class.getResource("/LdInfrastructure/LdAssets/LdImg/logo.png");
    public static final URL URL_LOGO    = LdAppConfig.class.getResource("/LdInfrastructure/LdAssets/LdImg/logo.png");
    public static final URL URL_SPLASH  = LdAppConfig.class.getResource("/LdInfrastructure/LdAssets/LdImg/Splash.png");

    // AppMSGs
    public static final String MSG_DEFAULT_ERROR    = "Ups! Error inesperado. Por favor, contacte al administrador del sistema.";
    public static final String MSG_DEFAULT_CLASS    = "undefined";
    public static final String MSG_DEFAULT_METHOD   = "undefined";

    private LdAppConfig() {}
}