import java.util.*;

import static java.util.Arrays.binarySearch;

public class Lista {
    private List<Paqueteria> listaPaquete;

    public Lista() {
        listaPaquete = new ArrayList<Paqueteria>();
    }

    public List<Paqueteria> getListaPaquete() {
        return listaPaquete;
    }

    public void adicionarElemento(double peso, String ciduadRecepcion, String ciudadEntrega, String cedula) {
        listaPaquete.add(new Paqueteria(peso, ciduadRecepcion, ciudadEntrega,  cedula));
        //Utilizo el metodo Colleticons.sort que es la indicada en la calse anterior
        //Esto ordena los datos de la lista segun el compareTo de la clase Paqueteria
        Collections.sort(listaPaquete);
    }

    //Busqueda binaria
    //Use directamente la funcion que nos da el aula virtual, porq el metodo que ya esta en java usa arrglo como parametro
    public List<Paqueteria> buscarPeso(List<Paqueteria> lista, double pesoBuscado) {

        List<Paqueteria> resultado = new ArrayList<>();
        //uso size para tomar el tamaño de la lista
        //esto seria un intervalo
        int left = 0; //desde 0
        int right = lista.size() - 1; // hasta el ultimo valor menos uno ya que me daba error si no le restaba, ha de ser porq empieza desde cero

        //utilizo un while para que valla dato por dato segun el algoritmo que contiene
        while (left <= right) {

            //se reduce el intervalo a la mitad
            int mid = (left + right) / 2;
            //se retorna el valor(los datos) segun la posicion
            Paqueteria p = lista.get(mid);

            //se cumple y solo retorna la lista
            //buscamos por cada lado por si se repite algun dato
            int i = mid - 1;
            if (p.getPeso() == pesoBuscado) {
                resultado.add(p);
                i--;
            }

            //del otro lado se busca si hay mas
            int j = mid + 1;
            if (p.getPeso() == pesoBuscado) {
                resultado.add(p);
                j++;
            }


            //sino se cumple segun la condicion se actualiza el intervalo
            //se hace mas pequeño el intervalo
            if (p.getPeso() < pesoBuscado) {
                left = mid + 1;//desde la izquierda
            } else {
                right = mid - 1;//desde la derecha
            }
        }

        return resultado;

    }


    //Hacer sin tranformar la lista en arreglo
    //Busqueda Binaria metodo funcional tranformando la lista en array
    /*public Paqueteria buscarPeso(double pesoBuscado) {

        if (listaPaquete.isEmpty()) {
            return null;
        }

        double[] peso = new double[listaPaquete.size()];

        for (int i = 0; i < listaPaquete.size(); i++) {
            peso[i] = listaPaquete.get(i).getPeso();
        }

        int index = binarySearch(peso, pesoBuscado);

        if (index >= 0) {
            return listaPaquete.get(index);
        } else  {
            return null;
        }


    }*/

    //Busqueda lineal o secuancial
    //Usamos solo la lista como parametro lo indico la profe
    public List<Paqueteria> busquedaSecuencialCiudades(List<Paqueteria> lista, String ciudadRecepcion, String ciudadEntrega) {
        List<Paqueteria> resultado = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            //Segun la iteracion tomamos el objeto en un dato tipo Paqueteria
            Paqueteria p = lista.get(i);

            //condicion if que compara el parametro recepcion ingresado y el que ya estaba en la lista
            if (p.getCiduadRecepcion().equalsIgnoreCase(ciudadRecepcion) && p.getCiudadEntrega().equalsIgnoreCase(ciudadEntrega)) {
                //retornamos el objeto encontrado de la lista
                resultado.add(p);
            }
        }

        //Datos no encontrados
        return resultado;
    }

    //Busqueda en secuencia solo con el for
    //Igual analiza dato por dato segun la condicion if se cumpla
    /*public List<Paqueteria> busquedaSecuencialCiudades(String ciudadRecepcion, String ciudadEntrega) {
    //Almaceno la informacion encontrada en una new lista
        List<Paqueteria> encontrados = new ArrayList<>();

        for (Paqueteria p : listaPaquete) {
            //condicion if que compara el parametro recepcion ingresado y el que ya estaba en la lista
            if (p.getCiduadRecepcion().equalsIgnoreCase(ciudadRecepcion) && p.getCiudadEntrega().equalsIgnoreCase(ciudadEntrega)) {
                encontrados.add(p);
            }
        }
        //devuelve el dato almacenado en la lista que creamos para este metodo
        return encontrados;
    }*/

    public double pesoPaqCiudad(List<Paqueteria> lista, String ciudad) {
        double peso = 0;
        //Se recorre paquete de la lista y si cumple la cidad se suma
        for(Paqueteria p: lista){
            //Si la ciudad de igual a la seleccionada
            if(p.getCiduadRecepcion().equalsIgnoreCase(ciudad)){
                //se van sumando hasta terminar
                peso += p.getPeso();
            }
        }
        return peso;

    }

}
