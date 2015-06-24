package reciclaje;

import java.math.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Lorena
 * @author David
 */
public class Reciclaje {
    
    public static ArrayList<Double> valoresT = new ArrayList<Double>();
    
    public static Estrategia[] estrategias1 = new Estrategia[4];
    public static Estrategia[] estrategias2 = new Estrategia[4];
    public static Estrategia[] estrategias3 = new Estrategia[4];
    public static Estrategia[] estrategias4 = new Estrategia[4];
    public static Estrategia[] estrategias5 = new Estrategia[4];
    
    public static Estrategia mejorEstrategia = new Estrategia();
    public static Estrategia estrategia1 = new Estrategia();
    public static Estrategia estrategia2 = new Estrategia();
    public static Estrategia estrategia3 = new Estrategia();
    public static Estrategia estrategia4 = new Estrategia();
    
    public static Estrategia estrategiaAl2 = new Estrategia();
    public static Estrategia estrategiaAl3 = new Estrategia();
    public static Estrategia estrategiaAl4 = new Estrategia();
    public static Estrategia estrategiaAl5 = new Estrategia();
    
        
    public static Organizacion organizacion1;
    public static Organizacion organizacion2;
    public static Organizacion organizacion3;
    public static Organizacion organizacion4;
    public static Organizacion organizacion5;
    
    public static int pagoEst1;
    public static int pagoEst2;
    public static int pagoEst3;
    public static int pagoEst4;
    
    public static Analizador ui;
    
    public static int generaciones=0;
    public static double tasaRiesgoLibre =5;
    public static double volatilidadMercado =10;
    public static double valorFactura=0;
    
    public static final String ZONAN="NORTE";
    public static final String ZONAS="SUR";
    public static final String ZONAO="ORIENTE";
    public static final String ZONAOCC="OCCIDENTE";
    
    public static final double VZONAN=9000;
    public static final double VZONAS=6000;
    public static final double VZONAO=4300;
    public static final double VZONAOCC=13800;
    
    public static final double GASTOBASE = 64000000;
    
    public static Random rnd = new Random();
    public static int eComp = 0;
    
