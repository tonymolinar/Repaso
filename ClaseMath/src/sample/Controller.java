package sample;

import Calculos.Calculos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML TextField tarreglo1;
    @FXML TextField tarreglo2;
    @FXML ListView list1;
    @FXML ListView list2;

    double [] arreglo1 = new double[5];
    double [][] arreglo2 = new double[2][4];
    int contador = 0;
    int contador2 = 0;
    int contador3 = 0;

    public void insertar1(ActionEvent event){
        if (contador<5){
            double dato = Double.parseDouble(tarreglo1.getText());
            arreglo1[contador]=dato;
            contador++;
            tarreglo1.setText("");
            imprimirarreglo1(arreglo1);
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setContentText("Arreglo lleno"); alerta.show();
        }
    }
    public void insertar2(ActionEvent event){
        if (contador2<2){
            double dato = Double.parseDouble(tarreglo2.getText());
            arreglo2[contador2][contador3]=dato;
            contador3++;
            if (contador3==4){
                contador3=0;
                contador2++;
            }
            tarreglo2.setText("");
            imprimirarreglo2(arreglo2);
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setContentText("Arreglo lleno"); alerta.show();
        }
    }

    public void procesar1(ActionEvent event){
        Calculos calculos = new Calculos(arreglo1,arreglo2);
        double[] res = calculos.procesocos();
        for (double dato:res){
            list1.getItems().add(dato+"");
        }

    }
    public void procesar2(ActionEvent event){
        Calculos calculos = new Calculos(arreglo1,arreglo2);
        double[][] res = calculos.procesosen();
        for (int x=0;x<res.length;x++){
            String columna = "";
            for (int y=0;y<res[x].length;y++){
               columna = columna+res[x][y]+", ";
            }
            list2.getItems().add(columna);
        }

    }

    public void imprimirarreglo1(double[] arrg){
        for (int x=0;x<arrg.length;x++){
            System.out.print(arrg[x]+",");
        }
        System.out.println("");
    }
    public void imprimirarreglo2(double[][] arrg){
        for (int x=0;x<arrg.length;x++){
            for (int y=0;y<arrg[x].length;y++){
                System.out.print(arrg[x][y]+",");
            }
            System.out.println("");
        }
        System.out.println("_________________");
    }
}
