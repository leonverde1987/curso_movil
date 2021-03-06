package Steps;


import Generic.genericGrid;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericStepsAPK extends genericGrid{
    
    /**
     * Este método nos ayuda a regresar el nombre del navegador.
     * @param Cadena Nombre completo del navegador segun el driver.
     * @return Nombre corto del navegador.
     */
    public String navegador(String Cadena){
        String navegador="";
        Cadena = Cadena.substring(17, Cadena.length());
        //RemoteWebDriver: firefox on WINDOWS (32e13b4d-f272-43f3-9ad8-045535191a9a)
        for(int a = 0; Cadena.length() > a; a++){
            if(" ".equals(Cadena.substring(a, a+1))){
                a=Cadena.length()+1;
            }
            else{
                navegador = navegador + Cadena.substring(a, a+1);
            }
        }
        return navegador;
    }
    
    
    
    
    /**
     * Esté metodo nos ayuda a cerrar el driver.
     * @param driver  
     */
    public void cerrarNavegador(RemoteWebDriver driver) {
        this.cerrarDriver(driver);
    }
    
    /**
     * Captura una evidencia cuando el Test Falla.
     * @param driver Elemento WebDriver de la prueba.
     * @param Config Es el archivo config de la prueba.
     * @param error Es el número de error detectado.
     * @param Escenario Es el nombre del caso de prueba.
     * @param navegador Es el nombre del navegador donde se ejecuta la prueba.
     * @throws InterruptedException Cacha cualquier excepción.
     */
    public void capturarEvidencia(RemoteWebDriver driver, Properties Config, int error, String Escenario, String navegador) throws InterruptedException{
        
        switch(error) {
            case 1:
                this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), error, Escenario, navegador);
                break;
        }
    }
    
    /**
     * Esté método finaliza el Test Case y genera las evidencias.
     * @param driver Es el nombre del driver.
     * @param Escenario Es el nombre del Test Case.
     * @param Resultado Es el resultado del Testa Case Exitoso, Fallido o Ejecución Fallida.
     * @param contador Es el total de pasos ejecutados.
     * @param Pasos Es el detalle de los pasos ejecutados.
     * @param RutaEvidencia Es la ruta principal de la evidencia.
     * @param Modulo Es el módulo del aplicativo que se ejecuta.
     * @param Version Es la versión del aplicativo.
     * @throws Exception Cacha cualquier excepción en la ejecución.
     */
    public void finalizarTestCase(RemoteWebDriver driver, String Escenario, String Resultado, int contador, List<String> Pasos, String RutaEvidencia, String Modulo, String Version, String navegador) throws Exception{
        this.GenerarEvidencias(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Modulo, Version, navegador);
    }
    
    /**
     * 
     * @param Config
     * @throws InterruptedException
     * @throws FileNotFoundException 
     */
    public void ejecucionGrid(Properties Config) throws InterruptedException, FileNotFoundException{
        this.leventarNodosGrid();
    }
    
    /**
     * Cerramos los nodos del grid selenium.
     * @throws InterruptedException Cacha cualquier excepción de ejecución.
     */
    public void finEjecucionGrid() throws InterruptedException{
        this.cierraNodosGrid();
    }

    /**
     * Esté método realiza login en la APK.
     * @param driver Elemento WebDriver de la prueba.
     * @param usuario Es el valor del texto que se va ingresar al componente.
     * @param contador Es el controlador de pasos ejecutados.
     * @param contrasena Es la contraseña para hacer Login.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo. 
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @param navegador Es el navegador que usamos en la prueba.
     * @throws FileNotFoundException Cacha cualquier excepción en la ejecución.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void loginApk(RemoteWebDriver driver, String usuario, String contrasena, 
    		int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws FileNotFoundException, InterruptedException {
        try{
        this.dormirSeg(3);

        this.ingresarTextoAPK(driver, "xpath", Elementos.getProperty("ipt_usuario"), usuario);
        this.ingresarTextoAPK(driver, "xpath", Elementos.getProperty("ipt_contrasena"), contrasena);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        this.clickAPK(driver, "xpath", Elementos.getProperty("btn_conexion"));

//        driver.findElementByXPath("//*[@class = 'android.widget.EditText' and (@text = 'INGRESA USUARIO' or . = 'INGRESA USUARIO') and @resource-id = 'com.mate_app:id/txtUsuario']").sendKeys("JOSY");
//        driver.findElementByXPath("//*[@class = 'android.widget.Button' and (@text = 'INGRESAR' or . = 'INGRESAR') and @resource-id = 'com.mate_app:id/btnLogin']").sendKeys("Test1234");
//        driver.findElementByXPath("//*[@class = 'android.widget.Button' and (@text = 'INGRESAR' or . = 'INGRESAR') and @resource-id = 'com.mate_app:id/btnLogin']").click();

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    /**
     * Est´s método nos ayuda a validar el mensaje del resultado esperado. 
     * @param driver Elemento WebDriver de la prueba.
     * @param mensajeActual Es el mensaje que se va a comparar.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return Regresa el resultado Exitoso o Fallido y su detalle. 
     * @throws InterruptedException 
     */
    public String validarMensajeData(RemoteWebDriver driver, String mensajeActual, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        this.dormirSeg(4);
        String msj = "";
        try{
            msj = this.AssertMsjElemento(driver, "xpath", mensajeActual, Elementos.getProperty("lnk_mensaje"));
        }catch(ComparisonFailure e){
            msj = "Fallido, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
}
