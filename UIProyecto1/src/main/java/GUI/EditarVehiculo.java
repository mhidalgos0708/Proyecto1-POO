package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 

public final class EditarVehiculo extends JFrame implements ActionListener {
    String filename;
    String[] TiposLicencias = {"", "A1","A2","A3","A4","B1","B2","B3","B4","C1","C2","D1","D2","D3","E1","E2"};
    String[] TiposCarros = {"", "Compacto", "Pickup", "Intermedio", "SUV", "Mini-van", "Convertible", "Económico"};
    String[] VehículosCompacto={"", "Compacto1", "Compacto2"};
    String[] VehículosPickup={"", "Pickup1", "Pickup2"};
    String[] VehículosIntermedio={"", "Intermedio1", "Intermedio2"};
    String[] VehículosSUV={"", "SUV1", "SUV2"};
    String[] VehículosMinivan={"", "Mini-van1", "Mini-van2"};
    String[] VehículosConvertible={"", "Convertible1", "Convertible2"};
    String[] VehículosEconómico={"", "Económico1", "Económico2"};
    String[] Estados={"", "Activo", "Inactivo", "En Mantenimiento"};
    String[] TiposTransmision = {"", "Automática", "Manual"};
    String[] TiposSedes = {"", "Cartago", "Zapote"};
    
    
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    JComboBox<String> ComboBoxTipoCarroSeleccionado = new JComboBox<>(TiposCarros);
    JComboBox<String> ComboBoxVehículoSeleccionado = new JComboBox<>();
    JComboBox<String> TextFieldEstado = new JComboBox<String>(Estados);
    JComboBox<String> TextFieldTransmision = new JComboBox<String>(TiposTransmision);
    JComboBox<String> TextFieldSede = new JComboBox<String>(TiposSedes);
    
    JTextField TextFieldAñoFabricacion = new JTextField("");
    JTextField TextFieldColorSeleccionado = new JTextField("");
    JTextField TextFieldMarcaSeleccionada = new JTextField("");
    JTextField TextFieldKilometraje = new JTextField("");
    JTextField TextFieldCapacidadPersonas= new JTextField("");
    JTextField TextFieldNumeroPuertas= new JTextField("");
    JTextField TextFieldMPG = new JTextField("");
    JTextField TextFieldCostoDiario = new JTextField("");
    JTextField TextFieldCapacidadMaletas = new JTextField("");
    
    
    JLabel TextoImagenSeleccionado = new JLabel("");
    JTextField TextFieldVin = new JTextField("");
    
    JLabel TextoNombreCompleto = new JLabel("Tipo Vehículo");
    JLabel TextoCédula = new JLabel("Vehículo Seleccionado");
    JLabel TextoServiciosRelacionados = new JLabel("Servicios Relacionados");
    JLabel TextoCorreo = new JLabel("Año de Fabricación");
    JLabel TextoTeléfono = new JLabel("Color");
    JLabel TextoNumeroLicencia = new JLabel("Marca");
    JLabel TextoFechaEmisionLicencia = new JLabel("Capacidad Personas");
    JLabel TextoTipoLicencia = new JLabel("Kilometraje");
    JLabel TextoFechaExpiracionLicencia = new JLabel("Numero de Puertas");
    JLabel TextoImágen = new JLabel("Numero Vin");
    JLabel TextoURL =new JLabel("MPG");
    JLabel TextoSede =new JLabel("Sede");
    JLabel TextoCostoDiario =new JLabel("Costo Diario");
    JLabel TextoCapacidaddeMaletas =new JLabel("Capacidad de Maletas");
    JLabel TextoTipodeTransmisión =new JLabel("Tipo de Transmisión");
    JLabel TextoEstado =new JLabel("Estado");
    JLabel TextoImagen =new JLabel("Imagen");
    JLabel TextoTL=new JLabel("");
    JLabel TextoTipoVehículoSeleccionado = new JLabel("");
    JLabel TextoVehiculoSeleccionado= new JLabel("");
    
    JButton botonAtras = new JButton("Atrás");
    JButton botonConfirmar = new JButton("Confirmar");
    JButton botonModificarServicios = new JButton("Modificar");
    
    JButton TextFieldImágen = new JButton("Seleccionar Imagen");
    
 
 
