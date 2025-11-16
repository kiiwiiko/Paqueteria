import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaPaqueteria {
    private JPanel ventana;
    private JTabbedPane secuencialPanel;
    private JPanel buscaPesoPanel;
    private JPanel buscar1Panel;
    private JPanel buscar2Panel;
    private JTextField pesoField;
    private JTextField cedulaField;
    private JTextArea ingresoArea;
    private JButton ingresarButton;
    private JComboBox entregaCombo;
    private JComboBox recepcionCombo;
    private JComboBox recepcionSecCombo;
    private JComboBox entregaSecCombo;
    private JTextField buscarPesoField;
    private JButton buscarButton;
    private JTextArea buscarPesoArea;
    private JTextArea secuencialArea;
    private JLabel pesoLabel;
    private JLabel recepcionLabel;
    private JLabel entregaLabel;
    private JLabel cedulaLabel;
    private JLabel buscarPesoLabel;
    private JLabel recepcionSecLabel;
    private JLabel entregaSecLabel;
    private JButton buscarSecButton;
    private JScrollPane scroll1;
    private JScrollPane scroll2;
    private JScrollPane scroll3;
    private JPanel ciudadPanel;
    private JComboBox ciudadCombo;
    private JButton sumarButton;
    private JTextArea ciudadArea;
    private JLabel ciudadLabel;

    private Lista lista = new Lista();

    public VentanaPaqueteria() {


        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == ingresarButton) {

                    //Ser recuperean los elementos de cada parametro que indica el usuario
                    String peso = pesoField.getText();
                    String recepcion = recepcionCombo.getSelectedItem().toString();
                    String entrega = entregaCombo.getSelectedItem().toString();
                    String cedula = cedulaField.getText();

                    //En algunas partes mejor quite lo del Try Cath porq antes de parsear el dato o ingresarse me da las siguientes condicionales que le agregamos
                    if (ingresarTodo() == false) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese todos los parametros", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (verificarCedula(cedula) == false) {
                            JOptionPane.showMessageDialog(null, "Ingresar la cedula correcta", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (pesoField.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Por favor ingrese peso", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                if(recepcion.equals(entrega)){
                                    JOptionPane.showMessageDialog(null, "Ingrese otro lugar de entrega", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    //Se adiciona el elemento ingresado por el usuario
                                    lista.adicionarElemento(Double.parseDouble(peso), recepcion, entrega, cedula);
                                    //Solo se imprime los datos de los objetos de la lista
                                    ingresoArea.setText(lista.getListaPaquete().toString());

                                    //se ocupa la funcion borrar datos que tenemos mas abajo
                                    borrarDatos();
                                }
                            }
                        }
                    }

                }

            }
        });


        //Se podia desactivar el boton cuando los parametros estan vacios pero para que quede mas claro lo que se esta pidiendo
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buscarButton) {

                    if (buscarPesoField.getText().equals("")) {
                        //Solo lo del aumento le incluyo lo del error para que se vea bien la ventana de Error
                        JOptionPane.showMessageDialog(null, "Por favor ingrese el peso", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //Pareseo el paramtro recuperado a double tomandolo de una vez de la casilla
                        double peso = Double.parseDouble(buscarPesoField.getText());
                        //Uso la funcion y la almcaeno en un dato tipo Paquteria
                        List<Paqueteria> resultado = lista.buscarPeso(lista.getListaPaquete(), peso);

                        if (resultado == null) {
                            //si no cumple imprime lo siguiente
                            buscarPesoArea.setText("No se encontró ningún paquete con ese peso");
                        } else {
                            //Imprime en el text area los datos del resultado
                            buscarPesoArea.setText(resultado.toString());
                        }

                        //Limpia el unico paramtro que pide al usuario
                        buscarPesoField.setText("");
                    }
                }
            }
        });

        buscarSecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Tomamos los datos de los comboBox seleccionados
                String ciudadRecepcion = recepcionSecCombo.getSelectedItem().toString();
                String ciudadEntrega = entregaSecCombo.getSelectedItem().toString();

                if (recepcionSecCombo.getSelectedItem().toString().equals("") || entregaSecCombo.getSelectedItem().toString().equals("")) {
                    //Igual solo le icluyo los parametros del error
                    JOptionPane.showMessageDialog(null, "Por favor ingrese ambos parametros", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (ciudadRecepcion.equals(ciudadEntrega)) {
                        JOptionPane.showMessageDialog(null, "Porfavor selecionar un destino diferente al de entrega", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        List<Paqueteria> resultado = lista.busquedaSecuencialCiudades(lista.getListaPaquete(), ciudadRecepcion, ciudadEntrega);
                        if (resultado == null) {
                            //Si no se comple me devuelve el siguiente texto
                            secuencialArea.setText("No se encontraron paquetes con esas ciudades.");
                        } else {
                            //Imprime lo encontrado segun el metodo
                            secuencialArea.setText(resultado.toString());
                        }

                        //Reinicia los comboBox de la venta Secuencia
                        recepcionSecCombo.setSelectedIndex(0);
                        entregaSecCombo.setSelectedIndex(0);
                    }
                }
            }
        });

        //Boton para sumar los pesos de los paquetes por ciudad
        sumarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == sumarButton) {
                    String ciudad = ciudadCombo.getSelectedItem().toString();
                    if(ciudadCombo.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Por favor seleccionar un ciudad", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {
                        //Se toma los datos y se hace el respectivo parseo
                        double resultado = lista.pesoPaqCiudad(lista.getListaPaquete(), ciudad);
                        ciudadArea.setText("El peso total de paquetes que hay en la ciudad" + ciudad + " es de " + String.valueOf(resultado));
                    }
                }
            }
        });
    }

    //Solo agrego una funcion que verifique el tamaño de la cedula ingresada
    //Como sabemos la cedula costa de 10 digitos
    public boolean verificarCedula(String cedula) {
        if(cedula.length() > 10 || cedula.length() < 10) return  false;
        else return true;
    }

    public boolean ingresarTodo(){
        //Parametros a cumplir para el falso
        if(
                cedulaField.getText().equals("") ||
                        recepcionCombo.getSelectedItem().toString().equals("") ||
                entregaCombo.getSelectedItem().toString().equals("")
        ){
            return false;
        } else return true;

    }

    //Borrar datos aunq solo ocupo el metodo una vez aqui esta
    public void borrarDatos(){
        pesoField.setText("");
        cedulaField.setText("");
        recepcionCombo.setSelectedIndex(0);
        entregaCombo.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPaqueteria");
        //Me gusta usar este metodo para darle mi propio tamaño a la ventana borrando el pack()
        frame.setBounds(0, 0, 650, 500);
        //Ventana en el centro
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new VentanaPaqueteria().ventana);
        //Para cambiar el titulo a la ventana que desee
        frame.setTitle("Ventana Paqueteria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Este metodo igual me gusta para no modificar ventana por el usuario
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
