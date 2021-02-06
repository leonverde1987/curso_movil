package TestCases;


import org.junit.Test;
import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import Steps.GenericSteps;
import Steps.GenericStepsAPK;
import Steps.LoginSteps;
import Steps.MenusNavegadorSteps;



public class Ejemplo_Test_Apk{
    
    //STEPS
    public GenericStepsAPK genericSteps = new GenericStepsAPK();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();


    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UIGestionarJuegosDistribuciones = null;
    
    
    public Properties Config = null;
    //public Properties Datos = null;
    public Properties Elementos = null;
    private RemoteWebDriver driver = null;
    public List<String> Pasos = new ArrayList<String>();
    public int contador = 0;
    public String Resultado = "";
    public String ResultadoGlobal = "";
    public String Escenario = "";
    public String RutaEvidencia = "";
    public String Navegador="";
    public CSVReader DataDriven=null;
    public String[] filaDatos=null;
    

    
    
    @Before
    public void PrepararEjecucion() throws FileNotFoundException, MalformedURLException, InterruptedException{
    
        Config = genericSteps.getPropetiesFile("configuracion\\configuracion.properties");
        UILogin = genericSteps.getPropetiesFile("configuracion\\uielements\\loginPageAPK.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\dt_login_apk.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = "motorolaOneVision";
        driver = genericSteps.abrirAppAppium(Navegador, Config);
        ResultadoGlobal = "Exitoso";
    }
    
    @Test
    public void Test_Curso_Login_Apk() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String mensaje = filaDatos[2];
            try{

                    Escenario = "LGN_Login_Apk "+Repeticion;

                    //Paso 1
                    Pasos.add(contador+".- Abrir navegador en la Demo_Apk.apk");
                    this.loginSteps.capturaDriver(driver, RutaEvidencia, contador, Escenario, Navegador);
//                    genericSteps.ingresarAURL(driver, contador, Config, Escenario, Navegador);
//                    
                    //Paso 2
                    contador++;
                    Pasos.add(contador+".- Ingresamos Usuario: "+usuario+" y Contraseña:"+pass);
                    genericSteps.loginApk(driver, usuario, pass, contador, Config, UILogin, Escenario, Navegador);
//                    
                    //Paso 3
                    contador++;
                    Pasos.add(contador+".- Válidar mensaje: "+mensaje+".");
                    Resultado=genericSteps.validarMensajeData(driver, mensaje, Config, UILogin, contador, Escenario, Navegador);
                    
            }catch(NoSuchElementException s){
                Resultado = "Ejecución Fallida, No se encontró elemento: "+s;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }catch(InterruptedException e){
                Resultado = "Ejecución Fallida: "+e;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }finally{
                genericSteps.finalizarTestCase(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Config.getProperty("Modulo"), Config.getProperty("Version"), Navegador);
                contador=0;
                Pasos.clear();
            }
            Repeticion++;
        }

    }

    @After
    public void cerrarTest(){
        genericSteps.cerrarNavegador(driver);
    }   
}