    EditarVehiculo() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        
        TextoNombreCompleto.setBounds(40, 100, 150, 30);
        TextoCédula.setBounds(40, 140, 150, 30);
        TextoServiciosRelacionados.setBounds(40, 180, 150, 30);
        TextoCorreo.setBounds(40, 220, 150, 30);
        TextoTeléfono.setBounds(40, 260, 150, 30);
        TextoNumeroLicencia.setBounds(40, 300, 150, 30);
        TextoFechaEmisionLicencia.setBounds(40, 340, 150, 30);
        TextoTipoLicencia.setBounds(40, 380, 150, 30);
        TextoFechaExpiracionLicencia.setBounds(40, 420, 150, 30);
        TextoImágen.setBounds(40, 460, 150, 30);
        TextoURL.setBounds(40, 500, 300, 30);
        TextoTL.setBounds(120, 380, 150, 30);
        TextoVehiculoSeleccionado.setBounds(1,1,1,1);
        TextoTipoVehículoSeleccionado.setBounds(1,1,1,1);
        ComboBoxTipoCarroSeleccionado.setBounds(200, 100, 200, 30);
        ComboBoxVehículoSeleccionado.setBounds(200, 140, 200, 30);
        botonModificarServicios.setBounds(200, 180, 200, 30); 
        TextFieldAñoFabricacion.setBounds(200, 220, 200, 30); 
        TextFieldColorSeleccionado.setBounds(200, 260, 200, 30); 
        TextFieldMarcaSeleccionada.setBounds(200, 300, 200, 30); 
        TextFieldCapacidadPersonas.setBounds(200, 340, 200, 30); 
        TextFieldKilometraje.setBounds(200, 380, 200, 30); 
        TextFieldNumeroPuertas.setBounds(200, 420, 200, 30); 
        TextFieldVin.setBounds(200, 460, 200, 30);
        
        int k = 15;
        int h = -80;
        TextoSede.setBounds(410+k, 180+h, 150, 30);
        TextoCostoDiario.setBounds(410+k, 220+h, 150, 30);
        TextoCapacidaddeMaletas.setBounds(410+k, 260+h, 150, 30);
        TextoTipodeTransmisión.setBounds(410+k, 300+h, 150, 30);
        TextoEstado.setBounds(410+k, 340+h, 150, 30);
        TextoImagen.setBounds(410+k, 380+h, 150, 30);
        
        
        TextFieldMPG.setBounds(200, 500, 200, 30);
        TextFieldSede.setBounds(570+k, 180+h, 200, 30);
        TextFieldCostoDiario.setBounds(570+k, 220+h, 200, 30);
        TextFieldCapacidadMaletas.setBounds(570+k, 260+h, 200, 30);
        TextFieldTransmision.setBounds(570+k, 300+h, 200, 30);
        TextFieldEstado.setBounds(570+k, 340+h, 200, 30);
        TextFieldImágen.setBounds(570+k, 380+h, 200, 30);
        TextoImagenSeleccionado.setBounds(570+k, 430+h, 200, 150);
        
