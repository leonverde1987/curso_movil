/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSuites;

import java.io.FileWriter;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author TestingIT
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCases.Ejemplo_Test_Apk.class})
public class Test_Regresion_APK {

    @BeforeClass
    public static void setUpClass() throws Exception {
        //Leer archivo de configuración
        Properties Config = new Generic.genericGrid().getPropetiesFile("configuracion\\configuracion.properties");
        //Crear carpeta de evidencia
        String ruta = new Generic.evidenceGrid().creaCarpetaRepeticion();
        Config.setProperty("rutaEvidencia",ruta);
//        //Asignar navegador de ejecución
//        Config.setProperty("Navegador","chrome");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambia carpeta");
        
        //new Generic.genericGrid().leventarNodosGrid();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        //new Generic.genericGrid().cierraNodosGrid();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