    public static void main(String[] args) {

            ui = new Analizador();
            
            ui.iniciarDatos();
            ui.continuarDatosNuevos();
            ui.pause();
            
            
            
            
            if(ui.tamanio=="GRANDE"){
                ui.pcn=Normal(12,2);
                ui.perdidacemento=ui.cemento*ui.pcn/100;
                ui.pan=Normal(11,3);
                ui.perdidaagregados=ui.agregados*ui.pan/100;
                ui.plmn=Normal(11,2);
                ui.perdidaladrilloM=ui.ladrilloM*ui.plmn/100;
                ui.plpn=Normal(9,3);
                ui.perdidaladrilloP=ui.ladrilloP*ui.plpn/100;
                ui.pacn=Normal(8,2);
                ui.perdidaaceroC=ui.aceroC*ui.pacn/100;
                ui.pfn=Normal(3,1);
                ui.perdidaformaleta=ui.formaleta*ui.pfn/100;
            }else{
                if(ui.tamanio=="MEDIANA"){
                    ui.pcn=Normal(9,2);
                    ui.perdidacemento=ui.cemento*ui.pcn/100;
                    ui.pan=Normal(8,3);
                    ui.perdidaagregados=ui.agregados*ui.pan/100;
                    ui.plmn=Normal(7,2);
                    ui.perdidaladrilloM=ui.ladrilloM*ui.plmn/100;
                    ui.plpn=Normal(7,3);
                    ui.perdidaladrilloP=ui.ladrilloP*ui.plpn/100;
                    ui.pacn=Normal(6,2);
                    ui.perdidaaceroC=ui.aceroC*ui.pacn/100;
                    ui.pfn=Normal(2,1);
                    ui.perdidaformaleta=ui.formaleta*ui.pfn/100;
                }else{
                    if(ui.tamanio=="PEQUEÑA"){
                        ui.pcn=Normal(12,2);
                        ui.perdidacemento=ui.cemento*ui.pcn/100;
                        ui.pan=Normal(11,2);
                        ui.perdidaagregados=ui.agregados*ui.pan/100;
                        ui.plmn=Normal(11,3);
                        ui.perdidaladrilloM=ui.ladrilloM*ui.plmn/100;
                        ui.plpn=Normal(9,2);
                        ui.perdidaladrilloP=ui.ladrilloP*ui.plpn/100;
                        ui.pacn=Normal(8,2);
                        ui.perdidaaceroC=ui.aceroC*ui.pacn/100;
                        ui.pfn=Normal(3,1);
                        ui.perdidaformaleta=ui.formaleta*ui.pfn/100;
                    }
                }
            }
            ui.cerrarCarga();
            
            
            float [][] matriz = new float[15][6];
            for(int i=0;i<15;i++){
                for(int j=0;j<6;j++){
                    matriz[i][j]=0;
                }
            }
            float[] valores=new float[6];
            while(generaciones<ui.dias){
                if(ui.tamanio=="GRANDE"){
                
                for(int i=0;i<15;i++){
                    for(int j=0;j<6;j++){
                        float valor=0;
                        switch(j){
                                case 0:
                                    valor=Normal(8,2);
                                    break;
                                case 1:
                                    valor=Normal(7,3);
                                    break;
                                case 2:
                                    valor=Normal(7,2);
                                    break;
                                case 3:
                                    valor=Normal(6,2);
                                    break;
                                case 4:
                                    valor=Normal(4,2);
                                    break;
                                case 5:
                                    valor=Normal(1,0.8);
                                    break;
                        }
                        matriz[i][j]=valor/ui.dias;
                    }
                }
            }else{
                if(ui.tamanio=="MEDIANA"){             
                        for(int i=0;i<10;i++){
                        for(int j=0;j<6;j++){
                            float valor=0;
                            switch(j){
                                    case 0:
                                        valor=Normal(6,2);
                                        break;
                                    case 1:
                                        valor=Normal(5,2.5);
                                        break;
                                    case 2:
                                        valor=Normal(4,2);
                                        break;
                                    case 3:
                                        valor=Normal(4,2);
                                        break;
                                    case 4:
                                        valor=Normal(3,1);
                                        break;
                                    case 5:
                                        valor=Normal(1,0.5);
                                        break;
                            }
                            matriz[i][j]=valor/ui.dias;
                        }
                    }
                }else{
                    if(ui.tamanio=="PEQUEÑA"){                    
                            for(int i=0;i<5;i++){
                                for(int j=0;j<6;j++){
                                float valor=0;
                                switch(j){
                                        case 0:
                                            valor=Normal(8,2);
                                            break;
                                        case 1:
                                            valor=Normal(7,2);
                                            break;
                                        case 2:
                                            valor=Normal(6,3);
                                            break;
                                        case 3:
                                            valor=Normal(6,2);
                                            break;
                                        case 4:
                                            valor=Normal(4,2);
                                            break;
                                        case 5:
                                            valor=Normal(1,0.8);
                                            break;
                                }
                                matriz[i][j]=valor/ui.dias;
                            }
                        }
                    }
                }
            }
                
                for(int i=0;i<6;i++){
                    valores[i]=0;
                }
                if(ui.tamanio=="GRANDE"){
                    for(int i=0;i<15;i++){
                        for(int j=0;j<6;j++){
                            valores[j]=valores[j]+matriz[i][j]*ui.dias;
                        }
                    }
                    for(int i=0;i<6;i++){
                                    valores[i]=valores[i]/15;
                            }
                }else{
                    if(ui.tamanio=="MEDIANA"){
                            for(int i=0;i<10;i++){
                                for(int j=0;j<6;j++){
                                valores[j]=valores[j]+matriz[i][j]*ui.dias;
                                }
                            }
                            for(int i=0;i<6;i++){
                                    valores[i]=valores[i]/10;
                            }
                    }else{
                        if(ui.tamanio=="PEQUEÑA"){
                                for(int i=0;i<5;i++){
                                    for(int j=0;j<6;j++){
                                        valores[j]=valores[j]+matriz[i][j]*ui.dias;
                                    }
                                }
                                for(int i=0;i<6;i++){
                                    valores[i]=valores[i]/5;
                            }
                                
                        }
                    }
                }
                
                ui.colocarDatosDias(valores);
                
                ui.colocarValor(matriz);
                ui.continuar();
                generaciones++;
                ui.colocarGeneraciones(getGen());
                ui.pause1();
                valoresT.add((double)(valores[0]+valores[1]+valores[3]+valores[3]+valores[4]+valores[5])/6);
            }
            ui.mostrarResultados(valores);
    }
    
    public static String getGen(){
        return Integer.toString(generaciones);
    }
    
    public static int Normal(double Media, double DStd) {
        double Suma = 0;
        for (int i = 1; i <= 12; i++) {
            double r = Math.random();
            Suma = Suma + r;
        }
        double x = DStd * (Suma - 6) + Media;
        return Math.abs((int)x);
    }
    
    
    
    
   
   
   
}