        botonConfirmar.setBounds(585, 520, 200, 30);
        botonAtras.setBounds(585,30, 200, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        
        container.add(TextFieldImágen);
        container.add(TextFieldMPG);
        container.add(TextFieldSede);
        container.add(TextFieldCostoDiario);
        container.add(TextFieldCapacidadMaletas);
        container.add(TextFieldTransmision);
        container.add(TextFieldEstado);
        container.add(TextoImagenSeleccionado);
        container.add(botonConfirmar);
        container.add(TextoSede);
        container.add(TextoCostoDiario);
        container.add(TextoCapacidaddeMaletas);
        container.add(TextoTipodeTransmisión);
        container.add(TextoEstado);
        container.add(TextoImagen);
        container.add(TextoNombreCompleto);
        container.add(TextoCédula);
        container.add(TextoServiciosRelacionados);
        container.add(TextoCorreo);
        container.add(TextoTeléfono);
        container.add(TextoNumeroLicencia);
        container.add(TextoFechaEmisionLicencia);
        container.add(TextoTipoLicencia);
        container.add(TextoFechaExpiracionLicencia);
        container.add(TextoImágen);
        container.add(TextoTipoVehículoSeleccionado);
        container.add(ComboBoxTipoCarroSeleccionado);
        container.add(ComboBoxVehículoSeleccionado);
        container.add(botonModificarServicios);
        container.add(TextFieldAñoFabricacion);
        container.add(TextFieldColorSeleccionado);
        container.add(TextFieldMarcaSeleccionada);
        container.add(TextFieldCapacidadPersonas);
        container.add(TextFieldKilometraje);
        container.add(TextFieldNumeroPuertas);
        container.add(TextFieldVin);
        container.add(TextoURL);
        container.add(TextoTL);
        container.add(TextoVehiculoSeleccionado);
        container.add(botonAtras);
        ComboBoxVehículoSeleccionado.setEnabled(false);
    }
 
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonConfirmar.addActionListener(this);
        TextFieldImágen.addActionListener(this);
        ComboBoxTipoCarroSeleccionado.addActionListener( this);
        ComboBoxVehículoSeleccionado.addActionListener(this);
        botonModificarServicios.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonModificarServicios){
            Inicio.frameEditarVehiculo.setEnabled(false);
            TablaAgregarServiciosAsociados.frameTablaEditarServiciosVehiculo.setVisible(true);
            
            
          
        }
        if (e.getSource()==botonAtras){
            
            ComboBoxTipoCarroSeleccionado.setSelectedIndex(0);
            Inicio.VentanaMenuAdministrador(true);
            Inicio.VentanaEditarVehiculo(false);
          
        }
        if (e.getSource()==botonConfirmar){
            String NombreTemporal;
            String cédulaTemporal;
            String direccionTemporal;
            String correoTemporal;
            String telefonoTemporal;
            String numerolicenciaTemporal;
            String fechaemisionlicenciaTemporal;
            String tipolicenciaTemporal;
            String fechaexpiracionlicenciaTemporal;
            String imagenTemporal;
            String EstadoVehículoTemporal=(String)TextFieldEstado.getSelectedItem();
            NombreTemporal = TextoTipoVehículoSeleccionado.getText();
            cédulaTemporal = TextoVehiculoSeleccionado.getText();
            direccionTemporal= botonModificarServicios.getText();
            correoTemporal= TextFieldAñoFabricacion.getText();
            telefonoTemporal= TextFieldColorSeleccionado.getText();
            numerolicenciaTemporal= TextFieldMarcaSeleccionada.getText();
            

            fechaemisionlicenciaTemporal=TextFieldCapacidadPersonas.getText();
            
            
            tipolicenciaTemporal= TextoTL.getText();

            fechaexpiracionlicenciaTemporal=TextFieldNumeroPuertas.getText();
            
            
            imagenTemporal= TextoURL.getText();
            
            if (ComboBoxVehículoSeleccionado.getSelectedIndex()==0 || ComboBoxTipoCarroSeleccionado.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(this, "Ingreso inválido, estado incompleto de elementos");
            
            } else {
            JOptionPane.showMessageDialog(this, "Se han guardado los cambios");
            
            ComboBoxTipoCarroSeleccionado.setSelectedIndex(0);
            Inicio.VentanaMenuAdministrador(true);
            Inicio.VentanaEditarVehiculo(false);   
                
            }

        }
        
        if(e.getSource()==TextFieldKilometraje){
            JComboBox cb=(JComboBox)e.getSource();
            TextoTL.setText((String)cb.getSelectedItem());
        }
        if(e.getSource()==ComboBoxTipoCarroSeleccionado){
            JComboBox cb=(JComboBox)e.getSource();
            TextoTipoVehículoSeleccionado.setText((String)cb.getSelectedItem());
            if("".equals((String)cb.getSelectedItem())){
                
            TextFieldEstado.setSelectedIndex(0);
            TextFieldAñoFabricacion.setText("");
            TextFieldColorSeleccionado.setText("");
            TextFieldMarcaSeleccionada.setText("");
            TextFieldKilometraje.setText("");
            TextFieldCapacidadPersonas.setText("");
            TextFieldNumeroPuertas.setText("");
             TextFieldMPG.setText(""); 
             TextFieldSede.setSelectedIndex(0);
             TextFieldCostoDiario.setText("");
             TextFieldCapacidadMaletas.setText("");
             TextFieldTransmision.setSelectedIndex(0);
             TextoImagenSeleccionado.setText("");
             TextFieldVin.setText("");
             TablaAgregarServiciosAsociados.LimpiarTabla();
             
             
             TextoImagenSeleccionado.setIcon(null);
                ComboBoxVehículoSeleccionado.removeAllItems();
                ComboBoxVehículoSeleccionado.setEnabled(false);
            }
            if(!"".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.setEnabled(true);
                TextoTipoVehículoSeleccionado.setVisible(false);
            }
            if("Compacto".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(VehículosCompacto);
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Pickup".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(VehículosPickup);
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Intermedio".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(VehículosIntermedio);
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("SUV".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(VehículosSUV);
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Mini-van".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(VehículosMinivan);
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Convertible".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(VehículosConvertible);
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Económico".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(VehículosEconómico);
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            
        }
        if(e.getSource()==ComboBoxVehículoSeleccionado){
            JComboBox cb=(JComboBox)e.getSource();
            TextoVehiculoSeleccionado.setText((String)cb.getSelectedItem());
            TextoVehiculoSeleccionado.setVisible(false);
            if(ComboBoxVehículoSeleccionado.getSelectedIndex()==0){
                        
            TextFieldAñoFabricacion.setText("");
            TextFieldColorSeleccionado.setText("");
            TextFieldMarcaSeleccionada.setText("");
            TextFieldKilometraje.setText("");
            TextFieldCapacidadPersonas.setText("");
            TextFieldNumeroPuertas.setText("");
             TextFieldMPG.setText(""); 
             TextFieldSede.setSelectedIndex(0);
             TextFieldCostoDiario.setText("");
             TextFieldCapacidadMaletas.setText("");
             TextFieldTransmision.setSelectedIndex(0);
             TextFieldEstado.setSelectedIndex(0);
             TextoImagenSeleccionado.setText("");
             TextFieldVin.setText("");
             TablaAgregarServiciosAsociados.LimpiarTabla(); 
             

             TextoImagenSeleccionado.setIcon(null);
            }
            if(ComboBoxVehículoSeleccionado.getSelectedIndex()==1){
            TextFieldAñoFabricacion.setText("2010");
            TextFieldColorSeleccionado.setText("Azul");
            TextFieldMarcaSeleccionada.setText("Honda");
            TextFieldKilometraje.setText("20000");
            TextFieldCapacidadPersonas.setText("4");
            TextFieldNumeroPuertas.setText("4");
             TextFieldMPG.setText("119"); 
             TextFieldSede.setSelectedIndex(1);;
             TextFieldCostoDiario.setText("26$/d");
             TextFieldCapacidadMaletas.setText("2 Maletas");
             TextFieldTransmision.setSelectedIndex(2);
             TextFieldEstado.setSelectedIndex(1);
             

             TextFieldVin.setText("12323");
             ImageIcon img= new ImageIcon("src\\main\\java\\img\\carro1.jpg");
             TextoImagenSeleccionado.setIcon(img);
             TextoImagenSeleccionado.setText("f");
             
             
            }
            if(ComboBoxVehículoSeleccionado.getSelectedIndex()==2){
            TextFieldAñoFabricacion.setText("2004");
            TextFieldColorSeleccionado.setText("Café");
            TextFieldMarcaSeleccionada.setText("Suzuki");
            TextFieldKilometraje.setText("50000");
            TextFieldCapacidadPersonas.setText("5");
            TextFieldNumeroPuertas.setText("2");
             TextFieldMPG.setText("131"); 
             TextFieldSede.setSelectedIndex(2);
             TextFieldCostoDiario.setText("50$/d");
             TextFieldCapacidadMaletas.setText("4 Maletas");
             TextFieldTransmision.setSelectedIndex(1);
             TextFieldEstado.setSelectedIndex(2);
             ImageIcon img= new ImageIcon("src\\main\\java\\img\\carro2.jpg");
             TextoImagenSeleccionado.setIcon(img);
             TextoImagenSeleccionado.setText("h");
             


             TextFieldVin.setText("45453");
            }
        }
     
        if(e.getSource()==TextFieldImágen){
            System.out.println("AAAAAA");
            int accion = explorer.showOpenDialog(Inicio.frameEditarVehiculo);
            if (accion == JFileChooser.APPROVE_OPTION){  
                filename = explorer.getSelectedFile().toString();
                ImageIcon img= new ImageIcon(filename);
                TextoImagenSeleccionado.setIcon(img);
            }else{
                TextoImagenSeleccionado.setText("Error, no se encuentra el archivo");
            }
        }
        
        
       //Coding Part of showPassword JCheckBox
    }
 
}