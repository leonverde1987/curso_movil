package Steps;


import Generic.genericGrid;
import Generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MenusNavegadorSteps extends genericGrid{

    /**
     * Est´s método abre el menu COMPRAS - PROVEEDORES 
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void clickMenuHamburguesa(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("menu_hamburguesa"));
    }
    
    /**
     * Este método abre el menu COMPRAS - PROVEEDORES 
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void abrirMenuComprasProveedores(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("proveedores"));
    }
    
    /**
     * Este método abre el menu Mi empresa - Configuracion y Mantenimiento
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void abrirMenuConfiguracionMantenimiento(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("configuracion_mantenimiento"));
    }
    
    
    
    /**
     * Este método da click en el icono de notificaciones
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void abrirNotificaciones(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("img_notificaciones"));
            dormirSeg(4);
    }
    
    /**
     * Este método abre el menu Mi empresa - Configuracion y Mantenimiento
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void abrirMenuFacturas(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("ap_factura"));
    }
    
    
    
}
