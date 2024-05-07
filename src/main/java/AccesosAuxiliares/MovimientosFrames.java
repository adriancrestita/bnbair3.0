/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesosAuxiliares;

import EliminadosPeroGuardados.FrameCrearInmueble1;
import EliminadosPeroGuardados.FrameCrearInmueble2;
import EliminadosPeroGuardados.FrameCrearInmueble3;
import AccesosPrincipales.*;

public class MovimientosFrames {

    public MovimientosFrames(){
        
    }
    
    
    public static void moveCrearInmueble1(){
        FrameCrearInmueble1 ci1 = new FrameCrearInmueble1();
        ci1.setVisible(true);       
    }
    
    public static void moveCrearInmueble2(){
        FrameCrearInmueble2 ci2 = new FrameCrearInmueble2();
        ci2.setVisible(true);  
    }
    
    public static void moveCrearInmueble3(){
        FrameCrearInmueble3 ci3 = new FrameCrearInmueble3();
        ci3.setVisible(true);                            
    }
    
    public static void moveDatosBancarios(){
        FrameDatosBancarios db = new FrameDatosBancarios();
        db.setVisible(true);  
    }
    
    public static void moveDatosPersonales(){
        FrameDatosPersonales dp = new FrameDatosPersonales();
        dp.setVisible(true);                            
    }
    public static void moveAdmin(){
        FrameAdmin admin = new FrameAdmin();
        admin.setVisible(true);       
    }
    
    public static void moveConsultaInmuebles(){
        FrameConsultaInmuebles ci = new FrameConsultaInmuebles();
        ci.setVisible(true);  
    }
    
    public static void moveConsultaReservas(){
        FrameConsultaReservas cr = new FrameConsultaReservas();
        cr.setVisible(true);                            
    }
    
    public static void moveConsultaUsers(){
        FrameConsultaUsers cu = new FrameConsultaUsers();
        cu.setVisible(true);  
    }
    
    public static void moveInicio(){
        FrameInicio ini = new FrameInicio();
        ini.setVisible(true);                            
    }
    
    public static void moveLogin(){
        FrameLogin log = new FrameLogin();
        log.setVisible(true);  
    }
    
    public static void moveMenuAnfitrion(){
        FrameMenuAnfitrion ma = new FrameMenuAnfitrion();
        ma.setVisible(true);                            
    }
    
    public static void moveMenuParticular(){
        FrameMenuParticular mp = new FrameMenuParticular();
        mp.setVisible(true);  
    }
    
    public static void moveRegistro(){
        FrameRegistro reg = new FrameRegistro();
        reg.setVisible(true);                            
    }
    
}
