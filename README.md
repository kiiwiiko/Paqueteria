[Taller Semana 6.md](https://github.com/user-attachments/files/23573042/Taller.Semana.6.md)
 # **Taller Semana 6**



**Repositorio:** Paquetería



**Integrantes:** Jeison Quimi, Dorian Román



### **Descripción General**



###### El código realizado para el taller trata de un sistema de envíos con recepción y entrega y 

###### diferentes ciudades a escoger. Tiene también un sistema de búsqueda por peso que nos devuelve

###### una listas de pesos iguales a los que estamos buscando, también una búsqueda por secuencia

###### que nos pide los parámetros de recepción y entrega para luego devolvernos a lista que coincida con 

###### la misma información ingresada. Por ultimo consta también un apartado que nos ayuda a ver que 

###### cantidad en peso total de los paquetes tenemos en cada ciudad, a esto se

###### refiere a la ciudad de recepción y nos devuelve la suma tota de pesos solo de la zona ingresada.



### **Características Principales**



###### Como ya se dijo reciente mente el código almacena una lista de las entregas de cada lugar

###### hasta una zona específica, que sirve para tener el registro de todo lo que llega y se entrega.

###### Esto resuelve el problema de perdidas de paquetes gracias a las opciones de búsqueda que nos ayudan 

###### a encontrar los paquetes gracias a su información. Algo que no se mencionó antes es que cada paquete 

###### según se valla ingresando se va ordenando de manera ascendente según su 

###### peso esto igual nos ayuda mucho al momento de buscara ya que la aplicación tiene que ir de

###### manera ascendente o buscar valores de forma rápida por el orden en el que esta en la lista.



### **Instalación**



###### Su instalación es sencilla, solo se exporta al IDE recomendamos usar el Intelijed ya que es

###### en el que se trabajo y probar el código; o simplemente descargar el comprimido y ejecurtalo en el 

###### mismo IDE.

### 

### **Tecnologías usadas**



###### Pues el código esta trabajado en el lenguaje de programación java y bueno recalcar que en 

###### este taller usaron los tipos de búsqueda binario, secuencial y lineal para las búsquedas de cada 

###### método y hasta el de la suma total.

###### El IntelijedIDEa como el entorno de desarrollo ya que es muy intuitivo y fácil de usar y el 

###### que se usa habitualmente y estamos aprendiendo en clases.



### **Estructura del proyecto**



#### **Clase Paqueteria**

#### **Atributos:**

###### Entero traking(Número tracking (único)

###### Double peso

###### String ciudadRecepciom

###### String ciudadEntrega

###### String cedula

###### String estado

####

#### **Metodos:**

###### Constructor (al traking se le da valores ramdom)//

###### Geter y Setter(de los atributos segunsea necesario)

###### toString(devueve los datos)

###### compareTo(Segun el orden)



#### **Clase Lista**

#### **Atributos** 

###### Lista de paquetes listaPaquete



#### **Métodos**

###### Constructor de la lista

###### adicionarElemento(al adicionar los ordena)

###### buscarPeso

###### busquedaSecuencialCiudades

###### pesoPaqCiudad



#### **Clase VentanaPaqueteria**

#### **Atributos**

###### JPanel ventana

###### JTabbedPane secuencialPanel

###### JPanel buscaPesoPanel

###### JPanel buscar1Panel

###### JPanel buscar2Panel

###### JTextField pesoField

###### JTextField cedulaField

###### JTextArea ingresoArea

###### JButton ingresarButton

###### JComboBox entregaCombo

###### JComboBox recepcionCombo

###### JComboBox recepcionSecCombo

###### JComboBox entregaSecCombo

###### JTextField buscarPesoField

###### JButton buscarButton

###### JTextArea buscarPesoArea

###### JTextArea secuencialArea

###### JLabel pesoLabel

###### JLabel recepcionLabel

###### JLabel entregaLabel

###### JLabel cedulaLabel

###### JLabel buscarPesoLabel

###### JLabel recepcionSecLabel

###### JLabel entregaSecLabel

###### JButton buscarSecButton

###### JScrollPane scroll1

###### JScrollPane scroll2

###### JScrollPane scroll3

###### JPanel ciudadPanel

###### JComboBox ciudadCombo

###### JButton sumarButton

###### JTextArea ciudadArea

###### JLabel ciudadLabel



###### También se incluye un tipo de dato Lista de la clase lista



###### Clase main



#### **Métodos**

###### Constructor de la Ventana creada con el plugin















